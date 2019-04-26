package com.example.navigationmenu;

public class ExampleEventItems {
    private int mImageResource;
    private int id;
    private String title;
    private String subTitle;
    private String dateTime;
    private String cost;
    private String location;
    private String eventType;
    private String url;

    public void EventPage() {

    }

    public void setId(int id) { this.id = id; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setCost(String cost) { this.cost = cost; }

    public void setLocation(String location) { this.location = location; }

    public void setEventType(String eventType) { this.eventType = eventType; }

    public void setUrl(String url) { this.url = url; }

    public int getImageResource() {
        return mImageResource;
    }

    public int getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getCost() { return cost; }

    public String getLocation() { return location; }

    public String getEventType() { return eventType; }

    public String getUrl() { return url; }
}
