package com.angrytomato.propertiesencrypt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PropertiesEncryptController {
    @Autowired
    private StringEncryptor stringEncryptor;


    /**
     * 加密字符串
     * @param body 原始数据
     * @return 加密数据
     */
    @ResponseBody
    @RequestMapping(value = "/encrypt", method = RequestMethod.POST)
    public JSONObject encryptString(@RequestBody String body) {
        JSONObject rawData = JSONObject.parseObject(body);
        String rawStr = rawData.getString("rawStr");
        Map<String, Object> resultMap = new HashMap<>();
        if(null == rawStr || "".equals(rawStr)) {
            resultMap.put("result", "原始字符串请勿为空");
        } else {
            String encryptedStr = "";
            try {
                encryptedStr = stringEncryptor.encrypt(rawStr);
            } catch (Exception e) {
                e.printStackTrace();
                encryptedStr = "加密出现问题";
            }

            resultMap.put("result", encryptedStr);
        }
        return JSONObject.parseObject(JSON.toJSONString(resultMap));
    }

    /**
     * 解密字符串
     * @param body 加密数据
     * @return 解密数据
     */
    @ResponseBody
    @RequestMapping(value = "/decrypt", method = RequestMethod.POST)
    public JSONObject decryptString(@RequestBody String body) {
        JSONObject encryptedData = JSONObject.parseObject(body);
        String encryptedStr = encryptedData.getString("encryptedStr");
        Map<String, Object> resultMap = new HashMap<>();
        if(null == encryptedStr || "".equals(encryptedStr)) {
            resultMap.put("result", "加密字符串请勿为空");
        } else {
            String decryptedStr = "";
            try {
                decryptedStr = stringEncryptor.decrypt(encryptedStr);
            } catch (Exception e) {
                e.printStackTrace();
                decryptedStr = "解密出现问题";
            }
            resultMap.put("result", decryptedStr);
        }
        return JSONObject.parseObject(JSON.toJSONString(resultMap));
    }
}
