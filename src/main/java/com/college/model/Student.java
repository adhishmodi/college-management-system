package com.college.model;
public class Student {
 private long id; private String enrollmentNo,fullName,email,phone,department; private int semester;
 public long getId(){return id;} public void setId(long v){id=v;}
 public String getEnrollmentNo(){return enrollmentNo;} public void setEnrollmentNo(String v){enrollmentNo=v;}
 public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
 public int getSemester(){return semester;} public void setSemester(int v){semester=v;}
}