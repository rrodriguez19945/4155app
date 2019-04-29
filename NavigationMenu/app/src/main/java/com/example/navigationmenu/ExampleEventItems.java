package com.example.navigationmenu;

import android.os.Parcel;
import android.os.Parcelable;

public class ExampleEventItems implements Parcelable {
    private int mImageResource;
    private int id;
    private String title;
    private String subTitle;
    private String dateTime;
    private String cost;
    private String location;
    private String eventType;
    private String url;

    protected ExampleEventItems(Parcel in) {
        mImageResource = in.readInt();
        id = in.readInt();
        title = in.readString();
        subTitle = in.readString();
        dateTime = in.readString();
        cost = in.readString();
        location = in.readString();
        eventType = in.readString();
        url = in.readString();
    }

    public static final Creator<ExampleEventItems> CREATOR = new Creator<ExampleEventItems>() {
        @Override
        public ExampleEventItems createFromParcel(Parcel in) {
            return new ExampleEventItems(in);
        }

        @Override
        public ExampleEventItems[] newArray(int size) {
            return new ExampleEventItems[size];
        }
    };

    public ExampleEventItems() {

    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(dateTime);
        dest.writeString(cost);
        dest.writeString(location);
        dest.writeString(eventType);
        dest.writeString(url);
    }
}
