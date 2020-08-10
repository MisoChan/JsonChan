package com.launchpersimmonseeds.jsonchan.core;

import com.launchpersimmonseeds.jsonchan.annotations.JsonObject;
import com.launchpersimmonseeds.jsonchan.annotations.JsonValue;
import com.launchpersimmonseeds.jsonchan.entity.JsonFieldsEntity;
import com.launchpersimmonseeds.jsonchan.entity.JsonObjectEntity;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonObjectReader {

    /**
     * オブジェクト内のフィールドを取得する。
     * @param object
     * @return
     */

    protected Field[] getObjectField(Object object){
        return object.getClass().getDeclaredFields();
    }

    /**
     * Object内のアノテーションがついた要素をJsonEntityにつめて返却する。
     *
     * @param object
     * @return
     */
    protected JsonObjectEntity getJsonObject(Object object,boolean ListRead) throws IllegalAccessException {
        ArrayList<JsonFieldsEntity> returnlist = new ArrayList<JsonFieldsEntity>();
        JsonObjectEntity ent = new JsonObjectEntity();
        Field fields[] = getObjectField(object);
        String objName;
        if(object.getClass().isAnnotationPresent(JsonObject.class)){
            objName=object.getClass().getAnnotation(JsonObject.class).value();
            ent.setKeyname(objName);
        }
        for(Field f :fields){
            f.setAccessible(true);

                //JsonValueのアノテーションが実装されているか？
                if(f.isAnnotationPresent(JsonValue.class)) {
                    String KeyName = f.getAnnotation(JsonValue.class).column();
                    if(f.get(object) != null){
                        Object obj = f.get(object);
                        String str =   obj.toString();
                        JsonFieldsEntity entity = new JsonFieldsEntity(KeyName, str);
                        if(ListRead & (obj instanceof List<?>)){
                            ent.addJsonObjectlist(KeyName,listRead((List<?>)obj));

                            continue;
                        }

                        if(!(obj instanceof List<?>)) {

                            returnlist.add(entity);
                        }


                    }else{
                        String str = null;
                        JsonFieldsEntity entity = new JsonFieldsEntity(KeyName, str);
                        returnlist.add(entity);
                    }


                }


        }
        ent.setJsonfieldslist(returnlist);

        return ent;
    }

    private ArrayList<JsonObjectEntity> listRead(List<?> objlist) throws IllegalAccessException {
        ArrayList<JsonObjectEntity> jobj = new ArrayList<JsonObjectEntity>();
        for(Object listobj:objlist) {

            jobj.add(this.getJsonObject(listobj,false));
        }
        return jobj;
    }

    @Override
    protected void finalize(){
        //何もさせない
    }
}
