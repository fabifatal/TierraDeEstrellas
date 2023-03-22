package com.proyectointegrador.proyectointegrador.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity(name = "Usuario")

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull

    private Long usuarioId;
    private String nombreUsuario;
    private String apodo;
    private Integer edad;
    private char sexo;
    private String contraseña;
    private String correo;

    @Column(name = "nombre_usuario")
    @Size(min = 5, message = "Debe introducir mínimo 5 caractéres")
    private String username;

    @Size(min = 8, message = "Debe introducir mínimo 8 caractéres")
    private String password;

    private boolean accountNonLocked;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "Read");
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean getAccountNonLocked() {
        return accountNonLocked;
    } 

}
