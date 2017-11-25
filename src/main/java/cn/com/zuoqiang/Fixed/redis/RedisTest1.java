package cn.com.zuoqiang.Fixed.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisTest1 {
    private Jedis conn;

    public RedisTest1() {
        this.conn = new Jedis("10.211.55.9", 6379);
        System.out.println("初始化redis成功!");
        System.out.println("服务是否运行: " + conn.ping());
    }

    public static void main(String[] args) {
        RedisTest1 redisTest = new RedisTest1();
        //String的使用
        redisTest.RedisString("String", "Ruby", "Python", "Java");
        //列表的使用
        redisTest.RedisList(0, -1, "List", "Ruby", "Python", "Java");
        //Set的使用
        redisTest.RedisSet("set", "zq", "wb", "lwz");
        //有序集合的使用
        redisTest.RedisZset(true, "zset", 0, "mongo");
        redisTest.RedisZset(true, "zset", 1, "java");
        //Hash的使用
        redisTest.RedisHash("hash", "k1", "v1");
        //清空所有的key
        String[] keys = redisTest.RedisByKeys();
        for (String key : keys) {
            redisTest.clearOldKey(key);
        }

    }

    private void RedisSet(String key, String... fields) {
        for (String field : fields) {
            conn.sadd(key, field);
        }
        Set<String> set = conn.smembers(key);
        Iterator<String> it = set.iterator();
        StringBuilder stringBuilder = new StringBuilder("");
        while (it.hasNext()) {
            stringBuilder.append(it.next().toString() + "|");
        }
        System.out.println("Set里面的值为: " + stringBuilder);
    }

    private void RedisZset(boolean multi, String key, int score, String member) {
        if (multi == false) {
            clearOldKey(key);

        }
        conn.zadd(key, score, member);
        Set<String> zsets = conn.zrange(key, 0, -1);
        Iterator<String> it = zsets.iterator();
        StringBuilder str = new StringBuilder("");
        while (it.hasNext()) {
            str.append(it.next().toString() + "|");
        }
        System.out.println("zset 的set为: " + str.toString());
    }

    private void RedisHash(String key, String feild, Object object) {
        clearOldKey(key);
        conn.hset(key, feild, (String) object);
        String str = conn.hget(key, feild);
        System.out.println("Map中存入的值为: " + str);
    }

    public void RedisString(String key, String... strs) {
        clearOldKey(key);
        for (String str : strs) {
           // conn.set(key, str); //多次set会覆盖值
            conn.setex(key, 2, str);  //过期时间为两秒
        }
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("String取出的字符串为: " + conn.get(key));
            TimeUnit.SECONDS.sleep(2);
            System.out.println("过期以后String取出的字符串为: " + conn.get(key));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("String取出的字符串为: " + conn.get(key));

    }

    public void clearOldKey(String key) {
        conn.del(key);
    }

    public void RedisList(int start, int end, String key, String... strs) {
        clearOldKey(key);
        for (String str : strs) {
            conn.lpush(key, str);  //lpush会叠加
        }
        List<String> stringList = conn.lrange("list", start, end);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("List取出的值为: " + stringList.get(i).toString());
        }
    }

    public String[] RedisByKeys() {
        Set<String> keys = conn.keys("*");
        String[] strs = new String[keys.size()];
        Iterator<String> it = keys.iterator();
        int i = 0;
        while (it.hasNext()) {
            String key = it.next();
            strs[i] = key;
            i++;
            System.out.println("输出所有的key的名字: " + key);
        }
        return strs;
    }




}
