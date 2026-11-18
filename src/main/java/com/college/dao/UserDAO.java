package com.college.dao;
import com.college.model.User; import com.college.util.DBConnection; import com.college.util.PasswordUtil;
import java.sql.*;
public class UserDAO {
 public User authenticate(String email,String password)throws Exception{
  String sql="SELECT id,full_name,email,password_hash,role FROM users WHERE email=?";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql)){
   p.setString(1,email);try(ResultSet r=p.executeQuery()){if(r.next()&&PasswordUtil.verify(password,r.getString("password_hash")))
    return new User(r.getLong("id"),r.getString("full_name"),r.getString("email"),r.getString("role"));}
  }return null;
 }
}