package com.example.fragmenttest;

// TODO: change class name to Course, add more properties for course
// TODO: add category enum

//TODO: enum Category {English, Math, Physics, CS, Chemistry, Arabic, History};

public class Course {
    private String title;
    private  String date;
    private String producer;
    private  String length;
    //TODO:private Category cat;

    public Course() {
    }

    public Course(String title, String date, String producer, String length) {
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
