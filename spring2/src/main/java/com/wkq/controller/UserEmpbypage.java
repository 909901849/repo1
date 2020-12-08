package com.wkq.controller;

import com.wkq.common.Comm;
import com.wkq.common.User;
import com.wkq.service.factory.ServiceFactory;
import com.wkq.service.impl.EmppageServiceImpl;
import com.wkq.service.iservice.EmppageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/userEmpbypage")
public class UserEmpbypage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int size = 5;
        EmppageService instance = (EmppageServiceImpl) ServiceFactory.getInstance(Comm.EMP);
        List<User> result = instance.page(page, size);

        Iterator<User> iterator = result.iterator();
        if (result.size() > 0 && result != null) {
            request.setAttribute("empsFromServer", result);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "查询失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

}
