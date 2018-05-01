package com.maricia.fragmentpractice;

public class work {

    private String work_date;
    private String work_name;
    private int work_image;

    //constructor
    public work() {

    }

    public work(String work_date, String work_name, int work_image) {
        this.work_date = work_date;
        this.work_name = work_name;
        this.work_image = work_image;
    }

    //getters
    public String getWork_date() {
        return work_date;
    }

    public String getWork_name() {
        return work_name;
    }

    public int getWork_image() {
        return work_image;
    }

    //setters
    public void setWork_date(String work_date) {
        this.work_date = work_date;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public void setWork_image(int work_image) {
        this.work_image = work_image;
    }


}
