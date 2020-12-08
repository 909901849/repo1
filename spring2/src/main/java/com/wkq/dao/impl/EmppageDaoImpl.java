package com.wkq.dao.impl;

import com.wkq.common.User;
import com.wkq.dao.idao.EmppageDao;
import com.wkq.dao.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmppageDaoImpl implements EmppageDao {
    @Override
    public boolean empUpdate(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JdbcUtils.getConnection();
            String sql = " update student set name = ?, age = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setInt(3,user.getId());
            int i = ps.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(rs, ps, conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean empSave(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JdbcUtils.getConnection();
            String sql = " insert into student( name, age) values( ?, ?) ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            int i = ps.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(rs, ps, conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean empDelete(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JdbcUtils.getConnection();
            String sql = " delete from student where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            int i = ps.executeUpdate();
            if (i > 0) {
                flag = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(rs, ps, conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public List<User> findByEmpno(int empno) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            User user;
            conn = JdbcUtils.getConnection();
            String sql = " select id, name, age from student where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empno);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("数据库：" + rs.getInt("id") + rs.getString("name") + rs.getInt("age"));
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(rs, ps, conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public List<User> findByName(String ename) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            User user;
            conn = JdbcUtils.getConnection();
            String sql = " select id, name,age from student where name like ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ename + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(rs, ps, conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;

    }

    @Override
    public List<User> page(int page, int size) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = " select id, name, age from student limit ?, ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1) * size);
            ps.setInt(2, size);
            rs = ps.executeQuery();
            User user;
            while (rs.next()) {
                user = new User(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(rs, ps, conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }
}
