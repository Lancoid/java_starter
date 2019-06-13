package com.jcourse.seminar_02.parser;

import com.jcourse.seminar_02.Converter;
import com.jcourse.seminar_02.command.Command;

import java.io.*;
import java.util.*;

/**
 * The type Parser file.
 */
public class ParserFile implements Parser
{
    private String fileIncoming;
    private String fileOutgoing;
    private Converter commandCreator;
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
        commandCreator = new Converter();
    }

    @Override
    public ArrayList<Command> getCommands()
    {
        try {
            String line;
            File file = new File(this.fileIncoming);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            do {
                line = reader.readLine();
                if (line != null) {
                    Command command = commandCreator.lineToCommand(line);
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
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}