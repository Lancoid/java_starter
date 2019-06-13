package com.jcourse.seminar_01;

/**
 * Посмотреть значение System.getProperty("file.encoding")
 * Использовать конструктор строки для указанием кодировки
 */
public class Diy2
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        String encodingPrimary = System.getProperty("file.encoding");
        System.out.println("File encoding NOW : " + encodingPrimary);
        changeEncoding(encodingPrimary);
        String encodingChanged = System.getProperty("file.encoding");
        System.out.println("File encoding after changing : " + encodingChanged);
        changeEncoding(encodingPrimary);
        System.out.println("File encoding after revert : " + encodingPrimary);
    }

    private static void changeEncoding(String encoding)
    {
        if (encoding.equals("UTF-8")) {
            System.setProperty("file.encoding", "cp1251");
        } else {
            System.setProperty("file.encoding", "UTF-8");
        }
    }
}