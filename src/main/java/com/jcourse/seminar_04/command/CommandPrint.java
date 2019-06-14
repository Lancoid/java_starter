package com.jcourse.seminar_04.command;

import com.jcourse.seminar_04.annotation.*;
import com.jcourse.seminar_04.parser.*;

import java.util.Stack;

/**
 * The type Command print.
 */
public class CommandPrint implements Command
{
    @Injection(arg = ArgumentType.STACK)
    private Stack<Double> stack;

    @Injection(arg = ArgumentType.PARSER)
    private Parser parser;

    @Override
    public void execute()
    {
        if (parser instanceof ParserConsole) {
            System.out.println(stack.peek());
        } else if (parser instanceof ParserFile) {
            ((ParserFile) parser).printToFile(String.valueOf(stack.peek()));
        }
    }
}
