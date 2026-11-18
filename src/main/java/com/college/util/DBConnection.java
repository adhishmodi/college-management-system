package com.college.util;
import java.io.InputStream; import java.sql.Connection; import java.sql.DriverManager; import java.util.Properties;
public final class DBConnection {
 private static final Properties CONFIG=new Properties();
 static { try(InputStream in=DBConnection.class.getClassLoader().getResourceAsStream("db.properties")){
  if(in==null) throw new IllegalStateException("db.properties missing from src/main/resources");
  CONFIG.load(in); Class.forName("com.mysql.cj.jdbc.Driver");
 }catch(Exception ex){throw new ExceptionInInitializerError(ex);} }
 private DBConnection(){}
 public static Connection getConnection() throws java.sql.SQLException {
  return DriverManager.getConnection(CONFIG.getProperty("db.url"),CONFIG.getProperty("db.username"),CONFIG.getProperty("db.password"));
 }
}