package com.fitness.authservice.config;

import com.fitness.authservice.model.Unit;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitEnumConverter implements Converter<String, Unit> {
    @Override
    public Unit convert(String source) {
        try {
            return Unit.valueOf(source);
        } catch (Exception e) {
            return null; // or SortEnum.asc
        }
    }
}