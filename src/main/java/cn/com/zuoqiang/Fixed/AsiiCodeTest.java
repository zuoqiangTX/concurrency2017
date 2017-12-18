package cn.com.zuoqiang.Fixed;

public class AsiiCodeTest {
    public static void main(String[] args) {
        String str = "左强";
        String asciiResult = convertASII(str);
        System.out.println("转换为ASII: " + asciiResult);
        String stringResult = convertString(asciiResult);
        System.out.println("转换为String: " + stringResult);

    }

    public static String convertASII(String str) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                buffer.append((int) chars[i]).append(",");
            } else {
                buffer.append((int) chars[i]);
            }
        }
        return buffer.toString();
    }

    public static String convertString(String string) {
        StringBuffer buffer = new StringBuffer();
        String[] strs = string.split(",");
        for (int i = 0; i < strs.length; i++) {
            buffer.append(((char) Integer.parseInt(strs[i])));
        }
        return buffer.toString();
    }
}
