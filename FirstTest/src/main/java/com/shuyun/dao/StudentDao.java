package com.shuyun.dao;

import com.shuyun.entity.Student;


import java.util.List;

/**
 * Created by shuyun on 2016/8/2.
 */
public interface StudentDao {
    public int addStudent(Student student);
    public int deleteStudent(int stuId);
    public List<Student>  findAllStudent();
    public int updateStudent(Student student);
}
