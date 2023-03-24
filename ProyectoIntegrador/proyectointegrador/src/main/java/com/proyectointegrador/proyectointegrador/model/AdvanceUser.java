package com.proyectointegrador.proyectointegrador.model;

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
@Entity(name="Avance_Desafio")

public class AdvanceUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer avanceDesafioId;
    
}
