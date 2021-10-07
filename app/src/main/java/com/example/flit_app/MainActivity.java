package com.example.flit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        try {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL("testingapp_mad"))
                    .setRoom("test123")
                    .setAudioMuted(true)
                    .setVideoMuted(true)
                    .setAudioOnly(false)
                    .setWelcomePageEnabled(false)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public void onClickButton(View v) {
        EditText text = (EditText)findViewById(R.id.editTextTextPersonName);
        String text1 = text.getText().toString();
        if(text1.length()>0) {

            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setRoom(text1).setAudioMuted(true)
                    .setVideoMuted(true).build();
            JitsiMeetActivity.launch(this,options);
        }
    }

    public void onClickExit(View v) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
    }
    /*@Override
    public void onBackPressed () {
        MainActivity.this.finish();
        System.exit(0);
    }*/

}