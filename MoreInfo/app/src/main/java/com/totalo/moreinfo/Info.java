package com.totalo.moreinfo;

import java.io.Serializable;

/**
 * 消息实体类
 */
public class Info implements Serializable{
    //类别
    private String lable;
    //标题
    private String title;
    //作者
    private String author;
    //发表时间
    private String publishtime;
    //链接
    private String link;
    //简介
    private String introduction;
    //内容
    private String brief;

    public Info() {
    }

    public Info(String lable, String title, String author, String publishtime, String link, String introduction, String brief) {
        this.lable = lable;
        this.title = title;
        this.author = author;
        this.publishtime = publishtime;
        this.link = link;
        this.introduction = introduction;
        this.brief = brief;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
