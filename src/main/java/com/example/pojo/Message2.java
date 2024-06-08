package com.example.pojo;

import java.util.Date;

public class Message2 {

    private Integer id;
    private Integer uid;
    private Integer mid;
    private String content;
    private Integer deleted;
    private Date createtime;
    public Message2(){}

    @Override
    public String toString() {
        return "Message2{" +
                "id=" + id +
                ", uid=" + uid +
                ", mid=" + mid +
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    public Message2(Integer uid, Integer mid, String content, Integer deleted, Date createtime) {
        this.uid = uid;
        this.mid = mid;
        this.content = content;
        this.deleted = deleted;
        this.createtime = createtime;
    }

    public Message2(Integer id, Integer uid, Integer mid, String content, Integer deleted, Date createtime) {
        this.id = id;
        this.uid = uid;
        this.mid = mid;
        this.content = content;
        this.deleted = deleted;
        this.createtime = createtime;
    }
}
