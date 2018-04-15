package com.cut;

import java.io.*;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        new Launcher().launch(args);
    }

    private void launch(String[] args) {

        StringBuilder newText = new StringBuilder("");
        boolean flagC = false;
        boolean flagW = false;
        String inputFile = "";
        String outputFile = "";
        String range = "";

        for (int s = 1; s < args.length; s++) {

            boolean cTest = args[s].equals("-c");
            boolean wTest = args[s].equals("-w");
            boolean oTest = args[s].equals("-0");


            if (cTest) {
                flagC = true;
            }
            if (wTest) {
                flagW = true;
            }
            if (oTest) {
                outputFile = args[s + 1];
            }
            if (!oTest && !args[s - 1].equals("-o") && !cTest && !wTest && args[s].contains("-")) {
                range = args[s];
            } else {
                inputFile = args[s];
            }
        }

        if (flagC == flagW) {
            System.err.println("Флаги -c и -w не могут быть заданы одновременно");
        }

        int[] flagNK = FileProcessing.parseRange(range);

        if (inputFile == "") {
            Scanner text = new Scanner(System.in);
            String newString = text.nextLine();
            String string = "";

            while ((string = text.nextLine()).length() != 0) {
                newText.append(FileProcessing.workWithStringOfFile(flagNK, flagC, flagW, newString));
                newText.append("\n");
            }
        } else {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                newText.append(FileProcessing.workWithStringOfFile(flagNK, flagC, flagW, line));
                newText.append("\n");
            }
        }

        if (outputFile == "") {
            System.out.println(newText);
        } else {
            try {
                FileProcessing.writeInNewFile(new File(outputFile), newText.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}





