package com.example.objectdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;

import java.io.IOException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech mTTs;
    static {
        if(OpenCVLoader.initDebug()){
            Log.d("MainActivity: ","Opencv is loaded");
        }
        else {
            Log.d("MainActivity: ","Opencv failed to load");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start activity for Camera
        startActivity(new Intent(MainActivity.this,CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));

        // text to voice
        String labelName = "testing";
        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS) {
                    int result = mTTs.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        Log.e("TTS", "Language is Working");
                        //voiceResponce(labelName);
                    }
                } else {
                    Log.e("TTS", "Initialization Failed");
                }
            }
//            private void voiceResponce(String labelName) {
//                mTTs.speak(labelName, TextToSpeech.QUEUE_ADD, null);
//                System.out.println("yoooooooowwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
//            }
        }
        );
        // select device and run
        // we successfully loaded model
        // before next tutorial
        // as we are going to predict in Camera Activity
        // Next tutorial will be about predicting using Interpreter


//        camera_button=findViewById(R.id.camera_button);
//        camera_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
//            }
//        }
//        );

    }
}