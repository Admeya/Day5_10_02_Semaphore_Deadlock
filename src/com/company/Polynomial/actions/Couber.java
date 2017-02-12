package com.company.Polynomial.actions;

import com.company.Polynomial.helpers.Consumer;
import com.company.Polynomial.helpers.OwnSemaphore;

/**
 * Created by Ирина on 10.02.2017.
 */
public class Couber extends Thread{
    private float[] a;
    OwnSemaphore semaphore;
    Consumer cons;
    static boolean isLockA = false;

    public Couber(float[] a, OwnSemaphore semaphore, Consumer cons){
        this.a = a;
        this.semaphore = semaphore;
        this.cons = cons;
    }

    public float getSumA(){
        float sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + (a[i]* a[i] * a[i]);
        }
        return sum;
    }

    @Override
    public void run() {
        if (!isLockA) {
            semaphore.aquire();
            isLockA = semaphore.isFlag();
            cons.countingPolynomial(getSumA() , 0, 0);
            semaphore.release();
        }
    }
}
