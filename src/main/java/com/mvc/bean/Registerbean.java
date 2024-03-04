package com.mvc.bean;

public class Registerbean {

 private String fullName;
 private String email;
 private String password;
 
 public String getPassword() {
 return password;
 }
 public void setPassword(String password) {
 this.password = password;
 }
 public void setFullName(String fullName) {
 this.fullName = fullName;
 }
 public String getFullName() {
 return fullName;
 }
 public void setEmail(String email) {
 this.email = email;
 }
 public String getEmail() {
 return email;
 }
}