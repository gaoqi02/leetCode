package com.leet.code;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author gaoqi
 * @date 2020/2/25.
 */
public class 多线程交替打印 {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        final Print print = new Print();

        AtomicLong thread1Start = new AtomicLong();
        AtomicLong thread1End = new AtomicLong();
        AtomicLong thread2Start = new AtomicLong();
        AtomicLong thread2End = new AtomicLong();

        Thread thread1 = new Thread(() -> {
            thread1Start.set(System.currentTimeMillis());
            for (int i = 97; i < 123; i++) {
                char lower = (char) i;
                print.printLower(lower);

            }
            thread1End.set(System.currentTimeMillis());
        });

        Thread thread2 = new Thread(() -> {
            thread2Start.set(System.currentTimeMillis());
            for (int i = 65; i < 91; i++) {
                char upper = (char) i;
                print.printUpper(upper);
            }
            thread2End.set(System.currentTimeMillis());
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println();

        System.out.println("Thread1 cost :" + (thread1End.longValue() - thread1Start.longValue()));
        System.out.println("Thread2 cost :" + (thread2End.longValue() - thread2Start.longValue()));

        long end = System.currentTimeMillis();
        System.out.println("Total cost:" + (end - start));

    }


    private static class Print {

        private boolean flag = true;


        public synchronized void printUpper(char c) {
            while (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(c);
            flag = false;
            this.notify();
        }

        public synchronized void printLower(char c) {
            while (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(c);
            flag = true;
            this.notify();
        }
    }

}
