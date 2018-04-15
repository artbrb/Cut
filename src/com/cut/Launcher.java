package com.cut;

import java.io.*;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        new Launcher().launch(args);
    }

    private void launch(String[] args) {

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

            if (flagC == flagW) {
                System.err.println("Флаги -c и -w ен могут быть заданы одновременно");
            } else {
                if (inputFile != "") {
                    try {
                        InputStream in = new FileInputStream(inputFile);
                        BufferedReader read = new BufferedReader(new InputStreamReader(in));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
}




