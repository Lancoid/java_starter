package com.jcourse.seminar_03.command;

import com.jcourse.seminar_03.annotation.*;

import java.util.*;

/**
 * The type Command multiplication.
 */
public class CommandMultiplication implements Command
{
    @Injection(arg = ArgumentType.STACK)
    private Stack<Double> stack;

    @Override
    public void execute()
    {
        try {
            Double var_one = stack.pop();
            Double var_two = stack.pop();
            stack.push(var_one * var_two);
        } catch (EmptyStackException error) {
            System.err.println("Для выполнения умножения не хватает одного или двух аргументов");
        }
    }
}
