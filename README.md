# AndroidTextToSpeech
How to use Android's Text-To-Speech to support Arabic langauge in Java

# **Usage** 
***
[1] **Add This [TextToSpeechHandler class](https://github.com/mossssama/AndroidTextToSpeech/blob/main/TTSmodule/app/src/main/java/com/example/ttsmodule/TextToSpeechHandler.java) in your project** 
***
[2] **Paste the following in the Activity/Fragment you want to use tts in**

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
***
[3] **Write the following in the Activity/Fragment you will use tts in** 
    
    TextToSpeech mTTS = textToSpeechInitialize(this,"ar");           /* Change with your desired language */
***
[4] **Execute the following function where you want to start tts conversion**
        
    speak(mTTS,textYouWantToConvert,pitchRate,speedRate)    /* Let pitch/speed default values = 1 */ 
***        
[5]  **To Allow conversion to Arabic; Follow the following Photos to assure that you are using Google's Engine**
![1](https://github.com/mossssama/AndroidTextToSpeech/assets/92642692/1821826c-eaf9-4ca4-a2f7-d5cdd34378bf)
![2](https://github.com/mossssama/AndroidTextToSpeech/assets/92642692/90413fa5-760e-4ec9-9433-b3c95a48e165)
![3](https://github.com/mossssama/AndroidTextToSpeech/assets/92642692/c5cf16de-c3d7-453c-9e36-786941eb492e)
![4](https://github.com/mossssama/AndroidTextToSpeech/assets/92642692/220be1e6-9f8b-4cf1-a0ba-83c4eb20a43e)
![5](https://github.com/mossssama/AndroidTextToSpeech/assets/92642692/46c3c6c4-9671-4aba-a553-619bc0b57609)

***
