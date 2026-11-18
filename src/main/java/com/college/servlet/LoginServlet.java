package com.college.servlet;
import com.college.dao.UserDAO;import com.college.model.User;import jakarta.servlet.*;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.IOException;
@WebServlet("/login") public class LoginServlet extends HttpServlet {
 private final UserDAO dao=new UserDAO();
 @Override protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{
  HttpSession s=q.getSession(false);if(s!=null&&s.getAttribute("user")!=null){r.sendRedirect(q.getContextPath()+"/dashboard");return;}
  q.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(q,r);
 }
 @Override protected void doPost(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{
  String email=q.getParameter("email")==null?"":q.getParameter("email").trim();String password=q.getParameter("password")==null?"":q.getParameter("password");
  try{User user=dao.authenticate(email,password);if(user==null){q.setAttribute("error","Email or password is incorrect.");q.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(q,r);return;}
   HttpSession session=q.getSession(true);q.changeSessionId();session.setAttribute("user",user);r.sendRedirect(q.getContextPath()+"/dashboard");
  }catch(Exception ex){throw new ServletException("Unable to sign in. Check database configuration.",ex);}
 }
}