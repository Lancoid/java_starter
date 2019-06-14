package com.jcourse.seminar_04.annotation;

import java.lang.annotation.*;

/**
 * The interface Injection.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Injection
{
    /**
     * Arg argument type.
     *
     * @return the argument type
     */
    ArgumentType arg();
}