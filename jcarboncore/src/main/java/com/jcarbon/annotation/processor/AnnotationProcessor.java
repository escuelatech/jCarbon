package com.jcarbon.annotation.processor;

import com.jcarbon.annotations.CarbonBean;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Shyam Ramath
 */
public class AnnotationProcessor {

    void validateConditionallyRequiredFields(Object object) throws IllegalAccessException {
        Class<?> clazz= object.getClass();
        for(Field field: clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(CarbonBean.class)){
                String fieldValue=String.valueOf(field.get(object));
            }
        }
    }

    void getFieldsMap(Object object, Map<String,Object> jsonElementMap) throws IllegalAccessException {
        Class clazz=object.getClass();
        for(Field field:clazz.getDeclaredFields()){
            field.setAccessible(true);
            jsonElementMap.put(field.getName(),field.get(object));
        }
    }
}
