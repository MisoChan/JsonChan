package com.launchpersimmonseeds.jsonchan.entity;

import com.launchpersimmonseeds.jsonchan.constants.Constants;
import com.launchpersimmonseeds.jsonchan.interfaces.JsonEntityInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonObjectEntity extends JsonEntityBase implements JsonEntityInterface {

    private ArrayList<JsonFieldsEntity> jsonfieldslist;

    private HashMap<String,ArrayList<JsonObjectEntity>> jsonObjectlist = new HashMap<String,ArrayList<JsonObjectEntity>>();

    public void setJsonObjectListName(String jsonObjectListName) {
        this.jsonObjectListName = jsonObjectListName;
    }

    private String jsonObjectListName = "";

    private boolean ischild;

    public HashMap<String, ArrayList<JsonObjectEntity>> getJsonObjectlist() {
        return jsonObjectlist;
    }

    public void addJsonObjectlist(String str, ArrayList<JsonObjectEntity> jsonObjectlist) {
        this.jsonObjectlist.put(str,jsonObjectlist);
    }

    public boolean isIschild() {
        return ischild;
    }

    public void setIschild(boolean ischild) {
        this.ischild = ischild;
    }



    public ArrayList<? extends JsonEntityBase> getJsonfieldslist() {
        return jsonfieldslist;
    }

    public void setJsonfieldslist(ArrayList<JsonFieldsEntity> jsonfieldslist) {
        this.jsonfieldslist = jsonfieldslist;
    }

    public String getJsonPropString() {
        String keyname = getJsonKeyname();
        StringBuilder json = new StringBuilder();
        if(!ischild)json.append(keyname);

                json.append(Constants.JSON_CONTROL_CHARACTER.OBJECT_FIRST.getStr());
            for(int i = 0 ;i < jsonfieldslist.size() ;i++) {

                json.append(jsonfieldslist.get(i).getJsonPropString());
                if(i != jsonfieldslist.size() -1) {
                    json.append(Constants.JSON_CONTROL_CHARACTER.CHARACTER_COMMA.getStr());
                }
            }

        json.append(Constants.JSON_CONTROL_CHARACTER.OBJECT_LAST.getStr());

        if(!jsonObjectlist.isEmpty()){
            json.append(Constants.JSON_CONTROL_CHARACTER.CHARACTER_COMMA.getStr());
        }

        for(String key:jsonObjectlist.keySet()) {
            ArrayList<JsonObjectEntity> jsonObj = jsonObjectlist.get(key);
            json.append("\""+key+" \":[");


            for (int i = 0; i < jsonObj.size(); i++) {
                jsonObj.get(i).setIschild(true);
                json.append(jsonObj.get(i).getJsonPropString());
                if (i != jsonObj.size() - 1) {
                    json.append(Constants.JSON_CONTROL_CHARACTER.CHARACTER_COMMA.getStr());
                }
            }
            json.append(Constants.JSON_CONTROL_CHARACTER.ARRAY_LAST.getStr());
        }

        return json.toString();
    }


}
