package com.jcourse.seminar_05.entity;

import java.math.*;

/**
 * The type Word counter.
 */
public class WordCounter implements java.lang.Comparable
{
    private String word;
    private int counter;
    private int totalWords;

    /**
     * Instantiates a new Word counter.
     *
     * @param str        the str
     * @param num        the num
     * @param totalWords the total words
     */
    public WordCounter(String str, int num, int totalWords)
    {
        this.word = str;
        this.counter = num;
        this.totalWords = totalWords;
    }

    @Override
    public int compareTo(Object object)
    {
        WordCounter entry = (WordCounter) object;

        int result = entry.counter - counter;

        if (result != 0) {
            return result / Math.abs(result);
        }

        return word.compareTo(entry.word);
    }

    /**
     * Gets word.
     *
     * @return the word
     */
    public String getWord()
    {

        return word;
    }

    /**
     * Gets counter.
     *
     * @return the counter
     */
    public int getCounter()
    {

        return counter;
    }

    /**
     * Gets percent.
     *
     * @return the percent
     */
    public double getPercent()
    {
        return new BigDecimal((double) counter * 100 / (double) totalWords).setScale(3, RoundingMode.UP).doubleValue();
    }
}
