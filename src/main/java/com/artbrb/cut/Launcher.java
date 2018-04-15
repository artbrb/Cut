package com.artbrb.cut;

import java.io.*;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws IOException {

        new Launcher().launch(args);
    }

    private void launch(String[] args) throws IOException {

        StringBuilder result = new StringBuilder("");
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
            } else if (wTest) {
                flagW = true;
            } else if (oTest) {
                outputFile = args[s + 1];
            } else if (!args[s - 1].equals("-o") && args[s].contains("-")) {
                range = args[s];
            } else {
                inputFile = args[s];
            }
        }

        if (flagC == flagW) {
            System.err.println("Флаги -c и -w не могут быть заданы одновременно");
        }

        String[] string = range.split("-");
        int flagN = string[0].isEmpty() ? 0 : Integer.parseInt(string[0]);
        int flagK = string[1].isEmpty() ? 0 : Integer.parseInt(string[1]);


        if (inputFile.equals("")) {
            System.out.println("Введите текст");
            Scanner scanner = new Scanner(System.in);

            String currentLine;

            while (true) {
                currentLine = scanner.nextLine();
                System.out.println("Строчка прочитана");
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





