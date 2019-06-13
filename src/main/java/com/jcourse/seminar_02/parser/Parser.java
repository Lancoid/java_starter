package com.jcourse.seminar_02.parser;

import com.jcourse.seminar_02.command.Command;

import java.util.ArrayList;

/**
 * The interface Parser.
 */
public interface Parser
{
    /**
     * Gets commands.
     *
     * @return the commands
     */
    ArrayList<Command> getCommands();
}