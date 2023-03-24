package com.tierra_de_estrellas.tierradeestrellas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name="Dialogo")
public class Dialogue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dialogoId;
    private String nombreDialogo;
    private String descripcion;
}
