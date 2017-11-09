package cn.com.zuoqiang.Fixed;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutedServiceTest {
    private ScheduledExecutorService executorService;

    public ScheduledExecutedServiceTest() {
        this.executorService = Executors.newScheduledThreadPool(4);
    }

    //以上个任务的开始时间算，perod时间后，如果执行完毕就执行下个，如果没有的话等他执行完再执行下一个任务。
    public void testAtFixedRate() {
        executorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("执行完毕！"+new Date().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);  //当任务执行时间大于延迟时间以后，延迟的作用失去效果

    }

    //以上一个任务结束时间算，delay时间后执行下个任务
    public void testWithFixed() {
        executorService.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("-------------");
                try {
                    int i = 1 / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 3000, TimeUnit.MILLISECONDS);   //周期性的效果很明显

    }

    public static void main(String[] args) {
        ScheduledExecutedServiceTest test = new ScheduledExecutedServiceTest();
        //test.testWithFixed();
        test.testAtFixedRate();
    }
}
