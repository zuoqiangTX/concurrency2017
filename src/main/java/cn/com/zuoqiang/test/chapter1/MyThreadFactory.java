package cn.com.zuoqiang.test.chapter1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    private String name;
    private int count;
    private List<String> status;

    public MyThreadFactory(String name) {
        count = 0;
        this.name = name;
        status = new ArrayList<String>();
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread-" + count);
        count++;
        status.add(String.format("Created thread %d with name %s on %s\n", thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = status.iterator();
        while (it.hasNext()) {
            buffer.append(it.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
