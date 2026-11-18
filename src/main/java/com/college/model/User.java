package com.college.model;
public class User {
 private final long id; private final String fullName,email,role;
 public User(long id,String fullName,String email,String role){this.id=id;this.fullName=fullName;this.email=email;this.role=role;}
 public long getId(){return id;} public String getFullName(){return fullName;} public String getEmail(){return email;} public String getRole(){return role;}
 public boolean isAdmin(){return "ADMIN".equals(role);}
}