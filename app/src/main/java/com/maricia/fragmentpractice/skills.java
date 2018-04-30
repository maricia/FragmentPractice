package com.maricia.fragmentpractice;

public class skills {
    private String skill;
    private int skillamount;
    private int photo;

    public skills() {

    }

    public skills(String skill, int skillamount, int photo) {
        this.skill = skill;
        this.skillamount = skillamount;
        this.photo = photo;
    }



    //getters


    public String getSkill() {
        return skill;
    }

    public int getSkillamount() {
        return skillamount;
    }

    public int getPhoto() {
        return photo;
    }


    //setters

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setSkillamount(int skillamount) {
        this.skillamount = skillamount;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
