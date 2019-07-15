package com.chryl.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * 解析httpclient,restTemplate得到的数据
 * <p>
 * Created By Chr on 2019/7/15.
 */
public class TestFastJson2 {

    @Autowired
    private RestTemplate restTemplate;

    public void show() {
        String url = "http://127.0.0.1:8099/sb/queryAll";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();

        System.out.println(body);

        String jsonString = JSON.toJSONString(body);
        System.out.println(jsonString);

        //
        System.out.println("===");
        JSONObject jsonObject = JSONObject.parseObject(body);
        String statusStr = jsonObject.getString("status");
        if (statusStr.equals("success")) {
            String dataStr = jsonObject.getString("data");
            List<Map<String, String>> list = JSON.parseObject(dataStr, List.class);
            System.out.println(list);
            for (Map<String, String> stringStringMap : list) {
                System.out.println(stringStringMap);
            }
        }
    }


    public void show2() {
        String url = "http://127.0.0.1:8099/sb/queryAll";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();

        System.out.println(body);

        String jsonString = JSON.toJSONString(body);
        System.out.println(jsonString);
        //
        System.out.println("======");
        JSONObject jsonObject = JSONObject.parseObject(body);
        String statusStr = jsonObject.getString("status");
        if (statusStr.equals("success")) {
            String dataStr = jsonObject.getString("data");
            //第一次转换
            List list = JSON.parseObject(dataStr, List.class);
            for (Object object : list) {
                //第二次转化
                // SbProtModel sbProtModel = JSON.parseObject(object.toString(), SbProtModel.class);
                // System.out.println(sbProtModel);

//                System.out.println(object);
            }
        }
    }
}
