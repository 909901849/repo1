package com.wkq.service.iservice;

import com.wkq.common.Result;
import com.wkq.controller.vo.DeptEmpVO;
import com.wkq.dao.entity.Dept;
import com.wkq.service.dto.DeptEmpDTO;

import java.util.List;

public interface DeptService {
    public Result<List<Dept>> findAll () throws Exception;
    public Result<List<DeptEmpDTO>> findDept (DeptEmpVO deptEmpVO) throws Exception;
}
