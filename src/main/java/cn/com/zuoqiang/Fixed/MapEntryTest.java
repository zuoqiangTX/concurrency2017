package com.zuqiang.cn.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEntryTest {
    public static void testByKeySet(Map map) {
        System.out.println("------testByKeySet start------");
        Map tempMap = map;
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println("key is : " + key);
            System.out.println("value is : " + map.get(key));
        }
        System.out.println("------testByKeySet end------\n");
    }

    public static void testByEntrySet(Map map) {
        System.out.println("------testByEntrySet start------");
        Map tempMap = map;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key is : " + entry.getKey());
            System.out.println("value is : " + entry.getValue());
        }
        System.out.println("------testByEntrySet end------\n");
    }

    public static void onlyPrintCollection(Map map) {
        System.out.println("------onlyPrintCollection start------");
        Map tempMap = map;
        Collection c = map.values();
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            String value = (String) iterator.next();
            System.out.println("value is : " + value);
        }
        System.out.println("------onlyPrintCollection end------\n");
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put("k1","v1");
        map.put("k2","v2");
        testByKeySet(map);
        testByEntrySet(map);
        onlyPrintCollection(map);
    }
}
