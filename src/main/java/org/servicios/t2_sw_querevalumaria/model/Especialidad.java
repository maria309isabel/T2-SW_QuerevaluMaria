package org.servicios.t2_sw_querevalumaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "Especialidad")

public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidad;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Funcion")
    private String funcion;
    @Column(name = "FechGraduacion")
    private Date fechaGraduacion;

    @OneToOne
    @JoinColumn(name = "IdMedico", referencedColumnName = "idMedico", unique = true)
    private Medico medico;

}