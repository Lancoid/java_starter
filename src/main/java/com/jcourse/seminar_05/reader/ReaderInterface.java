package com.jcourse.seminar_05.reader;

import java.util.Map;

/**
 * The interface Reader interface.
 */
public interface ReaderInterface
{
    /**
     * Read file.
     *
     * @param fileName the file name
     */
    void readFile(String fileName);

    /**
     * Gets words map.
     *
     * @return the words map
     */
    Map<String, Integer> getWordsMap();

    /**
     * Gets total words.
     *
     * @return the total words
     */
    int getTotalWords();
}