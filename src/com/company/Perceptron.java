// Реализация логического «или» с помощью однослойного персептрона
package com.company;

import java.util.Scanner;

public class Perceptron {
    double y;
    double[] x;
    double[] w;
    double[][] pat = {
            {-1, -3, 0},
            {4, 3, 1},
            {1, 4, 1},
            {2, 3, 1},
            {4, 5, 1},
            {1, 3, 1},
            {-2, -1, 0},
            {-2, -2, 0},
            {-3, -3, 0},
            {-2.5, -2.5, 0}

     };

    public Perceptron() {
        x = new double[2];
        w = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            w[i] = Math.random() * 0.2 + 0.1;
            System.out.println("Начальные значения весов");
            System.out.println("w[" + i + "]=" + w[i]);
        }
    }

    public void cy() {
        y = 0;
        for (int i = 0; i < x.length; i++) {
            y += x[i] * w[i];
        }
        System.out.println("Взвешенная сумма входных значений");
        System.out.println(y);
        if (y > 0.5)
            y = 1;
        else
            y = 0;

    }

    public void study() {
        double gEr = 0;
        int m = 0;
        do {
            gEr = 0;
            for (int p = 0; p < pat.length; p++) {
                x = java.util.Arrays.copyOf(pat[p], pat[p].length - 1);
                cy();
                double er = pat[p][2] - y;
                gEr += Math.abs(er);
                for (int i = 0; i < x.length; i++) {
                    w[i] += 0.1 * er * x[i];
                }
            }
            m++;
        } while (gEr != 0);
        System.out.println("m=" + m);
    }

    public void test() {
        study();
        for (int p = 0; p < pat.length; p++) {
            x = java.util.Arrays.copyOf(pat[p], pat[p].length - 1);
            cy();
            System.out.println("y=" + y);
        }
    }
    public void checking_cords(){
         Scanner sc = new Scanner(System.in);

        x[1] = sc.nextDouble();
        x[0] = sc.nextDouble();
        if (x[0] >= 1 && x[0] <= 4 && x[1] >= 2 && x[1] <= 5) {
            System.out.println(" Right coords");
        }
        if (x[0] >= -3 && x[0] <= -1 && x[1] >= -3 && x[1] <= -1) {

        } else System.out.println(" Wrong coords");
        }

    public static void main(String[] args) {
        new Perceptron().test();
        //new Perceptron().checking_cords();
    }
}
