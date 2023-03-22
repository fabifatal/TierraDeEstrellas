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
@Entity(name="Info_Inicial")
public class InfoInitial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoInicialId;
    private String noticias;
    private String mision;
    private String vision;
    private String registrate;
    private String contacto;
    private String novedades;
}
