package ao.cinapse.recicla_me.services.interfaces;

import ao.cinapse.recicla_me.models.Arquivo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface ArquivoService {
    public void init();
    public Arquivo upload(MultipartFile file);
    public Resource load(String filename);
    public void eliminarTodos();
    public Stream<Path> listarTodos();
}
