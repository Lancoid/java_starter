package com.jcourse.seminar_02.command;

import com.jcourse.seminar_02.parser.Parser;

import java.util.*;

/**
 * Вычитание
 */
public class CommandSubtraction implements Command
{
    @Override
    public void execute(Map<String, Double> variablesMap, Stack<Double> stack, Parser parser)
    {
        try {
            Double var_one = stack.pop();
            Double var_two = stack.pop();
            stack.push(var_one - var_two);
        } catch (EmptyStackException error) {
            System.out.println("Для выполнения вычитания не хватает одного или двух аргументов");
        }
    }
}
