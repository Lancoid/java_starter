package com.jcourse.seminar_02;

import com.jcourse.seminar_02.command.Command;
import com.jcourse.seminar_02.parser.Parser;

import java.util.*;

/**
 * The type Calculator.
 */
class Calculator
{
    private Parser parser;
    private Stack<Double> stack;
    private Map<String, Double> variablesMap;

    /**
     * Instantiates a new Calculator.
     *
     * @param parser the parser
     */
    Calculator(Parser parser)
    {
        this.parser = parser;
        this.stack = new Stack<>();
        this.variablesMap = new HashMap<>();
    }

    /**
     * Execute.
     */
    void execute()
    {
        ArrayList<Command> commands = parser.getCommands();
        for (Command command : commands) {
            command.execute(variablesMap, stack, parser);
        }
    }
}
