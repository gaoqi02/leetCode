package com.leet.code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaoqi
 * @date 2020/3/31.
 */
public class PrintABCSequenceByLock {

    /**
     * 打印次数
     */
    private int times;
    /**
     * 按状态进行打印，控制顺序
     */
    private int score;
    private Lock lock = new ReentrantLock();

    public PrintABCSequenceByLock(int times) {
        this.times = times;
    }

    public static void main(String[] args) {

        PrintABCSequenceByLock printABCSequenceByLock = new PrintABCSequenceByLock(20);
        Thread threadA = new Thread(() -> {
            printABCSequenceByLock.printA();
        });
        Thread threadB = new Thread(() -> {
            printABCSequenceByLock.printB();
        });
        Thread threadC = new Thread(() -> {
            printABCSequenceByLock.printC();
        });
        threadA.start();
        threadB.start();
        threadC.start();

    }

    public void printA() {
        print("A", 0);
    }

    public void printB() {
        print("B", 1);
    }

    public void printC() {
        print("C", 2);
    }

    private void print(String name, int targetState) {
        for (int i = 0; i < times; ) {
            lock.lock();
            // 控制顺序
            if (score % 3 == targetState) {
                score++;
                i++;
                System.out.print(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }
    }

}
