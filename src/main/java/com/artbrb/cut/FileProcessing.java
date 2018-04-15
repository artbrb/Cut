package com.artbrb.cut;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessing {

    public static String writingFlagC(int[] flags, String string) {

        int flagN = flags[0];
        int flagK = flags[1];

        if (flagN == 0) {
            if (string.length() < flagN) {
                return string;
            } else {
                return string.substring(0, flagN);
            }
        } else if (flagK == 0) {
            return string.substring(flagN, string.length() - 1);
        } else {
            return string.substring(flagN, flagK);
        }
    }

    public static String writingFlagW(int[] flags, String string) {

        int flagN = flags[0];
        int flagK = flags[1];
        StringBuilder builder = new StringBuilder();
        String[] splitString = string.split(" ");

        if (flagN == 0) {
            for (int i = 0; i < splitString.length && i < flagK - 1; i++) {
                builder.append(splitString[i]);
                builder.append(" ");
            }
        } else if (flagK == 0) {
            for (int i = flagN; i < splitString.length; i++) {
                builder.append(splitString[i]);
                builder.append(" ");
            }
        } else {
            for (int i = flagN - 1; i < flagK && i < splitString.length; i++) {
                builder.append(splitString[i]);
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    public static int[] parseRange(String range) {
        if (range.length() == 3 && range.charAt(1) == '-') {
            return new int[]{range.charAt(0), range.charAt(2)};
        }
        if (range.length() == 2) {
            if (range.charAt(0) == '-') {
                return new int[]{0, range.charAt(1)};
            } else
                return new int[]{range.charAt(1), 0};
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void writeInNewFile(File newFile, String string) throws IOException {
            FileWriter write = new FileWriter(newFile);
            write.append(string);
            write.append("\n");
            write.close();
    }

    public static String workWithStringOfFile(int[] flags, boolean flagC, boolean flagW, String string) {
        int flagN = flags[0];
        int flagK = flags[1];

        if (flagC) {
            string = writingFlagC(flags, string);
        }
        if (flagW) {
            string = writingFlagW(flags, string);
        }
        return  string;
    }
}