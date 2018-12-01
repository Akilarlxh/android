package com.totalo.moreinfo.bbs;

import java.io.Serializable;

public class BBSbean implements Serializable{
    private String id;
    private String problem;
    private String des;
    private String fbtime;
    private String user;

    public BBSbean() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getFbtime() {
        return fbtime;
    }

    public void setFbtime(String fbtime) {
        this.fbtime = fbtime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
