package com.chryl.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试:putAll,put
 * 将数据放入JSONObject
 * Created By Chr on 2019/5/24.
 */
public class TestFastJson {
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<>();
        map.put("maa", "12");
        map.put("3", "12");
        map.put("ma4a", "12");
        map.put("ma2a", "12");
        map.put("m1aa", "12");
        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "a");
        map2.put("2", "b");
        map2.put("3", "c");
        map2.put("4", "d");
        map2.put("5", "e");
        String s = JSON.toJSONString(map.toString());
        String s2 = JSON.toJSONString(map2.toString());
        System.out.println(s);
        System.out.println(s2);
        JSONObject jsonObject = new JSONObject();
        //put能结合在一起,有key,
//        jsonObject.put("map-1",map);
//        jsonObject.put("map-2",map2);
        //putAll也能,无key,完全融合
        jsonObject.putAll(map);
        jsonObject.putAll(map2);
        System.out.println(jsonObject.toString());

//        Object parse = JSONObject.parse(map.toString());
//        System.out.println(parse);

    }
}
