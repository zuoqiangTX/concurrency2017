package cn.com.zuoqiang.test.chapter6;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ContactMain {
    public static void main(String[] args) throws InterruptedException {
      /*  ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<String, Contact>();
        Thread[] threads = new Thread[25];
        int counter = 0;
        for (char i = 'A'; i < 'Z'; i++) {
            ContactTask task = new ContactTask(String.valueOf(i), map);
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        Map.Entry<String, Contact> element;
        Contact contact;
        element = map.firstEntry(); //第一个元素
        contact = element.getValue();

        element = map.lastEntry(); //最后一个元素
        contact = element.getValue();

        //取得子元素
        ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
        do {
            element = submap.pollFirstEntry();
            if (element != null) {
                contact = element.getValue();
            }
        } while (element != null);*/
    }
}
