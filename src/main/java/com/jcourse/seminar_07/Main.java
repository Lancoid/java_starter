package com.jcourse.seminar_07;

public class Main
{
    public static void main(String[] args)
    {
//        new ExceptionGenerator().generateNullPointerException();
//
//        new ExceptionGenerator().generateClassCastException();
//
//        new ExceptionGenerator().generateNumberFormatException();
//
//        new ExceptionGenerator().generateStackOverflowError();
//
//        new ExceptionGenerator().generateOutOfMemoryError();

        try {
            new ExceptionGenerator().generateMyException("Ошибка");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
