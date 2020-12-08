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

@WebServlet("/empDelect")
public class EmpDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        EmppageService instance = (EmppageService) ServiceFactory.getInstance(Comm.EMP);
        boolean flag = false;
        User user = new User();
        user.setId(id);
        flag = instance.empDelete(user);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/userEmpbypage");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "删除失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }

    }

}
