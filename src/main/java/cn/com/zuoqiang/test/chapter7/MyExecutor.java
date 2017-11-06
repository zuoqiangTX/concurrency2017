package cn.com.zuoqiang.test.chapter7;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutor extends ThreadPoolExecutor {
    private ConcurrentHashMap<String, Date> startTime;

    public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        startTime = new ConcurrentHashMap<String, Date>();
    }

    @Override
    public void shutdown() {
        System.out.printf("My Executor : Going to shutdown!\n");
        System.out.printf("My Executor : Executed tasks : %d\n", getCompletedTaskCount());
        System.out.printf("My Executor : Running tasks : %d!\n", getActiveCount());
        System.out.printf("My Executor : Pending tasks : %d\n", getQueue().size());
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        System.out.printf("My Executor : Going to shutdown NOW!\n");
        System.out.printf("My Executor : Executed tasks : %d\n", getCompletedTaskCount());
        System.out.printf("My Executor : Running tasks : %d!\n", getActiveCount());
        System.out.printf("My Executor : Pending tasks : %d\n", getQueue().size());
        return super.shutdownNow();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.printf("MyExecutor A task is begining : %s, %s\n", t.getName(), r.hashCode());
        startTime.put(String.valueOf(r.hashCode()), new Date());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Future<?> result = (Future<?>) r;
        System.out.println("My Executor is ending!");
        try {
            System.out.println("结果为" + result.get() );
            Date date = startTime.remove(String.valueOf(r.hashCode()));
            Date nowTime = new Date();
            long diffTime = nowTime.getTime() - date.getTime();
            System.out.println("线程池运行的时间为" + diffTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        super.afterExecute(r, t);
    }
}
