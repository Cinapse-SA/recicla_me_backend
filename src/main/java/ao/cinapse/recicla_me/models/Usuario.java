/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.cinapse.recicla_me.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author ivandro.sousa
 */
@Getter
@Setter
@ToString
@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue
    private UUID idUsuario;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = true)
    private String email;
    
    @Column(nullable = true)
    private String telefone;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "idPessoa", name = "id_pessoa", nullable = false)
    private Pessoa idPessoa;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "idTipoUsuario", name = "id_tipo_usuario", nullable = false)
    private TipoUsuario idTipoUsuario;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isContaExpired;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isContaLocked;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isContaEnabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isContaExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isContaExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isContaExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isContaEnabled;
    }
}
