package ao.cinapse.recicla_me.controllers;

import ao.cinapse.recicla_me.controllers.base.BaseController;
import ao.cinapse.recicla_me.http.ResponseBody;
import ao.cinapse.recicla_me.http.dtos.ArquivoDTO;
import ao.cinapse.recicla_me.models.Arquivo;

import ao.cinapse.recicla_me.services.implementacao.ArquivoServiceImpl;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/arquivo")
public class ArquivoController extends BaseController<ResponseBody, ArquivoDTO, Arquivo, UUID, ArquivoServiceImpl>
{
    @PostMapping("/upload")
    public ResponseEntity<ResponseBody> upload(@RequestParam("arquivo") MultipartFile file)
    {
        try {
            Arquivo arquivo = this.getService().upload(file);
            arquivo = this.getService().criar(arquivo);
            return this.ok("Arquivo carregado com sucesso.", ArquivoDTO.builder().build().parse(arquivo));
        }
        catch (Exception e) {
            return this.excepctationFailed(e.getMessage(), new ArrayList<>());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<ResponseBody> listar()
    {
        List<Arquivo> files = getService().listarTodos().map( path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                            .fromMethodName(ArquivoController.class, "getFile", path.getFileName().toString())
                            .build().toString();

            return Arquivo.builder()
                    .fileName(filename)
                    .path(url)
                    .build();
        }).collect(Collectors.toList());

        return this.ok("Lista de todos arquivos...", files);
    }


    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        try
        {
            Resource resource = getService().load(filename);
            return ResponseEntity.ok().header(
                            HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                            .body(resource);
        }
        catch (Exception ex) {
            return this.naoEncontrado("Não foi possível encontrar a imagem.", new ArrayList<>());
        }
    }

}
