package net.javaguides.register.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javaguides.register.bean.RegisterBean;
import net.javaguides.register.dao.RegisterDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterDao registerDao;

    public void init() {
        registerDao = new RegisterDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RegisterBean registerBean = new RegisterBean();
        
        registerBean.setUsername(username);
        registerBean.setPassword(password);

        try {
            if (registerDao.insertRegistration(registerBean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("registersuccess.jsp");
            } else {
            	response.sendRedirect("registerfail.jsp");
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}