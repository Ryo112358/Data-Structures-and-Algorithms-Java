package dev.coffeelessprogrammer.dsalgo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println(starPattern(0));
        System.out.println(starPattern(1));
        System.out.println(starPattern(2));
        System.out.println(starPattern(3));
        System.out.println(starPattern(4));
        System.out.println(starPattern(5));
    }

    private static String starPattern(int rows) {
        StringBuilder sb = new StringBuilder((int) (4 * Math.pow(rows, 2)));

        for(int i=0; i < rows; ++i) {
            for(int j=1; j < rows; ++j) {
                if(j < rows-i) sb.append(" ");
                else sb.append("* ");
            }
            sb.append("*\n");
        }

        for(int i=rows-1; i > 0; --i) {
            for(int j=0; j < rows-1; ++j) {
                if(j < rows-i) sb.append(" ");
                else sb.append("* ");
            }
            sb.append("*\n");
        }

        return sb.toString();
    }

    final static String horizontalRule = "--------------------------------------------------";

    private static String envDateTime() {
        final String env = "sapphireqas1";
        final Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd, HH:mm");

        StringBuilder sb =  new StringBuilder(64);
        sb.append(env.toUpperCase()).append(", ");
        sb.append(dateFormat.format(now));
        sb.append("-".repeat(horizontalRule.length() - sb.length()));

        return sb.toString();
    }
}
