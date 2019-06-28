package com.jcourse.seminar_08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        String indexHtml = generateIndexHtml("src/main/resources");
        try (FileWriter writer = new FileWriter("src/main/resources/index.html")) {
            writer.write(indexHtml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateIndexHtml(String dirName)
    {
        File dir = new File(dirName);
        StringBuilder content = new StringBuilder();
        content.append("<html>\n<head><meta charset=\"utf-8\">");
        content.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" ");
        content.append("integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
        content.append("</head>\n<body>\n<table class=\"table\">\n");
        content.append("<tr>\n");
        content.append("<td>\n");
        content.append("<a href=\"..\">");
        content.append("..");
        content.append("</a>\n");
        content.append("</tr>\n");
        if (dir.isDirectory()) {
            File[] filesInDir = dir.listFiles();
            Arrays.sort(filesInDir, (fi, f2) -> 0);
            for (File file : filesInDir) {
                content.append("<tr>\n");
                content.append("<td>\n");
                content.append("<a href=\"" + file.getName() + "\">");
                content.append(file.getName());
                content.append("</a>\n");
                content.append("<td>\n");
                content.append(dateFormat(file.lastModified()));
                content.append("</td>\n");
                content.append("<td>\n");
                content.append(fileFormat(file.length()));
                content.append("</td>\n");
                content.append("</tr>\n");
            }
        }

        content.append("</table>\n</body>\n</html>");
        return content.toString();
    }

    private static String dateFormat(long millis)
    {
        Date date = new Date(millis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    private static String fileFormat(long length)
    {
        int unit = 1024;
        if (length < unit) return length + " байт";
        int exp = (int) (Math.log(length) / Math.log(unit));
        String pre = "КМГТПЭ".charAt(exp-1) + "";
        return String.format("%.1f %sбайт", length / Math.pow(unit, exp), pre);
    }
}
