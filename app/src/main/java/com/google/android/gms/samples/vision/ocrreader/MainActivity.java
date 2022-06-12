/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.samples.vision.ocrreader;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import java.util.Locale;

public class MainActivity extends Activity {

    private CompoundButton autoFocus;
    private CompoundButton useFlash;
    public static MainActivity mainActivity;
    TextToSpeech textToSpeech;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity=MainActivity.this;
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                textToSpeech.setLanguage(Locale.US);
            }
        });
        autoFocus = (CompoundButton) findViewById(R.id.auto_focus);
        useFlash = (CompoundButton) findViewById(R.id.use_flash);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //goes to camera activity
                SharedPrefManager.getInstance(getApplicationContext()).setChecks(useFlash.isChecked(),autoFocus.isChecked(),"yes");
                Intent intent = new Intent(MainActivity.this, OcrCaptureActivity.class);
//                intent.putExtra(OcrCaptureActivity.AutoFocus, autoFocus.isChecked());  //send permission
//                intent.putExtra(OcrCaptureActivity.UseFlash, useFlash.isChecked());
                startActivity(intent);
            }
        });
    }

    public void textSpeech(String textt){
        Log.i("speek","yes");
        textToSpeech.speak(textt, TextToSpeech.QUEUE_ADD, null);
    }


}
