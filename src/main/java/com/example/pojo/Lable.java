package com.example.pojo;

public class Lable {

    private Integer id;
    private String lname;
    public Lable(){}

    @Override
    public String toString() {
        return "Lable{" +
                "id=" + id +
                ", lname='" + lname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Lable(String lname) {
        this.lname = lname;
    }

    public Lable(Integer id, String lname) {
        this.id = id;
        this.lname = lname;
    }
}
