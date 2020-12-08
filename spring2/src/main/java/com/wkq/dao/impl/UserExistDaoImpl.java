package com.wkq.dao.impl;

import com.wkq.common.User;
import com.wkq.dao.idao.UserExistDao;
import com.wkq.dao.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExistDaoImpl implements UserExistDao {
    @Override
    public int userExist(String username) throws SQLException {

        int anInt = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = " select count(1) from student where name = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                anInt = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, ps, conn);
        }
        return anInt;
    }

    @Override
    public User login(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = " select id, name, age from student where name = ? and age = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            rs = ps.executeQuery();
            if (rs.next()) {
                u = new User(rs.getInt("id"),rs.getString("name"), rs.getInt("age"));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                JdbcUtils.close(rs, ps, conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return u;
    }
}
