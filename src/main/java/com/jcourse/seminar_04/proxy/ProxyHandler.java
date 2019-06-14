package com.jcourse.seminar_04.proxy;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;

/**
 * The type Proxy handler.
 */
public class ProxyHandler implements InvocationHandler
{
    private Object command;
    private Logger logger;

    /**
     * Instantiates a new Proxy handler.
     *
     * @param command the command
     */
    public ProxyHandler(Object command)
    {
        this.command = command;
        this.logger = Logger.getLogger(ProxyHandler.class);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
    {
        try {
            method.invoke(command, args);
            logOutputByFields();
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
            System.err.println(error.getMessage());
        }

        return null;
    }

    private void logOutputByFields()
    {
        StringBuilder string = new StringBuilder();
        Class<?> thisClass;
        try {
            thisClass = Class.forName(command.getClass().getName());

            Field[] aClassFields = thisClass.getDeclaredFields();
            string.append(command.getClass().getSimpleName());
            string.append(" ------------- [ ");

            AtomicBoolean flag = new AtomicBoolean(false);

            for (Field field : aClassFields) {
                if (!field.getName().equals("parser")) {
                    if (flag.get()) {
                        string.append(", ");
                    }
                    string.append(field.getName().toUpperCase());
                    string.append(" = ");
                    field.setAccessible(true);
                    if (!field.getName().equals("arguments")) {
                        string.append(field.get(command));
                    } else {
                        string.append(Arrays.toString((String[]) field.get(command)));
                    }

                    field.setAccessible(false);
                    flag.set(true);
                }
            }

            string.append(" ]");
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info(string.toString());
    }
}
