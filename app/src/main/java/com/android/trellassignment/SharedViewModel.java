package com.android.trellassignment;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    static private Uri video;
    static private int BitRate;

    public int getBitRate() {
        return BitRate;
    }

    public void setBitRate(int bitRate) {
        BitRate = bitRate;
    }

    public Uri getVideo() {
        return video;
    }

    public void setVideo(Uri video) {
        this.video = video;
    }
}
