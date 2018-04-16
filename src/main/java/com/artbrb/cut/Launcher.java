package com.artbrb.cut;

import java.io.*;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws IOException {

        new Launcher().launch(args);
    }

    private void launch(String[] args) throws IOException {

        StringBuilder result = new StringBuilder("");
        int flagN;
        int flagK;
        boolean flagC = false;
        boolean flagW = false;
        String inputFile = "";
        String outputFile = "";
        String flagsNAndK = "";

        for (int s = 1; s < args.length; s++) {
            boolean cTest = args[s].equals("-c");
            boolean wTest = args[s].equals("-w");
            boolean oTest = args[s].equals("-o");

            if (cTest) {
                flagC = true;
            } else if (wTest) {
                flagW = true;
            } else if (oTest) {
                outputFile = args[s + 1];
            } else if (!args[s - 1].equals("-o") && args[s].contains("-")) {
                flagsNAndK = args[s];
            } else if (!args[s - 1].equals("-o")) {
                inputFile = args[s];
            }
        }

        if (flagC == flagW) {
            System.err.println("Флаги -c и -w не могут быть заданы одновременно");
        }

        String[] range = flagsNAndK.split("-");
        flagN = range[0].isEmpty() ? 0 : Integer.parseInt(range[0]);
        if (range.length == 1 && flagN != 0) {
            flagK = 0;
        } else {
            flagK = Integer.parseInt(range[1]);
        }

        if (inputFile.equals("")) {
            System.out.println("Введите текст");
            Scanner scanner = new Scanner(System.in);
            String currentLine;
            while (true) {
                currentLine = scanner.nextLine();
                if (currentLine.length() == 0) {
                    break;
                }

                result.append(FileProcessing.workWithStringOfFile(flagN, flagK, flagC, flagW, currentLine));
                result.append("\n");
            }
        } else {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                result.append(FileProcessing.workWithStringOfFile(flagN, flagK, flagC, flagW, currentLine));
                result.append("\n");
            }
        }

        if (outputFile.equals("")) {
            System.out.println(result.toString());
        } else {
            try {
                FileProcessing.writeInNewFile(new File(outputFile), result.toString());
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }
}





