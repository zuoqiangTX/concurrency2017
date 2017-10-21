package cn.com.zuoqiang.test.chapter1;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileSerachMain {
    public static final String separtor = File.separator;

    public static void main(String[] args) {
        FileSerach seracher = new FileSerach(separtor + "Users" + separtor + "zuoqiang", separtor + "log.txt");
        Thread thread = new Thread(seracher);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
