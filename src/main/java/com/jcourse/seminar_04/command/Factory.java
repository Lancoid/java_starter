package com.jcourse.seminar_04.command;

import com.jcourse.seminar_04.annotation.Injection;
import com.jcourse.seminar_04.parser.Parser;
import com.jcourse.seminar_04.proxy.ProxyHandler;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

/**
 * The type Factory.
 */
public class Factory
{
    private static Properties properties;
    private Parser parser;
    private Stack<Double> stack;
    private Map<String, Double> variablesMap;

    /**
     * Instantiates a new Factory.
     *
     * @param parser       the parser
     * @param stack        the stack
     * @param variablesMap the variables map
     */
    public Factory(Parser parser, Stack<Double> stack, Map<String, Double> variablesMap)
    {
        this.parser = parser;
        this.stack = stack;
        this.variablesMap = variablesMap;

        try {
            properties = new Properties();
            InputStream stream = Factory.class.getClassLoader().getResourceAsStream("seminar04.commands.properties");
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets Command by input line command.
     *
     * @param line the line
     *
     * @return the Command
     */
    public Command getCommand(String line)
    {
        try {
            String[] pieces = line.split(" ");
            String className = properties.getProperty(pieces[0].toLowerCase());
            if (className != null) {
                Class<?> aClass = Class.forName(className);
                Object command = aClass.newInstance();
                Field[] fields = aClass.getDeclaredFields();

                for (Field field : fields) {
                    Injection annotation = field.getAnnotation(Injection.class);
                    if (annotation != null) {
                        field.setAccessible(true);
                        switch (annotation.arg()) {
                            case STACK:
                                field.set(command, stack);
                                break;
                            case ARGUMENTS:
                                field.set(command, pieces);
                                break;
                            case VARIABLES:
                                field.set(command, variablesMap);
                                break;
                            case PARSER:
                                field.set(command, parser);
                                break;
                        }
                        field.setAccessible(false);
                    }
                }

                ClassLoader classLoader = command.getClass().getClassLoader();
                ProxyHandler proxyHandler = new ProxyHandler(command);

                return (Command) Proxy.newProxyInstance(classLoader, new Class[] { Command.class }, proxyHandler);
            }

            throw new Exception("В списке нет такой команды : " + pieces[0]);
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
