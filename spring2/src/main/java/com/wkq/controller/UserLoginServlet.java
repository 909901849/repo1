package com.wkq.controller;

import com.alibaba.fastjson.JSON;
import com.wkq.common.Comm;
import com.wkq.common.Result;
import com.wkq.common.User;
import com.wkq.service.factory.ServiceFactory;
import com.wkq.service.iservice.IUserservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String age = request.getParameter("password");
        User user = new User(username, Integer.parseInt(age));

        IUserservice instance = (IUserservice) ServiceFactory.getInstance(Comm.USER);
        Result result = instance.login(user);
        PrintWriter writer = response.getWriter();
        String s = JSON.toJSONString(result);
        writer.print(s);
    }

}
