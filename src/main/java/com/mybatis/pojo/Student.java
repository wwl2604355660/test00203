package com.mybatis.pojo;

public class Student {

    private Integer sId;
    private String sName;
    private String sAddress;

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sAddress='" + sAddress + '\'' +
                '}';
    }
}
