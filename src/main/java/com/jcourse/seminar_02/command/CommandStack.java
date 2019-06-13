package com.jcourse.seminar_02.command;

import com.jcourse.seminar_02.parser.Parser;
import com.jcourse.seminar_02.parser.*;

import java.util.*;

/**
 * The type Command define.
 */
public class CommandStack implements Command
{
    @Override
    public void execute(Map<String, Double> variablesMap, Stack<Double> stack, Parser parser)
    {
        StringBuilder output = new StringBuilder();
        for (int x = 0; x < stack.size(); x++) {
            output.append(stack.elementAt(x));
        }
        if (parser instanceof ParserConsole) {
            System.out.println(output);
        } else if (parser instanceof ParserFile) {
            ((ParserFile) parser).printToFile(output.toString());
        }
    }
}
