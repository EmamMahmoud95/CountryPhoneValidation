package com.jumia.phone.enums;

/**
 * @author GhofranAbdelwahab
 * @Date 15th Sep 2021
 **/
public enum CountryCodeEnum {
    CAMEROON("Cameroon","(237)","\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("Ethiopia","(251)","\\(251\\)\\ ?[1-59]\\d{8}$\n"),
    MOROCCO("Morocco","(212)","\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("Mozambique","(258)","\\(258\\)\\ ?[28]\\d{7,8}$\n"),
    UGANDA("Uganda","(256)","\\(256\\)\\ ?\\d{9}$");


    private String name;
    private String code;
    private String regex;

    CountryCodeEnum(String name, String code,String regex){
        this.name=name;
        this.code=code;
        this.regex=regex;
    }


   static public CountryCodeEnum getName(String name ) {
        for (CountryCodeEnum v : values()){
            if (v.getName().equals(name)){
                return  v;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getRegex() {
        return regex;
    }
}
