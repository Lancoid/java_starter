package com.jcourse.seminar_02.command;

import com.jcourse.seminar_02.parser.Parser;

import java.util.*;

/**
 * The interface Command.
 */
public interface Command
{
    /**
     * Execute.
     *
     * @param variablesMap the variables map
     * @param stack        the stack
     * @param parser       the parser
     */
    void execute(Map<String, Double> variablesMap, Stack<Double> stack, Parser parser);
}