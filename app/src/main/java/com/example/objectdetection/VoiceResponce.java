package com.example.objectdetection;

import android.speech.tts.TextToSpeech;

public class VoiceResponce {
    private TextToSpeech mTTs;


    public void TextToVoice(String labelname) {
        mTTs.speak(labelname, TextToSpeech.QUEUE_ADD, null);
        System.out.println();
        System.out.println();
        System.out.println("yoooooooowwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
