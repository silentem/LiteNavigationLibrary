package com.whaletail.lite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author whaletail on 13.04.18.
 */
public class LiteState implements Parcelable {
    public static final Creator<LiteState> CREATOR = new Creator<LiteState>() {
        @Override
        public LiteState createFromParcel(Parcel in) {
            return new LiteState(in);
        }

        @Override
        public LiteState[] newArray(int size) {
            return new LiteState[size];
        }
    };
    private int position;

    public LiteState(int position) {
        this.position = position;
    }

    protected LiteState(Parcel in) {
        position = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(position);
    }
}
