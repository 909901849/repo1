package com.wkq.dao.idao;

import com.wkq.common.User;

import java.util.List;

public interface EmppageDao {
    public List<User> page (int page, int size);

    List<User> findByName(String ename);

    List<User> findByEmpno(int empno);

    boolean empDelete(User user);

    boolean empSave(User user);

    boolean empUpdate(User user);
}
