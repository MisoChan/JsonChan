package com.launchpersimmonseeds.jsonchan.jsonbuilder;

import com.launchpersimmonseeds.jsonchan.constants.Constants;
import com.launchpersimmonseeds.jsonchan.core.JsonObjectReader;

import java.lang.reflect.Field;

public class JsonBuilder extends JsonObjectReader{




    /**
     * Convert Entity Object to Json String
     * @param object
     * @return JsonString
     */
    public String toJson(Object object) throws IllegalAccessException {
        String json = this.getJsonObject(object,true).getJsonPropString();
        json = Constants.JSON_CONTROL_CHARACTER.OBJECT_FIRST.getStr() +json+Constants.JSON_CONTROL_CHARACTER.OBJECT_LAST.getStr();

        return json;
    }






}
