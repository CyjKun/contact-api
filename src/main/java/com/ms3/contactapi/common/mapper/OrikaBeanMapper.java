package com.ms3.contactapi.common.mapper;

import lombok.Getter;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


import java.util.Map;

class OrikaBeanMapper extends ConfigurableMapper implements ApplicationContextAware {

    public OrikaBeanMapper() {
        super(false);
    }

    @Getter
    private MapperFactory mapperFactory;

    @Getter
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        init();
    }

    @Override
    protected void configure(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
        addAllSpringBeans(applicationContext);

    }

    protected void addAllSpringBeans(ApplicationContext applicationContext) {
        Map<String, ma.glasnost.orika.Mapper> mappers = applicationContext.getBeansOfType(ma.glasnost.orika.Mapper.class);
        mappers.forEach((k, v) -> addMapper(v));

        Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
        converters.forEach((k, v) -> addConverter(v));
    }

    @SuppressWarnings("unchecked")
    private void addMapper(ma.glasnost.orika.Mapper<?, ?> mapper) {
        mapperFactory.classMap(mapper.getAType(), mapper.getBType())
                .byDefault()
                .customize((Mapper) mapper)
                .register();
    }

    private void addConverter(Converter<?, ?> converter) {
        mapperFactory.getConverterFactory()
                .registerConverter(converter);
    }
}
