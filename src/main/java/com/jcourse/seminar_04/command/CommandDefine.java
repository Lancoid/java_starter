package com.jcourse.seminar_04.command;

import com.jcourse.seminar_04.annotation.*;

import java.util.*;

/**
 * The type Command define.
 */
public class CommandDefine implements Command
{
    @Injection(arg = ArgumentType.VARIABLES)
    private Map<String, Double> variablesMap;
    @Injection(arg = ArgumentType.ARGUMENTS)
    private String[] arguments;

    @Override
    public void execute()
    {
        variablesMap.put(String.valueOf(arguments[1]), Double.valueOf(arguments[2]));
    }
}
