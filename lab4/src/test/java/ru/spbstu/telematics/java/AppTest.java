package ru.spbstu.telematics.java;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    double[] EXPECTED_RESULT = {(double)2/3, -(double)43/18, (double)13/9, -(double)7/18  };
    private static final LinearEquation solver = new LinearEquation();
    @Test
    public void testEquationSolver() {
        double[][] a = {{ 1,2,3,-2 }, { 2, -1, -2, -3}, { 3,2,-1,2 },{2,-3,2,1}};
        double[] b = { 1,2,-5,11 };
        try {
            double[]  result = solver.solve(a, b);
            Assert.assertArrayEquals(EXPECTED_RESULT, result, 0.01);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    @Test
    public void testParallelSolver() {
        double[][] a = {{ 1,2,3,-2 }, { 2, -1, -2, -3}, { 3,2,-1,2 },{2,-3,2,1}};
        double[] b = { 1,2,-5,11 };

        double[] result = solver.solveParallel(a, b, 3);
        Assert.assertArrayEquals(EXPECTED_RESULT, result, 0.01);
    }}
