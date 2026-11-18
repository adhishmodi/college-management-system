package com.college.filter;
import com.college.model.User; import jakarta.servlet.*; import jakarta.servlet.annotation.WebFilter; import jakarta.servlet.http.*; import java.io.IOException;
@WebFilter("/*") public class AuthFilter implements Filter {
 @Override public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException{
  HttpServletRequest req=(HttpServletRequest)request;HttpServletResponse res=(HttpServletResponse)response;
  String path=req.getRequestURI().substring(req.getContextPath().length());boolean open=path.equals("/login")||path.startsWith("/assets/");
  HttpSession session=req.getSession(false);User user=session==null?null:(User)session.getAttribute("user");
  if(open){chain.doFilter(request,response);return;}if(user==null){res.sendRedirect(req.getContextPath()+"/login");return;}chain.doFilter(request,response);
 }
}