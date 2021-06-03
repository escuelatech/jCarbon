package com.jcarbon.annotation.processor;


import com.jcarbon.annotations.utils.AnnotationUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AnnotationProcessorTest {
    public static void main(String[] args) {
        AnnotationProcessor processor=new AnnotationProcessor();
        try {
            CarbonTargetBean targetBean=new CarbonTargetBean();
            Map<String,Object> elementsMap=new HashMap<>();
            AnnotationUtils.getFieldsMap(buildCarbonBean(),elementsMap);
            System.out.println(elementsMap);

            elementsMap.clear();
            processor.startCarbonScan(buildCarbonBean(),targetBean);
            AnnotationUtils.getFieldsMap(targetBean,elementsMap);
            System.out.println(elementsMap);

        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    static  CarbonTestBean buildCarbonBean(){
        CarbonTestBean carbonTestBean=new CarbonTestBean();
        carbonTestBean.setPassWord("topsecret");
        carbonTestBean.setUserName("jCarbon Bean");
        carbonTestBean.setAge(100);
        carbonTestBean.setSalary(10000);
        return carbonTestBean;
    }
}
