package ru.spbstu.telematics.java;

class Solver implements Runnable{

    private double[][] values;
    private double[] res;
    private int from;
    private int to;

    public Solver(double[][] values, double[] res, int from, int to) {
        this.values = values;
        this.res = res;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        try {
            LinearEquation.gauss(values, res, from, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
