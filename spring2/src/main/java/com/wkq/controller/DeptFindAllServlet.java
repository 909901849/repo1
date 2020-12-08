package com.wkq.controller;

import com.alibaba.fastjson.JSON;
import com.wkq.common.Comm;
import com.wkq.common.Result;
import com.wkq.dao.entity.Dept;
import com.wkq.service.factory.ServiceFactory;
import com.wkq.service.impl.DeptServiceImpl;
import com.wkq.service.iservice.DeptService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/deptall")
public class DeptFindAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptServiceImpl instance = (DeptServiceImpl) ServiceFactory.getInstance(Comm.DEPT);
        Result<List<Dept>> result = instance.findAll();
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println(JSON.toJSONString(result));
        out.close();
    }
}
