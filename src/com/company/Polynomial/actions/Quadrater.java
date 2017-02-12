package com.company.Polynomial.actions;

import com.company.Polynomial.helpers.Consumer;
import com.company.Polynomial.helpers.OwnSemaphore;

/**
 * Created by Ирина on 10.02.2017.
 */
public class Quadrater extends Thread{
    private float[] b;
    OwnSemaphore semaphore;
    Consumer cons;
    static boolean isLockB = false;

    public Quadrater(float[] b, OwnSemaphore semaphore, Consumer cons){
        this.b = b;
        this.semaphore = semaphore;
        this.cons = cons;
    }

    public float getSumB(){
        float sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum = sum + (b[i] * b[i]);
        }
        return sum;
    }

    @Override
    public void run() {
        if (!isLockB) {
            semaphore.aquire();
            isLockB = semaphore.isFlag();
            cons.countingPolynomial(0, getSumB(), 0);
            semaphore.release();
        }
    }
}
