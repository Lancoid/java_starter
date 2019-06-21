package com.jcourse.seminar_05;

import com.jcourse.seminar_05.output.CsvWriter;
import com.jcourse.seminar_05.entity.WordCounter;
import com.jcourse.seminar_05.reader.*;

import java.util.*;

/**
 * The type Main.
 */
public class Main
{
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {

//        ReaderInterface reader = new ReaderInputStream();
        ReaderInterface reader = new ReaderStream();

        reader.readFile("src/main/resources/seminar05.text.txt");

        TreeSet<WordCounter> treeSet = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : reader.getWordsMap().entrySet()) {
            treeSet.add(new WordCounter(entry.getKey(), entry.getValue(), reader.getTotalWords()));
        }

        CsvWriter.writeCsvFile(treeSet);
    }
}