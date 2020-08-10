package com.launchpersimmonseeds.jsonchan.entity;

import com.launchpersimmonseeds.jsonchan.constants.Constants;
import com.launchpersimmonseeds.jsonchan.interfaces.JsonEntityInterface;

public class JsonFieldsEntity extends JsonEntityBase implements JsonEntityInterface {



    private String value;

    private boolean stringFlg = true;

    public boolean isStringFlg() {
        return stringFlg;
    }

    public void setStringFlg(boolean stringFlg) {
        this.stringFlg = stringFlg;
    }

    public JsonFieldsEntity(String keyname, String value) {
        this.keyname = keyname;
        this.value = value;
    }





    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * return JsonKeyString
     * @return
     */
    public String getJsonPropString(){
        // "KeyName" : value が返却される…ハズ
        StringBuilder builder = new StringBuilder();
        builder.append(this.getJsonKeyname())
                //NULLならnullになる
                .append(this.getValue() != null
                        ? Constants.JSON_CONTROL_CHARACTER.CHARACTER_DOUBLE_QUOTE.getStr()+this.getValue()+Constants.JSON_CONTROL_CHARACTER.CHARACTER_DOUBLE_QUOTE.getStr()
                        : Constants.JSON_CONTROL_CHARACTER.NULL.getStr());
        return builder.toString();
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof JsonFieldsEntity){
            JsonFieldsEntity entity = (JsonFieldsEntity) object;
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

