package com.example.pojo;

import java.util.Date;

public class Comment {

    private Integer id;
    private Integer uid;
    private Integer aid;
    private String content;
    private Integer deleted;
    private Date createtime;

    public Comment(){}

    @Override
    public String toString() {
        return "CommentController{" +
                "id=" + id +
                ", uid=" + uid +
                ", aid=" + aid +
                ", content='" + content + '\'' +
                ", deleted=" + deleted +
                ", createtime=" + createtime +
                '}';
    }

    public Comment(Integer uid, Integer aid, String content, Integer deleted, Date createtime) {
        this.uid = uid;
        this.aid = aid;
        this.content = content;
        this.deleted = deleted;
        this.createtime = createtime;
    }

    public Comment(Integer id, Integer uid, Integer aid, String content, Integer deleted, Date createtime) {
        this.id = id;
        this.uid = uid;
        this.aid = aid;
        this.content = content;
        this.deleted = deleted;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
