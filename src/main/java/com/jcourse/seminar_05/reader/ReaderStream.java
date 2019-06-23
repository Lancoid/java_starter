package com.jcourse.seminar_05.reader;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * The type Reader input stream.
 */
public class ReaderStream implements ReaderInterface {
    private int totalWords = 0;
    private Map<String, Integer> words = new HashMap<>();

    @Override
    public void readFile(String fileName) {
        try {
            Files
                    .lines(Paths.get(fileName))
                    .flatMap(line -> Arrays.stream(line.toLowerCase().trim().split("[^\\p{L}\\p{N}]+")))
                    .filter(word -> word.length() > 0)
                    .forEach(word -> {
                        words.merge(word, 1, Integer::sum);
                        totalWords++;
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getWordsMap() {
        return words;
    }

    public int getTotalWords() {
        return totalWords;
    }
}
