package com.wkq.controller;

import com.alibaba.fastjson.JSON;
import com.wkq.common.Comm;
import com.wkq.common.Result;
import com.wkq.service.factory.ServiceFactory;
import com.wkq.service.impl.IUserserviceImpl;
import com.wkq.service.iservice.IUserservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/userExistServlet")
public class UserExistServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");

//        需要一个service对象，我们通过工厂创建service对象
        IUserservice userservice = (IUserserviceImpl) ServiceFactory.getInstance(Comm.USER);
        Result result = null;
        try {
            result = userservice.userExist(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        String s = JSON.toJSONString(result);
        writer.print(s);
    }
}
//-Dfile.encoding=UTF-8
