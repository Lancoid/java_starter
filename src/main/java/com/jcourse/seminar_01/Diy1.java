package com.jcourse.seminar_01;

import java.io.Console;
import java.util.Scanner;

/**
 * Написать программу "эхо" (чтение и печать текста из консоли).
 * Запустить её как из IDEA, так и из командной строки.
 * Проверить работу с русским языком в обоих случаях.
 * Использовать: Console, System.console или System.in (если нет консоли)
 *
 * КОМПИЛЯЦИЯ - javac -d bin /var/www/java/seminar/src/com/jcourse/seminar_01/Diy1.java
 * ИСПОЛНЕНИЕ - java -classpath ./bin com/jcourse/seminar_01/Diy1
 */
public class Diy1 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            Scanner scanner = new Scanner(System.in);
            scannerIn(scanner);
        } else {
            consoleIn(console);
        }
    }

    private static void scannerIn(Scanner scanner) {
        System.out.println(" --- Исполнение метода scannerIn --- ");
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        if (checkForEmptiness(text)) {
            scannerIn(scanner);
        }
    }

    private static void consoleIn(Console console) {
        System.out.println(" --- Исполнение метода consoleIn --- ");
        String text = console.readLine("Введите текст: ");
        if (checkForEmptiness(text)) {
            consoleIn(console);
        }
    }

    private static boolean checkForEmptiness(String text) {
        if (text.isEmpty()) {
            System.out.println("Вы не ввели никакого текста! Заново!");
            return true;
        } else {
            System.out.println("Введённый текст: " + text + ".");
            return false;
        }
    }
}