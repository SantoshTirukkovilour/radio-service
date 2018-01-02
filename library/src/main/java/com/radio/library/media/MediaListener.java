package com.radio.library.media;

/**
 * Created by Santosh on 02/01/18.
 */
public interface MediaListener {

    void onMediaLoading();

    void onMediaStarted(int totalDuration, int currentDuration);

    void onMediaStopped();

}
