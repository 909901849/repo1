package com.wkq.service.impl;

import com.wkq.common.Comm;
import com.wkq.common.User;
import com.wkq.dao.idao.EmppageDao;
import com.wkq.dao.impl.EmppageDaoImpl;
import com.wkq.dao.factory.DaoFactory;
import com.wkq.service.iservice.EmppageService;

import java.util.List;

public class EmppageServiceImpl implements EmppageService {

    private EmppageDao emppageDao;

    public EmppageServiceImpl() {
        emppageDao = (EmppageDaoImpl)DaoFactory.getInstance(Comm.EMP);
    }

    @Override
    public boolean empUpdate(User user) {
        boolean flag = emppageDao.empUpdate(user);
        return flag;
    }

    @Override
    public boolean empSave(User user) {
        boolean flag = emppageDao.empSave(user);
        return flag;
    }

    @Override
    public boolean empDelete(User user) {
        boolean flag = emppageDao.empDelete (user);
        return flag;
    }

    @Override
    public List<User> findByEmpno(int empno) {
        List<User> list = emppageDao.findByEmpno(empno);
        return list;
    }

    @Override
    public List<User> findByName(String ename) {
        List<User> list = emppageDao.findByName(ename);
        return list;
    }

    @Override
    public List<User> page(int page, int size) {
        List<User> list = emppageDao.page(page, size);
        return list;
    }
}
