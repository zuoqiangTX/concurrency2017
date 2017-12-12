package cn.com.zuoqiang.Fixed;

import sun.management.VMManagement;

import javax.xml.bind.DatatypeConverter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.UUID;

public class UniqueIdTest {
    public static void main(String[] args) throws Exception {

        System.out.println("线程的id为：" + Thread.currentThread().getId());

        //进程获取id
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        Field jvm = runtime.getClass().getDeclaredField("jvm");
        jvm.setAccessible(true);
        VMManagement mgmt = (VMManagement) jvm.get(runtime);
        Method pidMethod = mgmt.getClass().getDeclaredMethod("getProcessId");
        pidMethod.setAccessible(true);
        int pid = (Integer) pidMethod.invoke(mgmt);
        System.out.println("进程的id为：" + pid);

        //uuid的获取
        System.out.println("uudi为：" + UUID.randomUUID());

        //java获取mac地址
        InetAddress ia = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        String macStr = DatatypeConverter.printHexBinary(mac);
        System.out.println("mac地址为：" + macStr);

    }
}
