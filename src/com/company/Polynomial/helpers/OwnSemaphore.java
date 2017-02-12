package com.company.Polynomial.helpers;

/**
 * Created by Ирина on 10.02.2017.
 */
public class OwnSemaphore {
    boolean isLock;

    public boolean isFlag() {
        return isLock;
    }

    public void aquire(){
        isLock = true;
    }

    public void release(){
        isLock = false;
    }
}
