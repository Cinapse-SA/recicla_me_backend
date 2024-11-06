package ao.cinapse.recicla_me.core.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "arquivos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Arquivo {

    @Id
    @GeneratedValue
    private UUID idArquivo;
    private String path;
    private String fileExtension;
    private String file;
    private String size;
    private String fileName;
    private String folder;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private LocalDateTime deletedAt;


    @PrePersist
    public void init() {
        if ( this.createdAt == null )
            this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
