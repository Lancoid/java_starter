package com.jcourse.seminar_04.command;

import com.jcourse.seminar_04.annotation.*;
import com.jcourse.seminar_04.parser.*;

import java.util.*;

/**
 * The type Command stack.
 */
public class CommandStack implements Command
{
    @Injection(arg = ArgumentType.STACK)
    private Stack<Double> stack;
    @Injection(arg = ArgumentType.PARSER)
    private Parser parser;

    @Override
    public void execute()
    {
        StringBuilder output = new StringBuilder();
        for (int x = 0; x < stack.size(); x++) {
            output.append(stack.elementAt(x) + " ");
        }

        if (parser instanceof ParserConsole) {
            System.out.println(output);
        } else if (parser instanceof ParserFile) {
            ((ParserFile) parser).printToFile(output.toString());
        }
    }
}
