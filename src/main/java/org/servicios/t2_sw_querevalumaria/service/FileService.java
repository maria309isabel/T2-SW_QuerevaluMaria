package org.servicios.t2_sw_querevalumaria.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    void guardarArchivo (MultipartFile archivo) throws Exception;
    void guardarArchivos(List<MultipartFile> archivoList) throws  Exception;

}
