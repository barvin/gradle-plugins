package com.example.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface TestCase {
    /**
     * JIRA ID of the corresponding Test Case
     */
    String[] value();
}
