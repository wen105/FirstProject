package com.shuyun.dao.imply;

import com.shuyun.dao.StudentDao;
import com.shuyun.entity.Student;
import com.shuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuyun on 2016/8/2.
 * 操作数据库的具体实现
 */
public class StudentDaoImply implements StudentDao {

    public int addStudent(Student student) {
        String sql = "insert into stu_tbl (stu_sno,stu_name) values(?,?)";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        int m = 0;
        try {
            con.setAutoCommit(false);

            ps = con.prepareStatement(sql);
            ps.setInt(1, student.getStuId());
            ps.setString(2, student.getStuName());
            m = ps.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, null);
        }
        return m;
    }

    public int deleteStudent(int stuId) {
        String sql = "delete from stu_tbl where stu_sno=?";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        int m = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, stuId);
            m = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, null);
        }
        return m;
    }

    public List<Student> findAllStudent() {
        List<Student> list = new ArrayList<Student>();
        String sql = "select * from stu_tbl ";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Student student = new Student(id, name);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update stu_tbl set stu_name=? where stu_sno=?";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps;
        int m = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, student.getStuName());
            ps.setInt(2, student.getStuId());
            m = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
}
