package com.company.Polynomial;

import com.company.Polynomial.actions.Couber;
import com.company.Polynomial.actions.Quadrater;
import com.company.Polynomial.actions.Simpler;
import com.company.Polynomial.helpers.Consumer;
import com.company.Polynomial.helpers.OwnSemaphore;

/**
 * Created by Ирина on 10.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        float[] mas = {1, 2, 3, 4, 5};

        OwnSemaphore semaphore = new OwnSemaphore();
        Consumer cons = new Consumer();

        Thread[] threads = new Thread[3];

        threads[0] = new Couber(mas, semaphore, cons);
        threads[1] = new Quadrater(mas, semaphore, cons);
        threads[2] = new Simpler(mas, semaphore, cons);
//        threads[3] = new Simpler(mas, semaphore, cons);
//        threads[4] = new Quadrater(mas, semaphore, cons);
//        threads[5] = new Couber(mas, semaphore, cons);

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        //compareAndSet - read
    }
}
