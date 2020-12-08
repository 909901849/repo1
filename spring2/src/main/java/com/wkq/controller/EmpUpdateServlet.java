package com.wkq.controller;

import com.wkq.common.Comm;
import com.wkq.common.User;
import com.wkq.service.factory.ServiceFactory;
import com.wkq.service.iservice.EmppageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/empupdate")
public class EmpUpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String ename = request.getParameter("ename");
        String age = request.getParameter("age");
        User user = new User(id,ename,Integer.parseInt(age));
        EmppageService instance = (EmppageService) ServiceFactory.getInstance(Comm.EMP);
        boolean flag = false;
        flag = instance.empUpdate(user);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/userEmpbypage");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "更新失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
