package com.jcourse.seminar_07;

public interface ExceptionGeneratorInterface
{
    void generateNullPointerException();

    void generateClassCastException();

    void generateNumberFormatException();

    void generateStackOverflowError();

    void generateOutOfMemoryError();

    void generateMyException(String message) throws MyException;
}
