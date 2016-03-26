/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.util;

import com.google.gson.Gson;
import spark.ResponseTransformer;
/**
 *
 * @author icardenas
 */
public class JsonUtil {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
