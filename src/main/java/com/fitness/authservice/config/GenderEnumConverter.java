package com.fitness.authservice.config;

import com.fitness.authservice.model.Gender;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenderEnumConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        try {
            return Gender.valueOf(source);
        } catch (Exception e) {
            return null; // or SortEnum.asc
        }
    }
}
