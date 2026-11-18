package com.college.servlet;
import com.college.dao.StudentDAO;import com.college.model.Student;import com.college.model.User;
import jakarta.servlet.*;import jakarta.servlet.annotation.WebServlet;import jakarta.servlet.http.*;import java.io.IOException;import java.util.regex.Pattern;
@WebServlet("/students") public class StudentServlet extends HttpServlet {
 private final StudentDAO dao=new StudentDAO();private static final Pattern EMAIL=Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
 @Override protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{
  if(!admin(q,r))return;try{String action=q.getParameter("action");
   if("new".equals(action)||"edit".equals(action)){Student s="edit".equals(action)?dao.findById(Long.parseLong(q.getParameter("id"))):new Student();if(s==null){r.sendError(404);return;}q.setAttribute("student",s);q.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(q,r);return;}
   q.setAttribute("students",dao.findAll(q.getParameter("q")));q.setAttribute("query",q.getParameter("q")==null?"":q.getParameter("q"));q.getRequestDispatcher("/WEB-INF/views/students.jsp").forward(q,r);
  }catch(Exception ex){throw new ServletException("Unable to load students.",ex);}
 }
 @Override protected void doPost(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{
  if(!admin(q,r))return;try{if("delete".equals(q.getParameter("action"))){dao.delete(Long.parseLong(q.getParameter("id")));r.sendRedirect(q.getContextPath()+"/students?deleted=1");return;}
   Student s=new Student();s.setId(q.getParameter("id")==null||q.getParameter("id").isBlank()?0:Long.parseLong(q.getParameter("id")));
   s.setEnrollmentNo(val(q,"enrollmentNo"));s.setFullName(val(q,"fullName"));s.setEmail(val(q,"email"));s.setPhone(val(q,"phone"));s.setDepartment(val(q,"department"));
   int sem;try{sem=Integer.parseInt(val(q,"semester"));}catch(NumberFormatException ex){sem=0;}s.setSemester(sem);String error=validate(s);
   if(error!=null){q.setAttribute("error",error);q.setAttribute("student",s);q.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(q,r);return;}
   dao.save(s);r.sendRedirect(q.getContextPath()+"/students?saved=1");
  }catch(java.sql.SQLIntegrityConstraintViolationException ex){q.setAttribute("error","Enrollment number or email already exists.");q.setAttribute("student",new Student());q.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(q,r);}
  catch(Exception ex){throw new ServletException("Unable to save student.",ex);}
 }
 private boolean admin(HttpServletRequest q,HttpServletResponse r)throws IOException{User u=(User)q.getSession().getAttribute("user");if(u==null||!u.isAdmin()){r.sendError(403);return false;}return true;}
 private String validate(Student s){if(s.getEnrollmentNo().isBlank()||s.getFullName().isBlank()||s.getEmail().isBlank()||s.getDepartment().isBlank())return "Please complete all required fields.";if(!EMAIL.matcher(s.getEmail()).matches())return "Enter a valid email address.";if(s.getSemester()<1||s.getSemester()>12)return "Semester must be between 1 and 12.";return null;}
 private String val(HttpServletRequest q,String k){return q.getParameter(k)==null?"":q.getParameter(k).trim();}
}