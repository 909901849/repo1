package com.wkq.dao.factory;

import com.wkq.common.Comm;
import com.wkq.dao.impl.DeptDaoImpl;
import com.wkq.dao.impl.EmppageDaoImpl;
import com.wkq.dao.impl.UserExistDaoImpl;

public class DaoFactory {

    public static Object getInstance(String user) {
        if (Comm.USER.equals(user)) {
            return new UserExistDaoImpl();
        } else if (Comm.EMP.equals(user)) {
            return new EmppageDaoImpl();
        } else if (Comm.DEPT.equals(user)) {
            return new DeptDaoImpl();
        }
        return null;
    }
}
