package ru.spbstu.telematics.java;

import java.util.ArrayList;


 class App {
    public static void main(String[] args) {
        final Elevator elevator = new Elevator();
        Thread thread = new Thread(elevator, "Elevator");
        Integer n=20;
        ArrayList<People> buyerList = new ArrayList<People>();
        ArrayList<Thread> threadList = new ArrayList<Thread>();
        thread.start();
        for (int i = 0; i < n; i++) {
            try {
            People p = new People(elevator);
            Thread t = new Thread(p, "Person №"+ (i+1));
            t.start();
            threadList.add(t);
            buyerList.add(p);
            } catch (Exception e){
                System.out.println(e);
            }

        }
    }

}