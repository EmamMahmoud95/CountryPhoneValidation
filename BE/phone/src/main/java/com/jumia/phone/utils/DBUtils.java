package com.jumia.phone.utils;

import com.jumia.phone.enums.CountryCodeEnum;

import java.util.Optional;

public class DBUtils {

    public static String getCountyFilterCodeQuery(String countyFilter) {
        return Optional.ofNullable(countyFilter).filter(StringUtils::isNotBlank).map(county -> {
            if (county.equals(CountryCodeEnum.CAMEROON.getName())) {
                return CountryCodeEnum.CAMEROON.getCode() + "%";
            } else if (county.equals(CountryCodeEnum.ETHIOPIA.getName())) {
                return CountryCodeEnum.ETHIOPIA.getCode() + "%";
            } else if (county.equals(CountryCodeEnum.MOROCCO.getName())) {
                return CountryCodeEnum.MOROCCO.getCode() + "%";
            } else if (county.equals(CountryCodeEnum.MOZAMBIQUE.getName())) {
                return CountryCodeEnum.MOZAMBIQUE.getCode() + "%";
            } else if (county.equals(CountryCodeEnum.UGANDA.getName())) {
                return CountryCodeEnum.UGANDA.getCode() + "%";
            } else return null;
        }).orElse(null);
    }
}
