package cn.com.zuoqiang.test.chapter3;

public class VideoMain {
    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();  //此时执行await后，该线程将阻塞，直到所有的人都到了
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(conference, "participant" + i);
            Thread thread = new Thread(participant);
            thread.start();
        }
    }
}
