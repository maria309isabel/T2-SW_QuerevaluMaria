package org.servicios.t2_sw_querevalumaria.service;

import org.servicios.t2_sw_querevalumaria.model.Medico;

import java.util.List;

public interface MedicoService {

    List<Medico> findAll();

    public Medico findById(Integer idMedico);
    public Medico agregarMedico(Medico medico);
    public Medico actualizarMedico(Medico medico);

}
