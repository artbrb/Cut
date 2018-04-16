package com.artbrb.cut;
import org.junit.Assert;
import org.junit.Test;

import java.beans.Transient;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class TestCut {
    @Test
    public void testWritingFlagC() {
        //given
        String inputString = "Kotlin this is the best programming language";

        //when
        String parseOne = FileProcessing.writingFlagC(7, 0, inputString);
        String parseTwo = FileProcessing.writingFlagC(0, 6, inputString);
        String parseThree = FileProcessing.writingFlagC(3, 500, inputString);

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
        String parseOne = FileProcessing.writingFlagW(2, 0, inputString);
        String parseTwo = FileProcessing.writingFlagW(0, 3, inputString);
        String parseThree = FileProcessing.writingFlagW(3, 100, inputString);

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
        String parseOne = FileProcessing.workWithStringOfFile(5, 0, true, false, inputString);
        String parseTwo = FileProcessing.workWithStringOfFile(3, 5, false, true,  inputString);

        //then
        assertEquals("won't know the rain from the tears in my eyes", parseOne);
        assertEquals("know the rain", parseTwo);
    }

    @Test
    public void  testMain() throws IOException {
        //given
        String[] firstArguments = {"cut" , "-c" , "-o" ,"1.txt", "4-9", "so just do it don't let your dreams be dreams"};
        String[] secondArguments = {"cut" , "-w" , "4.txt", "2-4", "so just do it don't let your dreams be dreams"};

        //when
        Launcher.main(firstArguments);
        Launcher.main(secondArguments);

        //then
    }
}
