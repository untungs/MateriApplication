package com.andro.indieschool.reclistapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

    public String title;
    public boolean selected;

    public Category(String title, boolean selected) {
        this.title = title;
        this.selected = selected;
    }

    protected Category(Parcel in) {
        title = in.readString();
        selected = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeByte((byte) (selected ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
