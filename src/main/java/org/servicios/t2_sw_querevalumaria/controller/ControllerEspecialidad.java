package org.servicios.t2_sw_querevalumaria.controller;

import org.servicios.t2_sw_querevalumaria.model.Especialidad;
import org.servicios.t2_sw_querevalumaria.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class ControllerEspecialidad {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/listarEspecialidad")
    public ResponseEntity<List<Especialidad>> findAll() {

        return new ResponseEntity<>(especialidadService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/listarPorId/{idEspecialidad}")

    public ResponseEntity<Especialidad> findById(@PathVariable Integer idEspecialidad) {

        return new ResponseEntity<>(especialidadService.findById(idEspecialidad), HttpStatus.OK);

    }

    @PostMapping("/agregarEspecialidad")

    public ResponseEntity<Especialidad> agregarEspecialidad(@RequestBody Especialidad especialidad) {

        return new ResponseEntity<>(especialidadService.agregarEspecialidad(especialidad), HttpStatus.CREATED);

    }

    @PutMapping("/actualizarEspecialidad")

    public ResponseEntity<Especialidad> actualizarEspecialidad (@RequestBody Especialidad especialidad) {

        return new ResponseEntity<>(especialidadService.actualizarEspecialidad(especialidad), HttpStatus.OK);

    }

}

