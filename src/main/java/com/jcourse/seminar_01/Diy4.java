package com.jcourse.seminar_01;

import java.io.*;
import java.util.*;

/**
 * Написать стэковый калькулятор
 *
 * 1) который принимает в качестве аргумента командой строки имя файла содержащего команды
 * 2) если нет аргумента, то использовать стандартный ввод для чтения команд.
 *
 * Использовать вещественные числа.
 *
 * Реализовать следующий набор команд:
 * # -------------------  строка комментарий
 * POP, PUSH -----------  работа со стэком
 * + , - , * , /, sqrt -  арифметические операции
 * Используют один или два верхних элемента стека,
 * изымают их из стека, помещая результат назад
 * PRINT ---------------  печать верхнего элемента стека (без удаления из стека)
 * DEFINE --------------  задать значение параметра.
 * в дальнейшем везде использовать вместо параметра это значение.
 *
 * Например:
 * DEFINE a 4
 * PUSH a
 * SQRT
 * PRINT
 * Должно вывести 2
 *
 * Написать Unit test который будет исполнять тестовую программу
 * для решения квадратного уравнения с помощью данного калькулятора по формуле:
 * X1 = (-b + sqrt(b*b – 4ac)) / 2a
 * X2 = (-b - sqrt(b*b – 4ac)) / 2a
 */
public class Diy4
{
    private static Stack<Double> stack;
    private static Map<String, Double> valueMap;
    static {
        stack = new Stack<>();
        valueMap = new HashMap<>();
    }
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        if (args.length > 0) {
            if (args[0] != null) {
                String fileWithPath = args[0];
                text(fileWithPath);
            }
        } else {
            console();
        }
    }

    /**
     * Файловая обработка
     *
     * запих в калькулятор строки файла
     * выпих результата команды
     */
    private static void text(String fileWithPath)
    {
        String response;
        String[] pieces;
        String line;

        try {
            File file = new File(fileWithPath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            do {
                line = reader.readLine();
                if (line != null) {
                    /* разбиваем на массив (0 - команда, 1 - переменная, 2 - число) */
                    pieces = line.split(" ");
                    response = calculator(pieces);
                    System.out.println("Ответ -> " + response);
                }
            }
            while (line != null);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /**
     * Консольная обработка
     *
     * запих в калькулятор через строку консоли
     * выпих результата команды
     */
    private static void console()
    {
        Scanner scanner;
        scanner = new Scanner(System.in);
        String response;
        String[] pieces;
        String input;

        do {
            System.out.print("Запрос: ");
            input = scanner.nextLine().trim().toLowerCase();
            /* разбиваем на массив (0 - команда, 1 - переменная, 2 - число) */
            pieces = input.split(" ");
            response = calculator(pieces);
            System.out.println("Ответ -> " + response);
        } while (!(input.equals("exit")));
    }

    /**
     * Калькулятор как он есть
     */
    private static String calculator(String[] peices)
    {
        Double value;
        String var;
        Double valueOperationOne;
        Double valueOperationTwo;

        try {
            switch (peices[0]) {
                case "define":
                    var = String.valueOf(peices[1]);
                    value = Double.valueOf(peices[2]);
                    valueMap.put(var, value);
                    return "определено " + var + " = " + value + ".";
                case "push":
                    var = String.valueOf(peices[1]);
                    stack.push(valueMap.get(var));
                    return "добавлено в стэк " + stack.lastElement() + " (переменная: " + var + ").";
                case "print":
                    return "содержимое стека: " + stack;
                case "+":
                    valueOperationOne = stack.remove(0);
                    valueOperationTwo = stack.remove(0);
                    stack.push(valueOperationOne + valueOperationTwo);
                    return "результат сложения: " + stack.lastElement();
                case "-":
                    valueOperationOne = stack.remove(0);
                    valueOperationTwo = stack.remove(0);
                    stack.push(valueOperationOne - valueOperationTwo);
                    return "результат вычитания: " + stack.lastElement();
                case "*":
                    valueOperationOne = stack.remove(0);
                    valueOperationTwo = stack.remove(0);
                    stack.push(valueOperationOne * valueOperationTwo);
                    return "результат умножения: " + stack.lastElement();
                case "/":
                    valueOperationOne = stack.remove(0);
                    valueOperationTwo = stack.remove(0);
                    stack.push(valueOperationOne / valueOperationTwo);
                    return "результат деления: " + stack.lastElement();
                case "sqrt":
                    valueOperationOne = stack.remove(0);
                    stack.push(Math.sqrt(valueOperationOne));
                    return "результат вычисления корня: " + stack.lastElement();
                case "pow2":
                    valueOperationOne = stack.remove(0);
                    stack.push(Math.pow(valueOperationOne, 2));
                    return "результат вычисления квадрата: " + stack.lastElement();
                case "#":
                    return "Комментарий: " + String.join(" ", peices);
                case "exit":
                    return "до новых встреч.";
                default:
                    return "неверная команда";
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            return "проверьте стек, чего-то не хватает для выполнения команды.";
        }
    }
}
