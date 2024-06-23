package org.servicios.t2_sw_querevalumaria.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data

public class MensajeErrorDto {

    private Integer codigoEstado;
    private Date fechaError;
    private String mensaje;
    private String descripcion;

}
