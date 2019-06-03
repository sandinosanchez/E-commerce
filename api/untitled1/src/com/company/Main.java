package com.company;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        Timer timer = new Timer();

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("fecha"+ new Date());
            }
        };

        timer.schedule(tarea,0,1000);
    }
}
