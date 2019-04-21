package com.example.navigationmenu;

public class ExampleEventItems {
    private int mImageResource;
    private String title;
    private String subTitle;
    private String dateTime;

    public void EventPage() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDateTime() {
        return dateTime;
    }
}
