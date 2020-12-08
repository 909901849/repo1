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
import java.util.Iterator;
import java.util.List;

@WebServlet("/empByempno")
public class FindByEmpnoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id+"id值");
        EmppageService instance = (EmppageService) ServiceFactory.getInstance(Comm.EMP);
        List<User> list = instance.findByEmpno(id);

        if (list.size() > 0 && list != null) {
            req.setAttribute("empupdata", list.get(0));
            req.getRequestDispatcher("/updateemp.jsp").forward(req,resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("error", "修改失败，用户不存在");
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id =Integer.parseInt(request.getParameter("empno"));

        EmppageService instance = (EmppageService) ServiceFactory.getInstance(Comm.EMP);
        List<User> list = instance.findByEmpno(id);
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
