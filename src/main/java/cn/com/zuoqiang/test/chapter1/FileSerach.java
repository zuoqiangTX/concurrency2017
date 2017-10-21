package cn.com.zuoqiang.test.chapter1;

import java.io.File;

public class FileSerach implements Runnable {
    private String initPath;
    private String fileName;

    public FileSerach(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                processDicretory(file);
            } catch (InterruptedException e) {
                System.out.printf("%s : The Serach has been interrupted",Thread.currentThread().getName());
            }
        }


    }

    private void processDicretory(File file) throws InterruptedException {
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    //System.out.println("处理文件夹");
                    processDicretory(list[i]);
                } else {
                    fileProcess(list[i]);
                }

            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }

    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n ",Thread.currentThread().getName(),file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();

        }

    }
}
