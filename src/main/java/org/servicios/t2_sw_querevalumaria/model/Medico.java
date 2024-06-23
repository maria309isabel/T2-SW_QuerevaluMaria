package org.servicios.t2_sw_querevalumaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "Medico")

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;
    @Column(name = "NomMedico")
    private String nomMedico;
    @Column(name = "ApeMedico")
    private String apeMedico;
    @Column(name = "FechNacMedico")
    private Date fechaNacMedico;


}