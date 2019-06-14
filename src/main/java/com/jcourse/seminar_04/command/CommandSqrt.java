package com.jcourse.seminar_04.command;

import com.jcourse.seminar_04.annotation.*;

import java.util.*;

/**
 * The type Command sqrt.
 */
public class CommandSqrt implements Command
{
    @Injection(arg = ArgumentType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute()
    {
        try {
            stack.push(Math.sqrt(stack.pop()));
        } catch (EmptyStackException error) {
            System.err.println("Для выполнения вычисления корня не хватает аргумента");
        }
    }
}
