package ru.spbstu.telematics.java;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class App 
{

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
