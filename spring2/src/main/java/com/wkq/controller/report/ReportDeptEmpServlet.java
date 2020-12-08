package com.wkq.controller.report;

import com.alibaba.fastjson.JSON;
import com.wkq.common.Comm;
import com.wkq.common.Result;
import com.wkq.controller.vo.DeptEmpVO;
import com.wkq.service.dto.DeptEmpDTO;
import com.wkq.service.factory.ServiceFactory;
import com.wkq.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/reportDeptEmp")
public class ReportDeptEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String deptno = request.getParameter("deptno");
        BigDecimal min = new BigDecimal(request.getParameter("min"));
        BigDecimal max = new BigDecimal(request.getParameter("max"));
        DeptEmpVO deptEmpVO = new DeptEmpVO(Integer.parseInt(deptno), min, max);
        DeptServiceImpl instance = (DeptServiceImpl) ServiceFactory.getInstance(Comm.DEPT);
        Result<List<DeptEmpDTO>> dept = instance.findDept(deptEmpVO);
        PrintWriter writer = response.getWriter();
        writer.print(JSON.toJSONString(dept));
        writer.close();
    }
}
