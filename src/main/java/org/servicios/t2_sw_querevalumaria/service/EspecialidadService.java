package org.servicios.t2_sw_querevalumaria.service;

import org.servicios.t2_sw_querevalumaria.model.Especialidad;

import java.util.List;

public interface EspecialidadService {

    public List<Especialidad> findAll();
    public Especialidad findById(Integer idEspecialidad);
    public Especialidad agregarEspecialidad (Especialidad especialidad);
    public Especialidad actualizarEspecialidad(Especialidad especialidad);

}
