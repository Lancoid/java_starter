package com.jcourse.seminar_03.parser;

import com.jcourse.seminar_03.command.Command;

import java.util.*;

/**
 * The interface Parser.
 */
public interface Parser
{
    /**
     * Gets commands.
     *
     * @param parser       the parser
     * @param stack        the stack
     * @param variablesMap the variables map
     *
     * @return the commands
     */
    ArrayList<Command> getCommands(Parser parser, Stack<Double>stack, Map<String, Double>variablesMap);
}