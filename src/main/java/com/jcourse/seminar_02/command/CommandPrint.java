package com.jcourse.seminar_02.command;

import com.jcourse.seminar_02.parser.Parser;
import com.jcourse.seminar_02.parser.*;

import java.util.*;

/**
 * The type Command define.
 */
public class CommandPrint implements Command
{
    @Override
    public void execute(Map<String, Double> variablesMap, Stack<Double> stack, Parser parser)
    {
        if (parser instanceof ParserConsole) {
            System.out.println(stack.peek());
        } else if (parser instanceof ParserFile) {
            ((ParserFile) parser).printToFile(String.valueOf(stack.peek()));
        }
    }
}
