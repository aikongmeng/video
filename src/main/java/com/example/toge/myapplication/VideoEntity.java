package com.example.toge.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by toge on 15/12/15.
 */
public class VideoEntity implements Parcelable {

    private String url;
    private String imgUrl;
    private String vid;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.imgUrl);
        dest.writeString(this.vid);
    }

    public VideoEntity() {
    }

    protected VideoEntity(Parcel in) {
        this.url = in.readString();
        this.imgUrl = in.readString();
        this.vid = in.readString();
    }

    public static final Creator<VideoEntity> CREATOR = new Creator<VideoEntity>() {
        public VideoEntity createFromParcel(Parcel source) {
            return new VideoEntity(source);
        }

        public VideoEntity[] newArray(int size) {
            return new VideoEntity[size];
        }
    };
}
