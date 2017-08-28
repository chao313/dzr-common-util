package com.dzr.common.util;

import org.apache.commons.beanutils.Converter;


public class BigDecimalConvert implements Converter {

    @Override
    public Object convert(Class type, Object value) {
        if(value==null){
            return null;
        }
        return value;
    }
}
