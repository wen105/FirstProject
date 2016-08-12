package com.shuyun.entity;

/**
 * Created by shuyun on 2016/8/2.
 */
public class Student {
    private int stuId;
    private String stuName;

    public Student(){}
    public Student(int stuId, String stuName) {
        this.stuId = stuId;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "stuId="+stuId+"        stuName="+stuName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
}
