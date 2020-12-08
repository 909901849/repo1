package com.wkq.dao.idao;

import com.wkq.common.User;

import java.sql.SQLException;

public interface UserExistDao {
    public int userExist(String username) throws SQLException;

    User login(User user);
}
