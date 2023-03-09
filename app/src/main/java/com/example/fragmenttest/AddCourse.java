package com.example.fragmenttest;

public class AddCourse {
    private String title;
    private  String date;
    private String producer;
    private  String length;

    public AddCourse() {
    }

    public AddCourse(String title, String date, String producer, String length) {
        this.title = title;
        this.date = date;
        this.producer = producer;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "AddCourse{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", producer='" + producer + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
