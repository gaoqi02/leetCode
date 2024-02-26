package com.leet.code;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author gaoqi
 * @date 2020/3/31.
 */
public class 计算器加减乘除 {

    public static void main(String[] args) throws Exception {
        计算器加减乘除 s = new 计算器加减乘除();
        System.out.println(s.calculateBig("2147483647 -340000000*8-22").toString());
    }

    public BigDecimal calculateBig(String s) throws Exception {
        Stack<BigDecimal> numStackBig = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                BigDecimal tempNumBig = new BigDecimal(arr[i] - '0');
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + (arr[i] - '0');
                    tempNumBig = tempNumBig.multiply(BigDecimal.valueOf(10)).add(BigDecimal.valueOf(arr[i] - '0')) ;
                }
                i--;

                if (lastOp == '+') {
                    numStackBig.push(tempNumBig);
                } else if (lastOp == '-') {
                    numStackBig.push(tempNumBig.multiply(BigDecimal.valueOf(-1)));
                } else {
                    numStackBig.push(resBig(lastOp, numStackBig.pop(), tempNumBig));
                }
            } else if (checkOps(arr[i])) {
                lastOp = arr[i];
            } else {
                throw new Exception("error ");
            }
        }

        BigDecimal ansBig = BigDecimal.ZERO;

        for (BigDecimal num : numStackBig) {
            ansBig = ansBig.add(num);
        }
        return ansBig;
    }

    private BigDecimal resBig(char op, BigDecimal a, BigDecimal b) {
        if (op == '*') {
            return a.multiply(b);
        } else if (op == '/') {
            return a.divide(b, 2);
        } else if (op == '+') {
            return a.add(b); //其实加减运算可以忽略
        } else {
            return a.subtract( b);
        }
    }

    private boolean checkOps(char op) {
        return op == '*' || op == '-' || op == '+' || op == '/';
    }


    public int calculate(String s) throws Exception {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + (arr[i] - '0');
                }
                i--;

                if (lastOp == '+') {
                    numStack.push(tempNum);
                } else if (lastOp == '-') {
                    numStack.push(-tempNum);
                } else {
                    numStack.push(res(lastOp, numStack.pop(), tempNum));
                }
            } else if (checkOps(arr[i])) {
                lastOp = arr[i];
            } else {
                throw new Exception("error ");
            }
        }

        int ans = 0;
        for (int num : numStack) {
            ans += num;
        }

        return ans;
    }



    private int res(char op, int a, int b) {
        if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        } else if (op == '+') {
            return a + b; //其实加减运算可以忽略
        } else {
            return a - b;
        }
    }



}