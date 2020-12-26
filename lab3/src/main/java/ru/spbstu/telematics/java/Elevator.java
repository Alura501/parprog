package ru.spbstu.telematics.java;

import java.util.Date;
import java.util.concurrent.Semaphore;


 class Elevator implements Runnable {

    static private final int maxPeople = 10;
    static Semaphore countPpl = new Semaphore(maxPeople);
    static Semaphore isMoving = new Semaphore(1);

    private void moveUp() {
        try {
            isMoving.acquire();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            System.out.println("Elevator moves up");
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        isMoving.release();
    }

    private void moveDown() {
        try {
            isMoving.acquire();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            System.out.println("Elevator moves down");
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        isMoving.release();
    }
    private void waitPeople() {
        System.out.println("Elevator waiting");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void run() {
        while (true) {

            waitPeople();
            moveUp();
            waitPeople();
            moveDown();

        }
    }
}