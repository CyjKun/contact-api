package com.ms3.contactapi.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Repository;

@Repository
public @interface DataRepository {

    @AliasFor(annotation = Repository.class)
    String value() default "";
}
