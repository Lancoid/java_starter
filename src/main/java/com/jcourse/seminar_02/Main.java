package com.jcourse.seminar_02;

import com.jcourse.seminar_02.parser.*;

/**
 * The type Calculator.
 */
public class Main
{
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
     * * X1 = (-b + sqrt(b*b – 4ac)) / 2a
     * * X2 = (-b - sqrt(b*b – 4ac)) / 2a
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        Parser parser;
        Calculator calc;

        if (args.length == 0) {
            parser = new ParserConsole();
        } else {
            parser = new ParserFile(args[0], args[1]);
        }

        calc = new Calculator(parser);
        calc.execute();
    }
}