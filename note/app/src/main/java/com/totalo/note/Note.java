package com.totalo.note;

public class Note {
    private String title;
    private String time;
    private String add;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note() {

    }

    public Note(String title, String time, String add, String content) {
        this.title = title;
        this.time = time;
        this.add = add;
        this.content = content;
    }
}
