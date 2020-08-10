package com.launchpersimmonseeds.jsonchan.core;

import com.launchpersimmonseeds.jsonchan.entity.JsonEntity;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
class ObjectReader {

    /**
     * オブジェクト内のフィールドを取得する。
     * @param object
     * @return
     */

    protected Field[] getObjectField(Object object){
        return object.getClass().getDeclaredFields();
    }

    protected ArrayList<JsonEntity> getJsonFieldsList(Object object){


        return null;
    }

    @Override
    protected void finalize(){
        //何もさせない
    }
}
