package com.launchpersimmonseeds.jsonchan.entity;

import com.launchpersimmonseeds.jsonchan.constants.Constants;

public class JsonEntity {

    private String keyname;

    private String value;

    public JsonEntity(String keyname, String value) {
        this.keyname = keyname;
        this.value = value;
    }

    public String getKeyname() {
        return keyname;
    }

    /**
     * return JsonKeyString
     * @return
     */
    public String getJsonKeyname() {
        //"KeyName": が返却されるはず…
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.JSON_CONTROL_CHARACTER.CHARACTER_DOUBLE_QUOTE.getStr())
                .append(this.getKeyname())
                .append(Constants.JSON_CONTROL_CHARACTER.CHARACTER_DOUBLE_QUOTE.getStr())
                .append(Constants.JSON_CONTROL_CHARACTER.OBJECT.getStr());
        return builder.toString();
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getJsonPropString(){
        // "KeyName" : value が返却される…ハズ
        StringBuilder builder = new StringBuilder();
        builder.append(this.getJsonKeyname())
                //NULLならnullになる
                .append(this.getValue() != null
                        ? this.getValue()
                        : Constants.JSON_CONTROL_CHARACTER.NULL.getStr());
        return builder.toString();
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof  JsonEntity){
            JsonEntity entity = (JsonEntity) object;
            /*
             * KEY と VALUEが一致すれば同一とみなす。
             */
            if(this.getKeyname().equals(entity.getKeyname())&&this.getValue().equals(entity.getValue())){
                return true;
            }

        }
        return false;
    }

    @Override
    public void finalize(){
        //なにもしない
    }



}

