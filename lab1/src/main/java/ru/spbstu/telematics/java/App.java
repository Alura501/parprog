package ru.spbstu.telematics.java;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class App 
{



    public void WriteToFile(String text){
        try(FileWriter writer = new FileWriter("notes3.txt", true))
        {
            // запись всей строки
            writer.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void main( String[] args )
    {
        System.out.println("Input a string: ");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        App app = new App();
        app.WriteToFile(text);
    }
}
