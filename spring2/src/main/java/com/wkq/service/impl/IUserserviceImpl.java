package com.wkq.service.impl;

import com.wkq.common.Comm;
import com.wkq.common.Result;
import com.wkq.common.ResultEnum;
import com.wkq.common.User;
import com.wkq.dao.idao.UserExistDao;
import com.wkq.dao.impl.UserExistDaoImpl;
import com.wkq.dao.factory.DaoFactory;
import com.wkq.service.iservice.IUserservice;

import java.sql.SQLException;

public class IUserserviceImpl implements IUserservice {

    private UserExistDao userExistDao;

    public IUserserviceImpl() {
        userExistDao = (UserExistDaoImpl) DaoFactory.getInstance(Comm.USER);
    }

    @Override
    public Result userExist(String username) throws SQLException {
        int flag = 0;
        flag = userExistDao.userExist(username);
        return flag > 0 ? Result.success(ResultEnum.SUCCESS_USER_EXIST) : Result.error(ResultEnum.ERROR_USER_EXIST);
    }

    @Override
    public Result login(User user) {
        User u = null;
        u = userExistDao.login(user);
        if (u != null) {
            u.setAge(0);
            return Result.success(ResultEnum.SUCCESS, u);
        }
        return Result.error(ResultEnum.ERROR_USER_EXIST);
    }
}
