package com.netcracker.kutz.entity;

/**
 * Created by Егор on 20.04.17.
 */
public class Util {
    public static String[] parseValidThru(String validThru){
        String[] result = validThru.split("/");
        System.out.println(result);
        return result;

    }
}
