package com.artbrb.cut;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessing {

    public static String writingFlagC(int n, int k, String string) {
        int lastSymbol = Math.min(string.length(), k);
        if (n == 0) {
            if (string.length() < k) {
                return string;
            } else {
                return string.substring(0, lastSymbol);
            }
        } else if (k == 0) {
            return string.substring(n - 1, string.length());
        } else {
            return string.substring(n - 1, lastSymbol);
        }
    }

    public static String writingFlagW(int n, int k, String inputString) {

        StringBuilder builder = new StringBuilder();
        String[] words = inputString.split(" ");

        if (n == 0) {
            for (int i = 0; i < words.length && i < k; i++) {
                builder.append(words[i]);
                builder.append(" ");
            }
        } else if (k == 0) {
            for (int i = n - 1; i < words.length; i++) {
                builder.append(words[i]);
                builder.append(" ");
            }
        } else {
            for (int i = n - 1; i < k && i < words.length; i++) {
                builder.append(words[i]);
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    public static void writeInNewFile(File newFile, String string) throws IOException {
            FileWriter write = new FileWriter(newFile);
            write.append(string);
            write.append("\n");
            write.close();
    }

    public  static String workWithStringOfFile(int n, int k, boolean flagC, boolean flagW, String string) {

        if (flagC) {
            string = writingFlagC(n, k, string);
        }
        if (flagW) {
            string = writingFlagW(n, k, string);
        }
        return  string;
    }
}