package org.servicios.t2_sw_querevalumaria.controller;

import lombok.AllArgsConstructor;
import org.servicios.t2_sw_querevalumaria.dto.ArchivoDto;
import org.servicios.t2_sw_querevalumaria.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/archivos")

public class ControllerFile {

    private FileService fileService;

    @PostMapping()
    public ResponseEntity<ArchivoDto> subirArchivos(
            @RequestParam("files") List<MultipartFile> multipartFileList
    ) throws Exception{
        fileService.guardarArchivos(multipartFileList);
        return new ResponseEntity<>(ArchivoDto.builder()
                .mensaje("Archivos subidos correctamente").build(),
                HttpStatus.OK);
    }

}