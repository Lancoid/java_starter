package com.jcourse.seminar_02.command;

import com.jcourse.seminar_02.parser.Parser;

import java.util.*;

/**
 * Вычисления корня
 */
public class CommandSqrt implements Command
{
    @Override
    public void execute(Map<String, Double> variablesMap, Stack<Double> stack, Parser parser)
    {
        try {
            stack.push(Math.sqrt(stack.pop()));
        } catch (EmptyStackException error) {
            System.out.println("Для выполнения вычисления корня не хватает аргумента");
        }
    }
}
