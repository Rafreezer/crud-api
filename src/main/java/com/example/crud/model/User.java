package com.example.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(unique=true)
  private String user_name;
  private String name;
  private String last_name;
  @Column(unique=true)
  private String email;
  private int age;
  @Type(type = "encryptedString")
  private String password;
  private boolean is_active;


  public User(String user_name,String name,String last_name,String email,int age,String password,Boolean is_active){
    super();
    this.user_name = user_name;
    this.name = name;
    this.last_name = last_name;
    this.email = email;
    this.age = age;
    this.password = password;
    this.is_active = is_active;

  }

  public User(){

  }
  
  

  public long getId(){
    return id;
  }

  public void setId(long id){
    this.id = id;
  }

  public String getUser_name(){
    return user_name;
  }

  public void setUser_name(String user_name){
    this.user_name = user_name;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getLast_Name(){
    return last_name;
  }

  public void setLast_Name(String last_name){
    this.last_name = last_name;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public int getAge(){
    return age;
  }

  public void setAge(int age){
    this.age = age;
  }

  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public Boolean getIs_active(){
    return is_active;
  }

  public void setIs_active(Boolean is_active){
    this.is_active = is_active;
  }

  

}
