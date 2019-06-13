package com.jcourse.seminar_02;

import com.jcourse.seminar_02.parser.ParserFile;

import java.util.Date;

import junit.framework.TestCase;
import org.junit.*;

import java.io.*;

public class CalcTest extends TestCase {
    private static ClassLoader classLoader;
    private static String fileOutPath;
    private static Date date;


    @Before
    protected void setUp() throws Exception {
        classLoader = getClass().getClassLoader();
        fileOutPath = getFilepath("file_out.txt");
        date = new Date();
    }

    @After
    protected void tearDown() throws Exception {
        outerCleaner(fileOutPath);
    }

    @Test
    public void test() {
        testQuadraticEquation();
    }

    private void testQuadraticEquation() {
        String fileInPath = getFilepath("file_quadratic_equation.txt");
        kickCalculator(fileInPath, fileOutPath, "testQuadraticEquation");

//        int countFilesLine = countLines(fileOutPath);
//        System.out.println(FileUtils.readLines(fileOutPath).get(lineNumber));
//        System.out.println(FileReader(fileOutPath).get(lineNumber));
    }

    private String getFilepath(String name) {
        File file = new File(classLoader.getResource(name).getFile());
        Assert.assertTrue(file.exists());
        return file.getAbsolutePath();
    }

    /**
     * Очищаем файл от предыдущих записей
     */
    private void outerCleaner(String fileOutPath) {
        try {
            FileOutputStream writer = new FileOutputStream(fileOutPath);
            writer.write(("").getBytes());
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    /**
     * Запуск калькулятора по файлу
     */
    private void kickCalculator(String fileInPath, String fileOutPath, String method) {
        ParserFile parser = new ParserFile(fileInPath, fileOutPath);
        Calculator calculator = new Calculator(parser);
        calculator.execute();

        try (FileWriter writer = new FileWriter(fileOutPath, true)) {
            writer.write(date.toString() + " :: " + method + " выполнен.");
            writer.append('\n');
            writer.write("---------------------------------------------------------------------------------------");
            writer.append('\n');
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private static int countLines(String filename) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(filename));
            try {
                byte[] c = new byte[1024];

                int readChars = is.read(c);
                if (readChars == -1) {
                    return 0;
                }

                int count = 0;
                while (readChars == 1024) {
                    for (int i = 0; i < 1024; ) {
                        if (c[i++] == '\n') {
                            ++count;
                        }
                    }
                    readChars = is.read(c);
                }

                while (readChars != -1) {
                    System.out.println(readChars);
                    for (int i = 0; i < readChars; ++i) {
                        if (c[i] == '\n') {
                            ++count;
                        }
                    }
                    readChars = is.read(c);
                }

                return count == 0 ? 1 : count;
            } finally {
                is.close();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }

        return 0;
    }
}