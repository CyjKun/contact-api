package com.ms3.contactapi.common.mapper;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ServiceMapper extends OrikaBeanMapper {

    /**
     * Creates a function that maps S to D, used to aid functional programming syntax.
     *
     * @param type Destination type.
     * @param <S>  Source type.
     * @param <D>  Destination type.
     * @return A new mapper function that maps S to D.
     */
    public <S, D> Function<S, D> mappingFunction(Class<D> type) {
        return (S source) -> map(source, type);
    }
}
