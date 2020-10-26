package com.development.metindagcilar.pubquiz;

public class Loop {

    public static void main(String[] args) {
        Loop loop = new Loop();
//        loop.problem6();
    }

    private void problem1() {
        for (int i = 0; i < 10; i++) {
            print(i);
        }
    }

    private void print(int i) {
        System.out.println(i);
    }

    private void problem2() {
        int number = 25;

        if (number < 10)
            System.out.println("A");
        else if (number > 20)
            System.out.println("B");
        else
            System.out.println("C");
    }

    private void problem3() {
        boolean b = doesMemLoveHisCar();

        if (b == true) {
            System.out.println("A");
        } else if (b != true) {
            System.out.println("B");
        } else
            System.out.println("C");
    }

    private boolean doesMemLoveHisCar() {
        return true;
    }

    private void problem4() {
        int x = multiply(5, 10);
        System.out.println(x);
    }

    private int multiply(int a, int b) {
        return a + b;
    }

    private void problem5() {
        String mesg = "Answer is ";
        int sum = 1 + 2;
        System.out.println(mesg + sum);
    }

    private boolean customerOrderedAtLeastOneMonthAgo() {
        // some complex logic here
        return true;
    }

    private void problem7() {
        int max = 100;

        while (max > 0) {
            System.out.println("");

            max = max - 1;
        }
        System.out.println("End");
    }
}
