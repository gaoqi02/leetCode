package com.leet.code;

public class erfen {

    public static void main(String[] args) {
        double num = 10;
        double check = num;
        System.out.println(sqrt(0, num, num, 0.1));
    }

    public static double sqrt(double start, double end, double num, double p) {

        if (Math.abs(start * start - num) <= p) return start;

        double mid = (start + end) / 2;
        if (mid * mid - num > p) {
            return sqrt(start, mid, num, p);
        } else {
            return sqrt(mid, end, num, p);
        }
    }
}
