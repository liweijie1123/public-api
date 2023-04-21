package com.magod.apiclientapisdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @program: api-interface
 * @description:
 * @author: ma
 * @create: 2023-04-11 19:58
 */
public class SignUtil {
    public static String getSign(String body,String secretKey){
        Digester digester=new Digester(DigestAlgorithm.SHA256);
        String context=body+"."+secretKey;
        return digester.digestHex(context);
    }
}
