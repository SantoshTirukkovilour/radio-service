package com.radio.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.radio.library.radio.RadioListener;
import com.radio.library.radio.RadioManager;

/**
 * Created by Santosh on 02/01/18.
 */
public class RadioActivity extends Activity implements RadioListener{

    private final String[] RADIO_URL = {"http://radio.sa-media.com:8000"};//{"http://rockfm.rockfm.com.tr:9450"};

    Button mButtonControlStart;
    TextView mTextViewControl;
    RadioManager mRadioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        mRadioManager = RadioManager.with(getApplicationContext());
        mRadioManager.registerListener(this);
        mRadioManager.setLogging(true);

        initializeUI();
    }

    public void initializeUI() {
        mButtonControlStart = (Button) findViewById(R.id.buttonControlStart);
        mTextViewControl = (TextView) findViewById(R.id.textviewControl);

        mButtonControlStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mRadioManager.isPlaying())
                    mRadioManager.startRadio(RADIO_URL[0]);
                else
                    mRadioManager.stopRadio();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRadioManager.connect();
    }

    @Override
    public void onRadioLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO Do UI works here.
                mTextViewControl.setText("RADIO STATE : LOADING...");
            }
        });
    }

    @Override
    public void onRadioConnected() {

    }

    @Override
    public void onRadioStarted() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO Do UI works here.
                mTextViewControl.setText("RADIO STATE : PLAYING...");
            }
        });
    }

    @Override
    public void onRadioStopped() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO Do UI works here
                mTextViewControl.setText("RADIO STATE : STOPPED.");
            }
        });
    }

    @Override
    public void onMetaDataReceived(String s, String s1) {
        //TODO Check metadata values. Singer name, song name or whatever you have.
        String checkdata = s;
        String checkdata1 = s1;
    }

    @Override
    public void onError() {

    }
}
