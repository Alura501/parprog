package ru.spbstu.telematics.java;

import java.util.Random;


public class App 
{
    private static final Random RANDOM = new Random();

    private static double[][] createA(int size){
        double[][] a = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a[i][j] = RANDOM.nextInt(100);
            }
        }
        return a;
    }

    private static double[] createB(int size){
        double[] b = new double[size];
        for (int i = 0; i < size; i++) {
            b[i] = RANDOM.nextInt(100);
        }
        return b;
    }
    public static void main( String[] args )
    {

        int size = 20;
        double [][] values = createA(size);
        double [] res = createB(size);
        System.out.println("size = " + size);
        final LinearEquation solver = new LinearEquation();
        long time = System.currentTimeMillis();
        double[] result;
       try {
            result = solver.solve(values, res);
            System.out.println("For single thread: " + (System.currentTimeMillis() - time) +" milliseconds");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        time= System.currentTimeMillis();
        result = solver.solveParallel(values, res, 2);
        System.out.println("For 2 threads: " + (System.currentTimeMillis() - time) + " milliseconds");

        time = System.currentTimeMillis();
        result = solver.solveParallel(values, res, 3);
        System.out.println("For 3 threads: " +  (System.currentTimeMillis() - time) + " milliseconds");

        time = System.currentTimeMillis();
        result = solver.solveParallel(values, res, 4);
        System.out.println("For 4 threads: " +  (System.currentTimeMillis() - time) + " milliseconds");


        time = System.currentTimeMillis();
        result = solver.solveParallel(values, res, 5);
        System.out.println("For 5 threads: " +  (System.currentTimeMillis() - time) + " milliseconds");

    }
}
