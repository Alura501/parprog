package ru.spbstu.telematics.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author klyushkin
 *
 * @ToDO Лифт. Лифт имеет максимальную вместимость 10 человек. В модели системы
 * управления лифтом, пассажиры входящие в лифт обозначены действием «enter» а
 * пассажиры, выходящие из лифта, обозначены действием «exit». В лифте не может
 * быть больше 10 человек. Построить модель системы в которой каждый пассажир и
 * лифт представлены отдельными потоками.
 */

 class App {
    /*
        будем считать, что люди не все на первом этаже
        */
    public static void main(String[] args) {
        final Elevator elevator = new Elevator();
        Thread thread = new Thread(elevator, "Elevator");
        Integer n=20;
        List<People> buyerList = new ArrayList<People>();
        List<Thread> threadList = new ArrayList<Thread>();
        thread.start();
        for (int i = 0; i < n; i++) {
            try {
            People p = new People(elevator);
            Thread t = new Thread(p, "People №"+ (i+1));
            t.start();
            threadList.add(t);
            buyerList.add(p);
            } catch (Exception e){
                System.out.println(e);
            }

        }




       /* for (int i = 0; i < 15; i++) {
            new Thread(new People(elevator), "People№ "+ i).start();
        }*/
    }

}