package ru.spbstu.telematics.java;


import java.io.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class AppTest
{
 private  String test;
 private String resulting;

    @Before
    public void setUp() throws Exception {
        test = "";
        try(FileReader reader = new FileReader("notes3.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                test +=(char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        resulting = App.generate();
        test+=resulting;
    }
    @Test
    public void Test1(){
        App newFile = new App();
        newFile.WriteToFile(resulting);
        String test2 = "";
        try(FileReader reader = new FileReader("notes3.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                test2 +=(char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        assertEquals(test, test2);
    }
}
