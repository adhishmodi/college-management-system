package com.college.servlet;
import com.college.dao.StudentDAO;import com.college.model.User;import jakarta.servlet.*;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.IOException;
@WebServlet("/dashboard") public class DashboardServlet extends HttpServlet {
 private final StudentDAO dao=new StudentDAO();
 @Override protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{
  User user=(User)q.getSession().getAttribute("user");try{q.setAttribute("studentCount",user.isAdmin()?dao.count():0);q.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(q,r);}
  catch(Exception ex){throw new ServletException("Unable to load dashboard.",ex);}
 }
}