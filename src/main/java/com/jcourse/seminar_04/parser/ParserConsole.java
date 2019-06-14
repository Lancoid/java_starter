package com.jcourse.seminar_04.parser;

import com.jcourse.seminar_04.command.*;

import java.io.*;
import java.util.*;

/**
 * The type Parser console.
 */
public class ParserConsole implements Parser
{
    private Console console;
    private Scanner scanner;
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
    }

    @Override
    public ArrayList<Command> getCommands(Parser parser, Stack<Double> stack, Map<String, Double> variablesMap)
    {
        Factory factory = new Factory(parser, stack, variablesMap);
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

                if (!line.equals("exit") && !"#".equals(String.valueOf(line.charAt(0)))) {
                    command = factory.getCommand(line);
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


