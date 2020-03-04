package com.leet.code;

import java.math.BigDecimal;

/**
 * 100以内质数阶乘和
 *
 * @author gaoqi
 * @date 2020/2/25.
 */
public class 以内质数阶乘和 {

    public static void main(String[] args) {
        BigDecimal sum = BigDecimal.ZERO;
        int j;
        for (int i = 2; i <= 100; i++) {
            j = 2;
            while (i % j != 0) {
                j++;
            }
            if (j == i) {
                BigDecimal factorial = doFactorial(new BigDecimal(i));

                sum = sum.add(factorial);
            }
        }
        System.out.println("质数阶乘和：" + sum.toString());
    }

    private static BigDecimal doFactorial(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }
        if (n.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        } else if (n.compareTo(BigDecimal.ONE) == 0) {
            return BigDecimal.ONE;
        } else {
            return n.multiply(doFactorial(n.subtract(BigDecimal.ONE)));
        }
    }
}
