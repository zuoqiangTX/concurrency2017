package cn.com.zuoqiang.test.chapter3;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private VideoConference conference;
    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);  //到了一个与会者
    }
}
