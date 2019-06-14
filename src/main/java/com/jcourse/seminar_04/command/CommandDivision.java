package com.jcourse.seminar_04.command;

import com.jcourse.seminar_04.annotation.*;

import java.util.*;

/**
 * The type Command division.
 */
public class CommandDivision implements Command
{
    @Injection(arg = ArgumentType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute()
    {
        try {
            Double var_one = stack.pop();
            Double var_two = stack.pop();
            stack.push(var_one / var_two);
        } catch (EmptyStackException error) {
            System.err.println("Для выполнения деления не хватает одного или двух аргументов");
        }
    }
}
