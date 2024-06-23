package org.servicios.t2_sw_querevalumaria.controller;

import org.servicios.t2_sw_querevalumaria.model.Medico;
import org.servicios.t2_sw_querevalumaria.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ControllerMedico {

    @Autowired

    private MedicoService medicoService;

    @GetMapping("/listarMedico")
    public ResponseEntity<List<Medico>> findAll() {

        return new ResponseEntity<>(medicoService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/listarPorId/{idMedico}")

    public ResponseEntity<Medico> findById(@PathVariable Integer idMedico) {

        return new ResponseEntity<>(medicoService.findById(idMedico), HttpStatus.OK);

    }

    @PostMapping("/agregarMedico")

    public ResponseEntity<Medico> agregarMedico(@RequestBody Medico medico) {

        return new ResponseEntity<>(medicoService.agregarMedico(medico), HttpStatus.CREATED);

    }

    @PutMapping("/actualizarMedico")

    public ResponseEntity<Medico> actualizarMedico (@RequestBody Medico medico) {

        return new ResponseEntity<>(medicoService.actualizarMedico(medico), HttpStatus.OK);

    }

}
