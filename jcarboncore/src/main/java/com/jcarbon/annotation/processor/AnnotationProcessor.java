package com.jcarbon.annotation.processor;

import com.jcarbon.annotations.CarbonBean;
import com.jcarbon.annotations.ColumnName;
import com.jcarbon.annotations.utils.AnnotationUtils;
import com.jcarbon.exceptions.JCarbonException;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shyam Ramath
 */
public class AnnotationProcessor {

    /**
     *
     * @param object
     * @param targetBean
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    void startCarbonScan(Object object, Object targetBean)
            throws IllegalAccessException, NoSuchFieldException {

        Class<?> targetBeanClass = targetBean.getClass();
        if (!targetBeanClass.isAnnotationPresent(CarbonBean.class)) {
            throw new JCarbonException("The class "+ targetBeanClass.getCanonicalName() + " is not annotated with CarbonBean");
        }

        Class<?> clazz = object.getClass();
        for(Field field: clazz.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(ColumnName.class)){
                String fieldValue=String.valueOf(field.get(object));
                fieldMapping(targetBean,field.getName(),fieldValue);
            }
        }
    }

    /**
     *
     * @param targetObj
     * @param fieldName
     * @param value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    void fieldMapping(Object targetObj,String fieldName,String value)
            throws NoSuchFieldException, IllegalAccessException {

        Field declaredField = targetObj.getClass().getDeclaredField(fieldName);
        declaredField.setAccessible(true);

        //Primitives
        if(declaredField.getType().equals((Integer.TYPE))){
            declaredField.setInt(targetObj,Integer.parseInt(value));
        }

        if(declaredField.getType().equals((char.class))){
            //declaredField.setChar(targetObj,value.to); @TODO:
        }

        if(declaredField.getType().equals(String.class)){
            declaredField.set(targetObj,value);
        }

        if(declaredField.getType().equals((Integer.class))){
            declaredField.set(targetObj,Integer.parseInt(value));
        }

        if(declaredField.getType().equals((Long.TYPE))){
            declaredField.set(targetObj,Long.getLong(value));
        }

        if(declaredField.getType().equals(Map.class)){
            declaredField.set(targetObj,Long.getLong(value));
        }
    }


    //

    // use equals to compare the data type.
//        if(f.getType().equals(List.class)){
//            result.add(f.getName());
//        }

    //for other data type

    //Map
    //if(f.getType().equals(Map.class))

    //Set
    //if(f.getType().equals(Set.class))

    //primitive int
    //if(f.getType().equals(int.class))
    //if(f.getType().equals(Integer.TYPE))

    //primitive long
    //if(f.getType().equals(long.class))
    //if(f.getType().equals(Long.TYPE))


}
