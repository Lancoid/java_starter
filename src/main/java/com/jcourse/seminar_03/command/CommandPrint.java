package com.jcourse.seminar_03.command;

import com.jcourse.seminar_03.annotation.*;
import com.jcourse.seminar_03.parser.*;

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
