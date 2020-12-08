package com.wkq.dao.impl;

import com.wkq.controller.vo.DeptEmpVO;
import com.wkq.dao.entity.Dept;
import com.wkq.dao.idao.DeptDao;
import com.wkq.dao.util.JdbcUtils;
import com.wkq.service.dto.DeptEmpDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<DeptEmpDTO> findDept(DeptEmpVO deptEmpVO) throws Exception {
        Connection conn = JdbcUtils.getConnection();
        List<DeptEmpDTO> list = new ArrayList<>();
        DeptEmpDTO deptEmpDTO = null;
        String sql = " select d.dname, d.loc, e.ename, e.sal from dept as d left join emp as e " +
                " on d.deptno = e.deptno  " +
                " where d.deptno = ? and e.sal between ? and ? ";
        PreparedStatement ps    = conn.prepareStatement(sql);
        ps.setInt(1,deptEmpVO.getDeptno());
        ps.setBigDecimal(2,deptEmpVO.getMin());
        ps.setBigDecimal(3, deptEmpVO.getMax());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");
            String ename = rs.getString("ename");
            BigDecimal sal = rs.getBigDecimal("sal");
            deptEmpDTO = new DeptEmpDTO(dname, loc, ename, sal);
            list.add(deptEmpDTO);
        }
        return list;
    }

    @Override
    public List<Dept> findAll() throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        String sql = " select deptno, dname, loc from dept ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Dept> list = new ArrayList<>();
        Dept dept = null;
        while (rs.next()) {
            int deptno = rs.getInt("deptno");
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");
            dept = new Dept(deptno, dname, loc);
            list.add(dept);
        }
        return list;
    }
}
