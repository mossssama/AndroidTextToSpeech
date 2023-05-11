package com.example.ttsmodule;

import static com.example.ttsmodule.TextToSpeechHandler.speak;
import static com.example.ttsmodule.TextToSpeechHandler.textToSpeechFAILED;
import static com.example.ttsmodule.TextToSpeechHandler.textToSpeechLANGUAGE_NOT_SUPPORTED;
import static com.example.ttsmodule.TextToSpeechHandler.textToSpeechTAG;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import com.example.ttsmodule.databinding.ActivityMainBinding;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mTTS = textToSpeechInitialize(this,"ar");
        binding.buttonSpeak.setOnClickListener(v -> speak(mTTS,binding.textEt.getText().toString(),1,1));

    }

    /* M Osama: intialize tts by specifing the speech language*/
    TextToSpeech textToSpeechInitialize(Context context, String language){
        return new TextToSpeech(context, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = mTTS.setLanguage(new Locale(language));
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {Log.e(textToSpeechTAG, textToSpeechLANGUAGE_NOT_SUPPORTED);}
                else { binding.buttonSpeak.setEnabled(true); }
            } else { Log.e(textToSpeechTAG, textToSpeechFAILED); }
        });
    }

    @Override
    protected void onDestroy() {
        if (mTTS != null) {   mTTS.stop();  mTTS.shutdown();    }
        super.onDestroy();
    }

}








//    private void speak() {
//        String text = binding.editText.getText().toString();
//        float pitch = (float) binding.seekBarPitch.getProgress() / 50;
//        if (pitch < 0.1) pitch = 0.1f;
//        float speed = (float) binding.seekBarSpeed.getProgress() / 50;
//        if (speed < 0.1) speed = 0.1f;
//
//        mTTS.setPitch(pitch);
//        mTTS.setSpeechRate(speed);
//
//        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//    }