package com.company.Polynomial.actions;

import com.company.Polynomial.helpers.Consumer;
import com.company.Polynomial.helpers.OwnSemaphore;

/**
 * Created by Ирина on 10.02.2017.
 */
public class Simpler extends Thread {
    private float[] c;
    OwnSemaphore semaphore;
    Consumer cons;
    static boolean isLockC = false;

    public Simpler(float[] c, OwnSemaphore semaphore, Consumer cons) {
        this.c = c;
        this.semaphore = semaphore;
        this.cons = cons;
    }

    public float getSumC() {
        float sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum = sum + c[i];
        }
        return sum;
    }


    @Override
    public void run() {
        if (!isLockC) {
            semaphore.aquire();
            isLockC = semaphore.isFlag();
            cons.countingPolynomial(0, 0, getSumC());
            semaphore.release();
        }
    }
}
