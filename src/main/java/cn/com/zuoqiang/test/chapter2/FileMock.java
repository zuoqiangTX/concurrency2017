package cn.com.zuoqiang.test.chapter2;

public class FileMock {
    private String content[];  //文件内容
    private int index;  //从文件读取内容的行号

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int) (Math.random() * 255);
                buffer.append((char) indice);
            }
            content[i] = buffer.toString();
        }
    }

    //有可以处理的数据行
    public boolean hasMoreLines() {
        return index < content.length;
    }

    //返回属性index指定的行内容
    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mcok :" + (content.length - index));
            return content[index++];
        }
        return null;
    }
}
