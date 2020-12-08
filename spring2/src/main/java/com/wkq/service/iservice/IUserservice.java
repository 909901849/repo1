package com.wkq.service.iservice;

import com.wkq.common.Result;
import com.wkq.common.User;

import java.sql.SQLException;

public interface IUserservice {
    public Result userExist (String username) throws SQLException;

    Result login(User user);
}
