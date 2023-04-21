package com.magod.apiinterface.apiinterface;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.magod.apiclientapisdk.utils.SignUtil;

/**
 * @program: api-interface
 * @description:
 * @author: ma
 * @create: 2023-04-11 19:00
 */
public class Main {

    public static void main(String[] args) {
        String secretKey = SignUtil.getSign(null,"16ce9e701425e243b8c8336bee58d58b");
        System.out.println(secretKey);
    }
}
