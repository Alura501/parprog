package ru.spbstu.telematics.java;

import java.util.ArrayList;

public class LinearEquation {


    public  double[] solve(double[][] values, double[] res) throws Exception {
        gauss(values, res, 0, res.length);
        return result(values, res);
    }

    public double[] solveParallel(double[][] values, double[] res, int threadCount) {
        int n = res.length;
        ArrayList<Thread> threads = new ArrayList<Thread>();

        int threadStep = n / threadCount;
        int from = 0, to;

        for (int th = 0; th < threadCount; ++th) {
            if (n - threadStep > from + threadStep) {
                to = n;
            } else {
                to = from + threadStep;
            }
            Solver solver = new Solver(values, res, from, to);
            Thread solverThread = new Thread(solver);
            solverThread.start();
            threads.add(solverThread);
            from += threadStep;
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result(values, res);
    }

    static void gauss(double[][] values, double[] res, int from, int to) throws Exception {
        int n = res.length;

        for (int p = from; p < to; p++) {
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(values[i][p]) > Math.abs(values[max][p])) {
                    max = i;
                }
            }
            double[] temp = values[p];
            values[p] = values[max];
            values[max] = temp;

            double t = res[p];
            res[p] = res[max];
            res[max] = t;

            if (Math.abs(values[p][p]) <= 0.0000000001) {
                throw new Exception("No solutions");
            }

            for (int i = p + 1; i < n; i++) {
                double alpha = values[i][p] / values[p][p];
                res[i] -= alpha * res[p];
                for (int j = p; j < n; j++) {
                    values[i][j] -= alpha * values[p][j];
                }
            }
        }
    }

    private double[] result(double[][] values, double[] res) {
        int n = res.length;
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += values[i][j] * x[j];
            }
            x[i] = (res[i] - sum) / values[i][i];
        }
        return x;
    }



}
