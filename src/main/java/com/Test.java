package com;

public class Test {

    public static void main(String[] args) {
        System.out.println(sqrt(10.0, 0.01));
    }

    public static Double sqrt(Double target, double p) {
        double h = target;
        double l = 0;
        if (target >= 1) {
            while (l < h) {
                double m = (h + l) / 2;
                if (Math.abs(m * m - target) <= p) return m;
                if (m * m > target) {
                    h = m;
                } else {
                    l = m;
                }
            }
        }
        if (target < 1) {
            while (l < h) {
                double m = (h - l + 1) / 2;
                if (Math.abs(m * m - target) <= p) return m;
                if (m * m > target) {
                    l = m;
                } else {
                    h = m;
                }
            }
        }
        return -1d;
    }
}
