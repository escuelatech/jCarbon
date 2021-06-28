package com.jcarbon.annotation.processor;

import com.jcarbon.annotations.CarbonBean;
import com.jcarbon.annotations.ColumnName;


public class CarbonTestBean {

    @ColumnName
    public String userName;

    @ColumnName
    String passWord;

    @ColumnName
    String address;


    @ColumnName
    int age;

    @ColumnName
    Integer salary;

    Boolean isCarbonTest;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Boolean getCarbonTest() {
        return isCarbonTest;
    }

    public void setCarbonTest(Boolean carbonTest) {
        isCarbonTest = carbonTest;
    }
}
