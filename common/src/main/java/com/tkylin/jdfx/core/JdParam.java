package com.tkylin.jdfx.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tkyli on 2017/3/11.
 */
public class JdParam {
    Map<String, String> params = new HashMap<String, String>();

    public void addParam(String name, String value) {
        params.put(name, value);
    }

    public String removeParam(String name) {
        return params.remove(name);
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public String getUrlParams() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        if(sb.length()>0){
            sb.insert(0,'?');
        }
        return sb.toString();
    }
}
