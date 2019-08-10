package com.itschool.platform.questions;

public class Question {
    private String title;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String t = this.title
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");


        return "{:id " + this.id + " :title \"" + t + "\"}";
    }
}
