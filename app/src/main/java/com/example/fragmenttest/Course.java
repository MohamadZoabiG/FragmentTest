package com.example.fragmenttest;

public class Course {
    private String title;
    private String date;

    public Course(String title, String date, String producer, int length) {
        this.title = title;
        this.date = date;
        this.producer = producer;
        this.length = length;
    }

    private String producer;

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", producer='" + producer + '\'' +
                ", length=" + length +
                '}';
    }

    private int length;

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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
