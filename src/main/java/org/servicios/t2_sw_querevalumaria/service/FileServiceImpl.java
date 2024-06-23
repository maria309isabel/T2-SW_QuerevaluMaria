package org.servicios.t2_sw_querevalumaria.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service

public class FileServiceImpl implements FileService {
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "png", "docx");
    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        if (archivo.getSize() > 25 * 1024 * 1024) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El archivo se excidio el tamaño máximo permitido que es 25MB");
        }
    }
    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {
        if (archivosList.size() != 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tiene que subir exactamente 3 archivos");
        }

        for (MultipartFile archivo : archivosList) {
            String extension = StringUtils.getFilenameExtension(archivo.getOriginalFilename()).toLowerCase();
            if (!ALLOWED_EXTENSIONS.contains(extension)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Archivo con extensión no permitida: " + extension);
            }
        }
    }

}
