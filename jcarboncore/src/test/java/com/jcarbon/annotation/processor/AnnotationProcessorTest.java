package com.jcarbon.annotation.processor;


import com.jcarbon.annotations.utils.AnnotationUtils;
import com.jcarbon.interfaces.Carbon;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**¡
 *
 */
public class AnnotationProcessorTest {

//    public static void main(String[] args) {
//        AnnotationProcessor processor=new AnnotationProcessor();
//        try {
//
//            Map<String,Object> elementsMap=new HashMap<>();
//            AnnotationUtils.getFieldsMap(buildCarbonBean(),elementsMap);
//            System.out.println(elementsMap);
//            CarbonTargetBean targetBean=new CarbonTargetBean();
//            elementsMap.clear();
//            processor.startCarbonScan(buildCarbonBean(),targetBean);
//            AnnotationUtils.getFieldsMap(targetBean,elementsMap);
//            System.out.println(elementsMap);
//
//            Map map = new HashMap();
//
//
//        } catch (IllegalAccessException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//    }

    static  CarbonTestBean buildCarbonBean(){
        CarbonTestBean carbonTestBean=new CarbonTestBean();
        carbonTestBean.setPassWord("topsecret");
        carbonTestBean.setUserName("jCarbon Bean");
        carbonTestBean.setAge(100);
        carbonTestBean.setSalary(10000);
        return carbonTestBean;
    }

    public void main() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach( (n) -> { System.out.println(n); } );
    }

    public  static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);

        Consumer<Integer> method = (n) -> { System.out.println(n); };
        numbers.forEach(method);

        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        System.out.println(value);
        Integer value1 = nameMap.computeIfAbsent("John", String::length);

        Carbon<Integer> carbon1= (n) -> {
            System.out.println(n);
            List<String> list;
            return n;
        };

        List<String> customers = Arrays.asList("john", "sarah", "charles", "mary");
        List<String> customersWithMoreThan100Points = customers
                .stream()
                .filter(c -> c.length() > 100)
                .collect(Collectors.toList());

//        for (Integer number : numbers) {
//            carbon.accept(number);
//        }

        Carbon carbon= (s) -> s + "Shyam";


        List<CarbonTestBean> carbonlist=new ArrayList<CarbonTestBean>();
        carbonlist.add(buildCarbonBean());
        carbonlist.add(buildCarbonBean());
        carbonlist.add(buildCarbonBean());

        carbonlist.forEach((n) -> System.out.println(n.getAddress()));
        carbonlist.stream().filter(CarbonTestBean::getCarbonTest).collect(Collectors.toList());

        for(CarbonTestBean bean :carbonlist){
//            Carbon v=bean::getUserName;
//            System.out.println(bean::setPassWord);
        }


        customers.stream().filter(c -> {
            try {
                return (c.length()>0);
            } catch (Exception e) {
                //handle exception
            }
            return false;
        }).collect(Collectors.toList());

    }
}
