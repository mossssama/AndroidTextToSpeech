package com.example.ttsmodule;

import android.speech.tts.TextToSpeech;


public class TextToSpeechHandler {

    public static String textToSpeechTAG="TTS";
    public static String textToSpeechLANGUAGE_NOT_SUPPORTED="Language Not Supported";
    public static String textToSpeechFAILED="Initalization Failed";

    /* M Osama: Starting speaking by specifiing tts object, pitch & speed rate */
    public static void speak(TextToSpeech mTTS,String textToBeSpeech,float pitch,float speed){
        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);
        mTTS.speak(textToBeSpeech,TextToSpeech.QUEUE_FLUSH,null);
    }

}
