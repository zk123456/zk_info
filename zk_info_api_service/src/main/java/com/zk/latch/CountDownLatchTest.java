package com.zk.latch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Zhangk
 * @Date 14:25 2018/11/6
 * @Description
 */
public class CountDownLatchTest {
    /**
     * 闭锁用处:
     * 1.等待(等待所有 行为/计算/服务 都准备好了)
     * @param args
     * @throws Exception
     */
    public static void main(String []args) throws Exception {
        long time = timeTasks(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("task.......");
            }
        });
        System.out.println(time);
    }

    public static long timeTasks(int nThreads, final Runnable task) throws Exception{
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(nThreads);

        for(int i = 0;i < nThreads;i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        /**
                         * 闭锁调节线程的控制流
                         */
                        /**
                         * await处于等待状态,到达结束状态前
                         * await等待计数器达到0,闭锁就会永久打开,其他线程就可以进来
                         */
                        start.await();
                        System.out.println("wait........");
                        try {
                            task.run();
                        }catch (Exception e){
                        }finally {
                            end.countDown();
                        }
                    }catch (Exception e){

                    }
                }
            });
            t.start();
        }

        long startTime = System.nanoTime();
        System.out.println("start.......");
        /**
         * countDown计数器减1,表示着一个事件已经发生了
         */
        start.countDown();
        end.await();
        System.out.println("end.......");
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
