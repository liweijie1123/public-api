package com.magod.apiclientapisdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.magod.apiclientapisdk.model.User;
import com.magod.apiclientapisdk.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @program: api-interface
 * @description:
 * @author: ma
 * @create: 2023-04-11 18:49
 */
@Slf4j
public class ApiClient {

    private String accessKey;

    private static final String INTERFACE_HOST="http://localhost:8090";

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private String secretKey;

    public String getNameByGet(String name){
        HashMap hashMap=new HashMap<>();
        hashMap.put("name",name);
        String result = HttpUtil.get(INTERFACE_HOST+"/api/name/", hashMap);
        return result;
    }

    public String getNameByPost(String name){
        HashMap hashMap=new HashMap<>();
        hashMap.put("name",name);
        String result = HttpUtil.post(INTERFACE_HOST+"/api/name/", hashMap);
        return result;
    }

    public String getUserName(User user){
        String json = JSONUtil.toJsonStr(user);
        log.info(json);
        HttpResponse response = HttpRequest.post(INTERFACE_HOST+"/api/name/user")
                .body(json)
                .addHeaders(getHeaderMap(json))
                .execute();
        System.out.println(response.getStatus());
        String result=response.body();
        return result;
    }

    public HashMap<String,String> getHeaderMap(String body){
        HashMap map=new HashMap();
        map.put("accessKey",accessKey);
        map.put("body",body);
        map.put("nonce", RandomUtil.randomNumbers(4));
        map.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        map.put("sign", SignUtil.getSign(body,secretKey));
        return map;
    }
}
