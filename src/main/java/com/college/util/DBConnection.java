package com.college.util;
import java.io.InputStream; import java.sql.Connection; import java.sql.DriverManager; import java.util.Properties;
public final class DBConnection {
 private static final Properties CONFIG=new Properties();
 static { try(InputStream in=DBConnection.class.getClassLoader().getResourceAsStream("db.properties")){
  if(in!=null) CONFIG.load(in);
  setDefault("db.url",System.getenv("DB_URL"));
  setDefault("db.username",System.getenv("DB_USERNAME"));
  setDefault("db.password",System.getenv("DB_PASSWORD"));
  if(CONFIG.getProperty("db.url")==null||CONFIG.getProperty("db.username")==null||CONFIG.getProperty("db.password")==null)
   throw new IllegalStateException("Database settings missing. Copy db.properties.example to db.properties and configure it.");
  Class.forName("com.mysql.cj.jdbc.Driver");
 }catch(Exception ex){throw new ExceptionInInitializerError(ex);} }
 private static void setDefault(String key,String value){if(CONFIG.getProperty(key)==null&&value!=null)CONFIG.setProperty(key,value);}
 private DBConnection(){}
 public static Connection getConnection() throws java.sql.SQLException {
  return DriverManager.getConnection(CONFIG.getProperty("db.url"),CONFIG.getProperty("db.username"),CONFIG.getProperty("db.password"));
 }
}