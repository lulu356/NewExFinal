package com.example.newex.HotelDB;

public class User {
    public  String id, Sname,Name,Fname,Email,Password,Phone,Birthday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public User(String courseName, String courseDescription, String courseDuration) {
    }
    public User(String id, String Sname,String Name, String Fname,String Email,String Password, String Phone, String Birthday){
        this.id=id;
        this.Sname=Sname;
        this.Name=Name;
        this.Fname=Fname;
        this.Email=Email;
        this.Password=Password;
        this.Phone=Phone;
        this.Birthday=Birthday;
    }
}
