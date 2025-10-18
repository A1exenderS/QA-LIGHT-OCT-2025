package org.qa.light.session5;

import org.qa.light.session3.Ford;
import org.qa.light.session4.Boat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("key_1", "value_1");
        hashMap.put("key_2", "value_2");
        hashMap.putIfAbsent("key_2", "value_3");

        System.out.println(hashMap.get("key_2"));
        System.out.println(hashMap.getOrDefault("key_5", "there was no key 5"));

        Map<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("key_1", "hm2-value_1");
        hashMap2.put("key_2", "hm2-value_2");
        hashMap2.put("key_3", "hm2-value_3");

//        hashMap2.putAll(hashMap);
//        hashMap.putAll(hashMap2);

//        hashMap.remove("key_1");
//        hashMap.remove("key_2", "wrong_value");
//        System.out.println(hashMap.size());
        hashMap.replace("key_3", null);

        System.out.println(hashMap.size());


    }
}
