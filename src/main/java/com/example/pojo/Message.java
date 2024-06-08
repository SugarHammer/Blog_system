package com.example.pojo;

import java.util.Date;

public class Message {

    private Integer id;
    private Integer uid;
    private String content;
    private Integer deleted;
    private Date createtime;
    public Message(){}

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", uid=" + uid +
                ", content='" + content + '\'' +
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Message(Integer uid, String content, Integer deleted, Date createtime) {
        this.uid = uid;
        this.content = content;
        this.deleted = deleted;
        this.createtime = createtime;
    }

    public Message(Integer id, Integer uid, String content, Integer deleted, Date createtime) {
        this.id = id;
        this.uid = uid;
        this.content = content;
        this.deleted = deleted;
        this.createtime = createtime;
    }
}
