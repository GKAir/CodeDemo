package com.netty;

/**
 * @author zhangweizhou
 * Email: zhangweizhou@wanhuchina.com
 * Date:  2018/4/18
 * Time:  14:19
 */

public class ThreadCount {
    private static Object obj = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        for (; ; ) {
            new Thread(new Runnable() {
                public void run() {
                    synchronized (obj) {
                        count += 1;
                        System.out.println("Thread #" + count);
                    }
                    for (; ; ) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                    }
                }
            }).start();
        }
    }
}
