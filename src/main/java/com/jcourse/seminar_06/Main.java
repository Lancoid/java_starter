package com.jcourse.seminar_06;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.*;
import java.nio.file.*;
import java.util.*;
import java.io.*;

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
        try (
            Stream<String> lines = Files.lines(Paths.get("src/main/resources/seminar05.text.txt"));
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src/main/resources/seminar06.out.csv"))
        ) {
            AtomicLong totalWords = new AtomicLong(0);

            lines
                .flatMap(line -> Arrays.stream(line.toLowerCase().trim().split("[^\\p{L}\\p{N}]+")))
                .filter(word -> word.length() > 0)
                .peek(word -> totalWords.incrementAndGet())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                    Comparator.comparingLong
                    (
                        Map.Entry<String, Long>::getValue).reversed().thenComparing(Map.Entry::getKey
                    )
                )
                .forEach(entry -> {
                    try {
                        writer.write(entry.getKey() + ";" +
                            entry.getValue() + ";" +
                            String.format("%.3f%%", entry.getValue() * 100.0 / totalWords.get()) + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}