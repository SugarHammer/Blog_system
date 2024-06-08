package com.example.admin.entity;

public class SelectParam {

    private Integer uid;
    private Integer pageNum;
    private Integer pageSize;
    private Integer deleted;
    private String keyword;
    private String createtime1;
    private String createtime2;

    public SelectParam(){}



    public SelectParam(Integer uid, Integer pageNum, Integer pageSize, Integer deleted, String keyword, String createtime1, String createtime2) {
        this.uid = uid;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.deleted = deleted;
        this.keyword = keyword;
        this.createtime1 = createtime1;
        this.createtime2 = createtime2;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCreatetime1() {
        return createtime1;
    }

    public void setCreatetime1(String createtime1) {
        this.createtime1 = createtime1;
    }

    public String getCreatetime2() {
        return createtime2;
    }

    public void setCreatetime2(String createtime2) {
        this.createtime2 = createtime2;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
