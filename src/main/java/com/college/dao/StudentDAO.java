package com.college.dao;
import com.college.model.Student; import com.college.util.DBConnection; import java.sql.*; import java.util.*;
public class StudentDAO {
 public List<Student> findAll(String query)throws SQLException{
  List<Student> out=new ArrayList<>();String sql="SELECT * FROM students WHERE enrollment_no LIKE ? OR full_name LIKE ? OR email LIKE ? OR department LIKE ? ORDER BY id DESC";
  String term="%"+(query==null?"":query.trim())+"%";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){for(int i=1;i<=4;i++)p.setString(i,term);
   try(ResultSet r=p.executeQuery()){while(r.next())out.add(map(r));}}return out;
 }
 public Student findById(long id)throws SQLException{try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM students WHERE id=?")){
  p.setLong(1,id);try(ResultSet r=p.executeQuery()){return r.next()?map(r):null;}}}
 public int count()throws SQLException{try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement("SELECT COUNT(*) FROM students");ResultSet r=p.executeQuery()){r.next();return r.getInt(1);}}
 public void save(Student s)throws SQLException{
  boolean insert=s.getId()==0;String sql=insert?"INSERT INTO students(enrollment_no,full_name,email,phone,department,semester) VALUES(?,?,?,?,?,?)":"UPDATE students SET enrollment_no=?,full_name=?,email=?,phone=?,department=?,semester=? WHERE id=?";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,s.getEnrollmentNo());p.setString(2,s.getFullName());p.setString(3,s.getEmail());p.setString(4,s.getPhone());p.setString(5,s.getDepartment());p.setInt(6,s.getSemester());if(!insert)p.setLong(7,s.getId());p.executeUpdate();}
 }
 public void delete(long id)throws SQLException{try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM students WHERE id=?")){p.setLong(1,id);p.executeUpdate();}}
 private Student map(ResultSet r)throws SQLException{Student s=new Student();s.setId(r.getLong("id"));s.setEnrollmentNo(r.getString("enrollment_no"));s.setFullName(r.getString("full_name"));s.setEmail(r.getString("email"));s.setPhone(r.getString("phone"));s.setDepartment(r.getString("department"));s.setSemester(r.getInt("semester"));return s;}
}