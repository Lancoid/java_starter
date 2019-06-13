package com.jcourse.seminar_02.command;

import com.jcourse.seminar_02.parser.Parser;

import java.util.*;

/**
 * The type Command define.
 */
public class CommandPush implements Command
{
    private String variable;
    private Double value;

    /**
     * Instantiates a new Command define.
     *
     * @param variable the variable
     * @param value    the value
     */
    public CommandPush(String variable, Double value)
    {
        this.variable = variable;
        this.value = value;
    }

    @Override
    public void execute(Map<String, Double> variablesMap, Stack<Double> stack, Parser parser)
    {
        if (variable != null) {
            if (variablesMap.containsKey(variable)) {
                stack.push(variablesMap.get(variable));
            } else {
                System.out.println("В HashMap нет запрашиваемого ключа - " + variable);
            }
        } else {
            stack.push(value);
        }
    }
}
