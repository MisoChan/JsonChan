package com.launchpersimmonseeds.jsonchan.entity;

import com.launchpersimmonseeds.jsonchan.constants.Constants;

public class JsonEntityBase {

    protected String keyname;

    public String getKeyname() {
        return keyname;
    }


    public String getJsonPropString(){

        return "";
    }
    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public String getJsonKeyname() {
        //"KeyName": が返却されるはず…
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.JSON_CONTROL_CHARACTER.CHARACTER_DOUBLE_QUOTE.getStr())
                .append(this.keyname)
                .append(Constants.JSON_CONTROL_CHARACTER.CHARACTER_DOUBLE_QUOTE.getStr())
                .append(Constants.JSON_CONTROL_CHARACTER.OBJECT.getStr());
        return builder.toString();
    }
}
