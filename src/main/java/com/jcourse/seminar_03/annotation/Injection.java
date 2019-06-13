package com.jcourse.seminar_03.annotation;

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