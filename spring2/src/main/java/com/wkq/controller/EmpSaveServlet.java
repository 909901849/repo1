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

@WebServlet("/empsave")
public class EmpSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        EmppageService instance = (EmppageService) ServiceFactory.getInstance(Comm.EMP);
        boolean flag = false;
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        flag = instance.empSave(user);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/userEmpbypage");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "新增数据失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
