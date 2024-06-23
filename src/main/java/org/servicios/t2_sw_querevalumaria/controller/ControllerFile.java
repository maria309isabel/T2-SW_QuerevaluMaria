package org.servicios.t2_sw_querevalumaria.controller;

import org.servicios.t2_sw_querevalumaria.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Controller
public class ControllerFile {
    private final FileService fileService;
    @Autowired
    public ControllerFile(FileService fileService) {
        this.fileService = fileService;
    }
    @PostMapping("/files")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        try {
            fileService.guardarArchivos(Arrays.asList(files));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.ok("Los archivos se subio con éxito");
    }
    @PostMapping("/file")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.guardarArchivo(file);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.ok("Archivo subido con éxito");
    }
}