package cn.com.zuoqiang.test.chapter3;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {
    private final CountDownLatch latch;

    public VideoConference(int number) {
        latch = new CountDownLatch(number);
    }

    //当每一个与会者进入视频会议的时候，这个方法将要被调用
    public void arrive(String name) {
        System.out.printf("%s 到了!\n", name);
        latch.countDown();
            System.out.printf("还有 %d 个人没到\n", latch.getCount());
    }

    public void run() {
        System.out.printf("本次视频会议的人数: %d\n", latch.getCount());
        try {
            latch.await();  //等待所有人到达
            System.out.printf("所有人都到了。\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
