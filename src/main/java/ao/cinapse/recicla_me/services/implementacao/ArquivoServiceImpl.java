package ao.cinapse.recicla_me.services.implementacao;

import ao.cinapse.recicla_me.models.Arquivo;
import ao.cinapse.recicla_me.services.ArquivoService;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ArquivoServiceImpl extends AbstractService<Arquivo, UUID> implements ArquivoService {
    private final Path root = Paths.get("uploads");

    @Override
    public void init(){
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível criar os directórios.");
        }
    }

    @Override
    public Arquivo upload(MultipartFile file) {
        try {
            String[] partsFilename = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
            String extension = partsFilename[ partsFilename.length - 1];
            String filename = UUID.randomUUID().toString()+"."+extension;
            Path path = this.root.resolve(Objects.requireNonNull( filename ));
            final Path finalPath = this.root.resolve(filename);
            Files.copy(file.getInputStream(), finalPath);

            return  Arquivo.builder()
                    .fileName(filename)
                    .folder( root.toString() )
                    .fileExtension(partsFilename[1])
                    .size(String.valueOf(file.getSize())+" bytes")
                    .path(finalPath.toString())
                    .build();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
            if ( e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("Este arquivo já existe.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if ( resource.exists() || resource.isReadable()) {
                return resource;
            }
            throw new RuntimeException("Arquivo não encontrado.");
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(String.format("Não foi possível carregar o arquivo: %s", e.getMessage()));
        }
    }

    @Override
    public void eliminarTodos() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> listarTodos() {
        try {
            Stream<Path> paths = Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
            return paths;
        }
        catch (IOException e) {
            throw new RuntimeException("Não foi possível listar os arquivos");
        }
    }


}
