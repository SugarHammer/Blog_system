package com.example.pojo;

import java.util.Date;

public class Mood {
    private int id;
    private String title;
    private String content;
    private String src;
    private Date createtime;

    public Mood(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Mood(String title, String content, String src, Date createtime) {
        this.title = title;
        this.content = content;
        this.src = src;
        this.createtime = createtime;
    }

    public Mood(int id, String title, String content, String src, Date createtime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.src = src;
        this.createtime = createtime;
    }
}
