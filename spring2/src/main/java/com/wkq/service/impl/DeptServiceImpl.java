package com.wkq.service.impl;

import com.wkq.common.Comm;
import com.wkq.common.Result;
import com.wkq.common.ResultEnum;
import com.wkq.controller.vo.DeptEmpVO;
import com.wkq.dao.entity.Dept;
import com.wkq.dao.factory.DaoFactory;
import com.wkq.dao.idao.DeptDao;
import com.wkq.service.dto.DeptEmpDTO;
import com.wkq.service.iservice.DeptService;

import java.util.ArrayList;
import java.util.List;

public class DeptServiceImpl implements DeptService {

    private DeptDao deptDao;

    public DeptServiceImpl() {
        deptDao = (DeptDao) DaoFactory.getInstance(Comm.DEPT);
    }

    @Override
    public Result<List<DeptEmpDTO>> findDept(DeptEmpVO deptEmpVO) {
        List<DeptEmpDTO> dept = new ArrayList<>();
        try {
            dept = deptDao.findDept(deptEmpVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (dept.size() > 0 && dept != null)? Result.success(ResultEnum.SUCCESS,dept) :Result.error(ResultEnum.ERROR);
    }

    @Override
    public Result<List<Dept>> findAll(){
        List<Dept> list = new ArrayList<>();
        try {
            list = deptDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (list != null && list.size() > 0)? Result.success(ResultEnum.SUCCESS, list) : Result.error(ResultEnum.ERROR);
    }
}
