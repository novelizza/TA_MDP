package com.example.user.inilo;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {

    private String username;
    private String id;
    private Integer img;
    private Integer follower;
    private Integer following;
    private Integer project;
    private String company;
    private String location;

    public Account(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    protected Account(Parcel in) {
        username = in.readString();
        id = in.readString();
        img = in.readInt();
        follower = in.readInt();
        following = in.readInt();
        project = in.readInt();
        company = in.readString();
        location = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(id);
        dest.writeInt(img);
        dest.writeInt(follower);
        dest.writeInt(following);
        dest.writeInt(project);
        dest.writeString(company);
        dest.writeString(location);
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }
        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
}
