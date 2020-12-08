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
import java.util.List;

@WebServlet("/empByName")
public class FindByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ename = request.getParameter("ename");

        EmppageService instance = (EmppageService) ServiceFactory.getInstance(Comm.EMP);
        List<User> list = instance.findByName(ename);
        if (list.size() > 0 && list != null) {
            request.setAttribute("empsFromServer", list);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "模糊查询失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

}
