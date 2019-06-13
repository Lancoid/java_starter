package com.jcourse.seminar_03.parser;

import com.jcourse.seminar_03.command.*;

import java.io.*;
import java.util.*;

/**
 * The type Parser file.
 */
public class ParserFile implements Parser
{
    private String fileIncoming;
    private String fileOutgoing;
    private ArrayList<Command> commands = new ArrayList<>();

    /**
     * Instantiates a new Parser file.
     *
     * @param argIncoming the arg incoming
     * @param argOutgoing the arg outgoing
     */
    public ParserFile(String argIncoming, String argOutgoing)
    {
        fileIncoming = argIncoming;
        fileOutgoing = argOutgoing;
    }

    @Override
    public ArrayList<Command> getCommands(Parser parser, Stack<Double> stack, Map<String, Double> variablesMap)
    {
        Factory factory = new Factory(parser, stack, variablesMap);
        try {
            String line;
            File file = new File(this.fileIncoming);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            do {
                line = reader.readLine();
                if (line != null && !"#".equals(String.valueOf(line.charAt(0)))) {
                    Command command = factory.getCommand(line);
                    if (command != null) {
                        commands.add(command);
                    }
                }
            }
            while (line != null);
        } catch (IOException error) {
            error.printStackTrace();
        }

        return commands;
    }

    /**
     * Print to file.
     *
     * @param value the value
     */
    public void printToFile(String value)
    {
        try (FileWriter writer = new FileWriter(fileOutgoing, true)) {
            writer.write(value);
            writer.append('\n');
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}