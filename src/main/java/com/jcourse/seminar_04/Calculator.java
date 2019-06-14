package com.jcourse.seminar_04;

import com.jcourse.seminar_04.command.Command;
import com.jcourse.seminar_04.parser.*;

import java.util.*;

/**
 * The type Calculator.
 */
public class Calculator {
    /**
     * Написать стэковый калькулятор
     * <p>
     * 1) который принимает в качестве аргумента командой строки имя файла содержащего команды
     * 2) если нет аргумента, то использовать стандартный ввод для чтения команд.
     * <p>
     * Использовать вещественные числа.
     * <p>
     * Реализовать следующий набор команд:
     * # -------------------  строка комментарий
     * POP, PUSH -----------  работа со стэком
     * + , - , * , /, sqrt -  арифметические операции
     * Используют один или два верхних элемента стека,
     * изымают их из стека, помещая результат назад
     * PRINT ---------------  печать верхнего элемента стека (без удаления из стека)
     * DEFINE --------------  задать значение параметра.
     * в дальнейшем везде использовать вместо параметра это значение.
     * <p>
     * Например:
     * DEFINE a 4
     * PUSH a
     * SQRT
     * PRINT
     * Должно вывести 2
     * <p>
     * Написать Unit test который будет исполнять тестовую программу
     * для решения квадратного уравнения с помощью данного калькулятора по формуле:
     * --- X1 = (-b + sqrt(b*b – 4ac)) / 2a
     * --- X2 = (-b - sqrt(b*b – 4ac)) / 2a
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Parser parser;

        if (args.length == 0) {
            parser = new ParserConsole();
        } else {
            parser = new ParserFile(args[0], args[1]);
        }

        Stack<Double> stack = new Stack<>();
        Map<String, Double> variablesMap = new HashMap<>();

        ArrayList<Command> commands = parser.getCommands(parser, stack, variablesMap);
        for (Command command : commands) {
            command.execute();
        }
    }
}