package com.jcourse.seminar_05.output;

import com.jcourse.seminar_05.entity.WordCounter;

import java.io.*;
import java.util.TreeSet;

/**
 * The type Csv writer.
 */
public class CsvWriter
{
    private static final String DELIMITER = ";";
    private static final String NEW_LINE = "\n";
    private static final String FILE_HEADER = "слово;количество;процент";

    /**
     * Write csv file.
     *
     * @param treeSet the tree set
     */
    public static void writeCsvFile(TreeSet<WordCounter> treeSet)
    {
        try (PrintWriter writer = new PrintWriter(new File("src/main/resources/seminar05.out.csv"))) {
            writer.write(FILE_HEADER + NEW_LINE);
            String string;
            for (WordCounter wordCounter : treeSet) {
                string = wordCounter.getWord() +
                    DELIMITER +
                    wordCounter.getCounter() +
                    DELIMITER +
                    wordCounter.getPercent() +
                    NEW_LINE;
                writer.write(string);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
