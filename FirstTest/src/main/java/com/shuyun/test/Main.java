package com.shuyun.test;

import com.shuyun.dao.StudentDao;
import com.shuyun.dao.imply.StudentDaoImply;
import com.shuyun.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuyun on 2016/8/2.
 */
public class Main {
    public static void main(String[] args) {
        StudentDao studentDao=new StudentDaoImply();

        //插入
//        Student student=new Student(16,"娇娇");
//        int m=studentDao.addStudent(student);


        //查询
//        List<Student> list=new ArrayList<Student>();
//        list=studentDao.findAllStudent();
//        list.stream().forEach(System.out::println);

        //删除
//        int m=studentDao.deleteStudent(12);
//        if (m>0){
//            System.out.println("delete success");
//        }else {
//            System.out.println("delete failed");
//        }

        //修改
        Student student=new Student(16,"娇娇");
        int m=studentDao.updateStudent(student);
        System.out.println(m>0);
    }
}
