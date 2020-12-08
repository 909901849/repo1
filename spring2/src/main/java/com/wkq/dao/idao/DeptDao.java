package com.wkq.dao.idao;

import com.wkq.controller.vo.DeptEmpVO;
import com.wkq.dao.entity.Dept;
import com.wkq.service.dto.DeptEmpDTO;

import java.util.List;

public interface DeptDao {
    public List<Dept> findAll () throws Exception;
    public List<DeptEmpDTO> findDept (DeptEmpVO deptEmpVO) throws Exception;
}
