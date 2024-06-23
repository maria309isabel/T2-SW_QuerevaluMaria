package org.servicios.t2_sw_querevalumaria.util;

import org.modelmapper.ModelMapper;
import org.servicios.t2_sw_querevalumaria.dto.EntityDto;
import org.springframework.stereotype.Component;

@Component

public class DtoUtil {

    public EntityDto convertirADto(Object obj, EntityDto mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }
    public Object convertirDtoAEntity(Object obj, EntityDto mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }

}
