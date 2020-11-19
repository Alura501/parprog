package ru.spbstu.telematics.java;


import java.io.*;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class AppTest
{
 private  String test;
 private String resulting;

    public static String generate() {
        Random random= new Random();
        Random random2= new Random();
        String symbols = "QWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder randString = new StringBuilder();
        int count=random2.nextInt(10)+1;
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt(random.nextInt(symbols.length())));
        //System.out.println(randString);
        return randString.toString();
    }
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
        resulting = AppTest.generate();
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
