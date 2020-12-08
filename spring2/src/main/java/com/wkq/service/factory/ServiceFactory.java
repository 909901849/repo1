package com.wkq.service.factory;

import com.wkq.common.Comm;
import com.wkq.dao.impl.DeptDaoImpl;
import com.wkq.service.impl.DeptServiceImpl;
import com.wkq.service.impl.EmppageServiceImpl;
import com.wkq.service.impl.IUserserviceImpl;

public class ServiceFactory {


    public static Object getInstance(String user) {
        if (Comm.USER.equals(user)) {
            return new IUserserviceImpl();
        } else if (Comm.EMP.equals(user)) {
            return new EmppageServiceImpl();
        } else if (Comm.DEPT.equals(user)) {
            return new DeptServiceImpl();
        }
        return null;
    }
}
