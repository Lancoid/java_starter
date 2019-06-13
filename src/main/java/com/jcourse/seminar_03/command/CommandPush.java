package com.jcourse.seminar_03.command;

import com.jcourse.seminar_03.annotation.*;

import java.util.*;

/**
 * The type Command push.
 */
public class CommandPush implements Command
{
    @Injection(arg = ArgumentType.STACK)
    private Stack<Double> stack;
    @Injection(arg = ArgumentType.VARIABLES)
    private Map<String, Double> variablesMap;
    @Injection(arg = ArgumentType.ARGUMENTS)
    private String[] arguments;

    @Override
    public void execute()
    {
        if (!isNumeric(arguments[1])) {
            String variable = arguments[1];
            if (variablesMap.containsKey(variable)) {
                stack.push(variablesMap.get(variable));
            } else {
                System.err.println("В HashMap нет запрашиваемого ключа - " + variable);
            }
        } else {
            stack.push(Double.valueOf(arguments[1]));
        }
    }

    private static boolean isNumeric(String string)
    {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
