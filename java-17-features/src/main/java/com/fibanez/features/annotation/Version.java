package com.fibanez.features.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR,
        ElementType.METHOD, ElementType.MODULE,
        ElementType.PACKAGE, ElementType.LOCAL_VARIABLE,
        ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Version {
    int major();
    int minor() default 0; // Set zero as default value
    // for minor
}
