package org.servicios.t2_sw_querevalumaria.service;

import jakarta.persistence.EntityNotFoundException;
import org.servicios.t2_sw_querevalumaria.model.Medico;
import org.servicios.t2_sw_querevalumaria.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MedicoServiceImpl implements MedicoService {

    @Autowired

    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> findAll() {

        return medicoRepository.findAll();

    }

    @Override
    public Medico findById(Integer idMedico) {

        return medicoRepository.findById(idMedico).orElseThrow(() -> new
                EntityNotFoundException("El id de medico no fue encontrado " +idMedico));

    }

    @Override
    public Medico agregarMedico(Medico medico) {

        return medicoRepository.save(medico);

    }

    @Override
    public Medico actualizarMedico(Medico medico) {

        var MedicoA = medicoRepository.findById(medico.getIdMedico()).get();

        MedicoA.setNomMedico(medico.getNomMedico());
        MedicoA.setApeMedico(medico.getApeMedico());
        MedicoA.setFechaNacMedico(medico.getFechaNacMedico());

        return medicoRepository.save(medico);

    }
}
