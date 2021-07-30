package com.ms3.contactapi.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Component
public @interface BeanMapper {

    @AliasFor(annotation = Component.class)
    String value() default "";
}
