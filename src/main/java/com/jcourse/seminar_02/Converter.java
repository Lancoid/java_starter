package com.jcourse.seminar_02;

import com.jcourse.seminar_02.command.*;

/**
 * Converter
 * Класс - создатель команд
 *
 * на впих  - строка с командой
 * на выпих - Объект-Команда или нул
 */
public class Converter
{
    /**
     * Line to command command.
     *
     * @param line the line
     *
     * @return the command
     */
    public Command lineToCommand(String line)
    {
        Double value;
        String var;
        String[] pieces;

        /* разбиваем на массив (0 - команда, 1 - переменная/число, 2 - число) */
        pieces = line.split(" ");

        if ("define".equals(pieces[0].trim().toLowerCase())) {
            if (!isNumeric(pieces[1]) && isNumeric(pieces[2])) {
                var = String.valueOf(pieces[1]);
                value = Double.valueOf(pieces[2]);
                return new CommandDefine(var, value);
            }
        } else if ("push".equals(pieces[0].trim().toLowerCase())) {
            if (isNumeric(pieces[1])) {
                value = Double.valueOf(pieces[1]);
                return new CommandPush(null, value);
            } else {
                var = String.valueOf(pieces[1]);
                return new CommandPush(var, null);
            }
        } else if ("print".equals(pieces[0].trim().toLowerCase())) {
            return new CommandPrint();
        } else if ("sqrt".equals(pieces[0].trim().toLowerCase())) {
            return new CommandSqrt();
        } else if ("+".equals(pieces[0])) {
            return new CommandAddition();
        } else if ("-".equals(pieces[0])) {
            return new CommandSubtraction();
        } else if ("*".equals(pieces[0])) {
            return new CommandMultiplication();
        } else if ("/".equals(pieces[0])) {
            return new CommandDivision();
        } else if ("stack".equals(pieces[0])) {
            return new CommandStack();
        } else if ("#".equals(pieces[0])) {
            return null;
        } else {
            System.out.println("Нет такой команды.");
        }

        return null;
    }

    private static boolean isNumeric(String string)
    {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
