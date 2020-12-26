package ru.spbstu.telematics.java;


class People implements Runnable {

    private Elevator elevator;
    People (Elevator e){
        elevator = e;
    }
    private void enter() {
        //System.out.println(Thread.currentThread().getName() + " try enter");

        try {
            elevator.countPpl.acquire();
            elevator.isMoving.acquire();
            System.out.println(Thread.currentThread().getName() + " enter");
            elevator.isMoving.release();
        } catch (Exception ex) {
            System.out.println(ex);
        }


    }

    private void exit() {
        try {
            elevator.isMoving.acquire();
            elevator.countPpl.release();
            System.out.println(Thread.currentThread().getName() + " exit");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        elevator.isMoving.release();

    }

    @Override
    public void run() {
        enter();
        try {
            Thread.sleep(6000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        exit();
    }

}