package com.leet.code.多线程.生产者消费者;

/**
 * @author gaoqi
 * @date 2020/4/17.
 */
public class Producer implements Runnable {
    private PublicBox box;

    public Producer(PublicBox box) {
        this.box = box;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("pro  i:" + i);
                Thread.sleep(30);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            box.increase();
        }

    }
}
