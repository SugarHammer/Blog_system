package com.example.ops.entity;

import java.util.Date;

public class Ops_user {
    private Integer id;
    private String uname;
    private String phone;
    private String pwd;
    private String img;
    private String email;
    private String address;
    private String profession;
    private Integer deleted;
    private Date datetime;
    private Date createtime;

    public Ops_user(){}

    @Override
    public String toString() {
        return "Ops_user{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", img='" + img + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", profession='" + profession + '\'' +
                ", deleted=" + deleted +
                ", datetime=" + datetime +
                ", createtime=" + createtime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Ops_user(String uname, String phone, String pwd, String img, String email, String address, String profession, Integer deleted, Date datetime, Date createtime) {
        this.uname = uname;
        this.phone = phone;
        this.pwd = pwd;
        this.img = img;
        this.email = email;
        this.address = address;
        this.profession = profession;
        this.deleted = deleted;
        this.datetime = datetime;
        this.createtime = createtime;
    }

    public Ops_user(Integer id, String uname, String phone, String pwd, String img, String email, String address, String profession, Integer deleted, Date datetime, Date createtime) {
        this.id = id;
        this.uname = uname;
        this.phone = phone;
        this.pwd = pwd;
        this.img = img;
        this.email = email;
        this.address = address;
        this.profession = profession;
        this.deleted = deleted;
        this.datetime = datetime;
        this.createtime = createtime;
    }
}
