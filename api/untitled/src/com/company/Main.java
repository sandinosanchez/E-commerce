package com.company;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i < 60 ; i++) {
            for (int j = 1; j <10 ; j++) {
                sleep(10);
                System.out.println(i+":"+j);
            }
            sleep(1000);
        }
    }
}
