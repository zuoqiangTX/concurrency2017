package cn.com.zuoqiang.Fixed.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoTest {
    public static void main(String[] args) {
        Kryo kryo = new Kryo();
        //快速高效的Java序列化
        //序列化
        Output output = new Output();
        Object object = new Object();
        kryo.writeObject(output, object);
        output.close();
        //反序列化
        Input input = new Input();
        kryo.readObject(input, object.getClass());
        input.close();

    }
}
