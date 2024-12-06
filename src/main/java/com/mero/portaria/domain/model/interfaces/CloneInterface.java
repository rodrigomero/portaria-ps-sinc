package com.mero.portaria.domain.model.interfaces;

import com.mero.portaria.domain.utils.UtilReflection;
import org.springframework.beans.BeanUtils;

public interface CloneInterface {
    default <T> void cloneFromDTO(T dto) {
        String[] ignoredProperties = UtilReflection.getIgnoredProperties(dto);
        BeanUtils.copyProperties(dto, this, ignoredProperties);
    }
}