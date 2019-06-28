package com.jcourse.seminar_07;

import java.util.*;

public class ExceptionGenerator implements ExceptionGeneratorInterface
{

    @Override
    public void generateNullPointerException()
    {
        Scanner scanner = null;
        scanner.toString();
    }

    @Override
    public void generateClassCastException()
    {
        List list = new ArrayList();
        list.add(5);

        for (Object obj : list) {
            String string = (String) obj;
        }
    }

    @Override
    public void generateNumberFormatException()
    {
        int integer = Integer.parseInt("12345qwerty");
    }

    @Override
    public void generateStackOverflowError()
    {
        this.generateStackOverflowError();
    }

    @Override
    public void generateOutOfMemoryError()
    {
        int[] longArray = new int[Integer.MAX_VALUE];
    }

    @Override
    public void generateMyException(String message) throws MyException
    {
        throw new MyException(message);
    }
}
