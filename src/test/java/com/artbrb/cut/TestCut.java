package com.artbrb.cut;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class TestCut {
    private FileProcessing processing = new FileProcessing();


    @Test
    public void testWritingFlagC() {
        //given
        String inputString = "Kotlin this is the best programming language";

        //when
        String parseOne = processing.writingFlagC(7, 0, inputString);
        String parseTwo = processing.writingFlagC(0, 6, inputString);
        String parseThree = processing.writingFlagC(3, 500, inputString);

        //then
        assertEquals("Java this is the best programming language", "Java" + parseOne);
        assertEquals("Kotlin", parseTwo);
        assertEquals("tlin this is the best programming language", parseThree);
    }

    @Test
    public void testWritingFlagW() {
        //given
        String inputString = "Started from the bottom now we're here";

        //when
        String parseOne = processing.writingFlagW(2, 0, inputString);
        String parseTwo = processing.writingFlagW(0, 3, inputString);
        String parseThree = processing.writingFlagW(3, 100, inputString);

        //then
        assertEquals("from the bottom now we're here", parseOne);
        assertEquals("Started from the", parseTwo);
        assertEquals("the bottom now we're here", parseThree);
    }

    @Test
    public void testWriteInNewFile() {

    }

    @Test
    public void  testWorkWithStringOfFile() {
        //given
        String inputString = "You won't know the rain from the tears in my eyes";

        //when
        String parseOne = processing.workWithStringOfFile(5, 0, true, false, inputString);
        String parseTwo = processing.workWithStringOfFile(3, 5, false, true,  inputString);

        //then
        assertEquals("won't know the rain from the tears in my eyes", parseOne);
        assertEquals("know the rain", parseTwo);
    }

//    @Test
//    public void  testMain() throws IOException {
//        //given
//        String[] firstArguments = {"cut" , "-w" , "-o" ,"FilesForTests/outputFiles/output1.txt",
//                "FilesForTests/inputFiles/input1.txt", "2-3"};
////        String[] secondArguments = {"cut" , "-c" , "-o" ,"FilesForTests/output files/output 2.txt",
////                "FilesForTests/input files/input 2.txt", "4-9"};
//
//        //when
//        Launcher.main(firstArguments);
////        Launcher.main(secondArguments);
//
//        //then
//        assertEquals(new File("FilesForTests/outputFiles/output1.txt"),
//                new File("FilesForTests/expected output files/expectedOutput1.txt"));
//    }
}
