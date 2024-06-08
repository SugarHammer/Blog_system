package com.example.pojo;

import java.util.Date;

public class Article {
    private Integer id;
    private String img;
    private Integer uid;
    private String title;
    private Integer lid;
    private String content;
    private Integer heat;
    private Integer deleted;
    private Date createtime;

    public Article(){}

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", lid=" + lid +
                ", content='" + content + '\'' +
                ", heat=" + heat +
                ", deleted=" + deleted +
                ", createtime=" + createtime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Article(String img, Integer uid, String title, Integer lid, String content, Integer heat, Integer deleted, Date createtime) {
        this.img = img;
        this.uid = uid;
        this.title = title;
        this.lid = lid;
        this.content = content;
        this.heat = heat;
        this.deleted = deleted;
        this.createtime = createtime;
    }

    public Article(Integer id, String img, Integer uid, String title, Integer lid, String content, Integer heat, Integer deleted, Date createtime) {
        this.id = id;
        this.img = img;
        this.uid = uid;
        this.title = title;
        this.lid = lid;
        this.content = content;
        this.heat = heat;
        this.deleted = deleted;
        this.createtime = createtime;
    }
}
