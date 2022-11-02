package com.fibanez.features.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface ChangeLogs {
    ChangeLogRepeatable[] value();
}
