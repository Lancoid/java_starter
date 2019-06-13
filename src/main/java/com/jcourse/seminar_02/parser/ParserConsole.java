package com.jcourse.seminar_02.parser;

import com.jcourse.seminar_02.Converter;
import com.jcourse.seminar_02.command.Command;

import java.io.*;
import java.util.*;

/**
 * The type Parser console.
 */
public class ParserConsole implements Parser
{
    private Console console;
    private Scanner scanner;
    private Converter commandCreator;
    private ArrayList<Command> commands = new ArrayList<>();

    /**
     * Instantiates a new Parser console.
     */
    public ParserConsole()
    {
        console = System.console();
        if (console == null) {
            scanner = new Scanner(System.in);
        }
        commandCreator = new Converter();
    }

    @Override
    public ArrayList<Command> getCommands()
    {
        try {
            String line;
            Command command;
            do {
                if (console == null) {
                    System.out.print("Запрос: ");
                    line = scanner.nextLine().trim().toLowerCase();
                } else {
                    line = console.readLine("Запрос: ").trim().toLowerCase();
                }

                if (!line.equals("exit")) {
                    command = commandCreator.lineToCommand(line);
                    if (command != null) {
                        commands.add(command);
                    }
                }
            }
            while (!line.equals("exit"));
        } catch (Exception error) {
            error.printStackTrace();
        }
        return commands;
    }
}


