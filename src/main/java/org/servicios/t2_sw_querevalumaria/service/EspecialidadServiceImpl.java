package org.servicios.t2_sw_querevalumaria.service;


import jakarta.persistence.EntityNotFoundException;
import org.servicios.t2_sw_querevalumaria.exception.ResourceNotFoundException;
import org.servicios.t2_sw_querevalumaria.model.Especialidad;
import org.servicios.t2_sw_querevalumaria.model.Medico;
import org.servicios.t2_sw_querevalumaria.repository.EspecialidadRepository;
import org.servicios.t2_sw_querevalumaria.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired

    private EspecialidadRepository especialidadRepository;

    @Autowired

    private MedicoRepository medicoRepository;

    @Override
    public List<Especialidad> findAll() {

        return especialidadRepository.findAll();

    }

    @Override
    public Especialidad findById(Integer idEspecialidad) {

        return especialidadRepository.findById(idEspecialidad).orElseThrow(() ->
                new EntityNotFoundException("La especialidad no encontrada con el id " + idEspecialidad));

    }

    @Override
    public Especialidad agregarEspecialidad(Especialidad especialidad) {

        return especialidadRepository.save(especialidad);

    }

    @Override
    public Especialidad actualizarEspecialidad(Especialidad especialidad) {

        Especialidad especialidadExistente = especialidadRepository.findById(especialidad.getIdEspecialidad())
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada con id: " + especialidad.getIdEspecialidad()));
        especialidadExistente.setTitulo(especialidad.getTitulo());
        especialidadExistente.setFuncion(especialidad.getFuncion());
        especialidadExistente.setFechaGraduacion(especialidad.getFechaGraduacion());
        Medico nuevoMedico = especialidad.getMedico();
        if (nuevoMedico != null) {
            Medico medicoExistente = medicoRepository.findById(nuevoMedico.getIdMedico())
                    .orElseThrow(() -> new ResourceNotFoundException("Medico no encontrado con id: " + nuevoMedico.getIdMedico()));

            especialidadExistente.setMedico(medicoExistente);
        }

        return especialidadRepository.save(especialidadExistente);
    }

}
