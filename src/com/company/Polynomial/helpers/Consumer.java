package com.company.Polynomial.helpers;

/**
 * Created by Ирина on 10.02.2017.
 */
public class Consumer {
    float cubes = 0;
    float quadres = 0;
    float simplest = 0;

   public static float sum;

    public synchronized void countingPolynomial(float cube, float quadres, float simplest){
        if (cube != 0 ){
            this.cubes = cube;
            sum = this.sum + this.cubes;
        }
        if (quadres !=0){
            this.quadres = quadres;
            sum = this.sum + this.quadres;
        }
        if (simplest !=0){
            this.simplest = simplest;
            sum = this.sum + this.simplest;
        }

        this.sum = sum;
        System.out.println("cube = " + cube + " quadro = " + quadres + " simple = " + simplest + " Sum = " + sum);
    }
}
