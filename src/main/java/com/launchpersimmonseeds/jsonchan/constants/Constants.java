package com.launchpersimmonseeds.jsonchan.constants;

public class Constants {


    /**
     * JSON Characters
     */
    public enum JSON_CONTROL_CHARACTER{
        OBJECT_FIRST("{"),
        OBJECT_LAST("}"),
        ARRAY_FIRST("["),
        ARRAY_LAST("]"),
        CHARACTER_DOUBLE_QUOTE("\""),
        CHARACTER_COMMA(","),
        OBJECT(":"),
        NULL("null");




        private final String str;
        JSON_CONTROL_CHARACTER(String string){
            this.str = string;
        }

        public String getStr() {
            return this.str;
        }
    }
}
