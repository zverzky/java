package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите нижний предел интегрирования");
        int start = sc.nextInt();

        System.out.println("Введите верхний предел интегрирования");
        int end = sc.nextInt();

        System.out.println("На сколько точно вы хотите посчитать интеграл? (от 1 до 9 223 372 036 854 775 807)");
        long nOtr = sc.nextInt();

        integral(start, end, nOtr);

    }
    public static void integral(int start, int end, long nOtr)
    {
        double h, sum;

        h = (double) (end - start)/nOtr;

        sum = 0.5 * (Math.pow(start, 2) + Math.sin(2*(start)) + (start) - 3 - (Math.pow(end,2) + Math.sin(2*(end)) + (end) - 3));

        for (int i = 1; i <= nOtr; i++)
        {
            sum += Math.pow(start + i * h, 2) + Math.sin(2*(start + i * h)) + (start + i * h) - 3;
        }

        System.out.println(sum * h);
    }

}
