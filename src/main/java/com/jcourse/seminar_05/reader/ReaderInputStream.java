package com.jcourse.seminar_05.reader;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

/**
 * The type Reader input stream.
 */
public class ReaderInputStream implements ReaderInterface
{
    private int totalWords = 0;
    private Map<String, Integer> words = new HashMap<>();

    @Override
    public void readFile(String fileName)
    {
        try {
            Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)), StandardCharsets.UTF_8);
            StringBuilder output = new StringBuilder();
            char letter;

            for (int data; (data = reader.read()) > -1; ) {
                letter = (char) data;
                if (Character.isLetterOrDigit(letter)) {
                    output.append(letter);
                } else {
                    if (Character.isSpaceChar(letter)) {
                        totalWords += 1;
                        if (!output.toString().isEmpty()) {
                            words.merge(String.valueOf(output).toLowerCase(), 1, Integer::sum);
                        }
                        output = new StringBuilder();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getWordsMap()
    {
        return words;
    }

    public int getTotalWords()
    {
        return totalWords;
    }
}
