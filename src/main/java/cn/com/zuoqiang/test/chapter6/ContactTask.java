package cn.com.zuoqiang.test.chapter6;

import java.util.concurrent.ConcurrentSkipListMap;

public class ContactTask implements Runnable {
    private ConcurrentSkipListMap<String, Contact> map;
    private String id;

    public ContactTask(ConcurrentSkipListMap<String, Contact> map, String id) {
        this.map = map;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            Contact contact = new Contact(id, String.valueOf(i + 100));
            map.put(id + contact.getPhone(), contact);
        }
    }
}
