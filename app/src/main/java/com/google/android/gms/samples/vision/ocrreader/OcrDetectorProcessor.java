
package com.google.android.gms.samples.vision.ocrreader;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.samples.vision.ocrreader.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;

import java.util.Locale;

import static com.google.android.gms.samples.vision.ocrreader.MainActivity.mainActivity;
@RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class OcrDetectorProcessor implements Detector.Processor<TextBlock> {

    private GraphicOverlay<OcrGraphic> mGraphicOverlay;
    boolean flag1=true;
    String t1,t2;

    OcrDetectorProcessor(GraphicOverlay<OcrGraphic> ocrGraphicOverlay) {
        mGraphicOverlay = ocrGraphicOverlay;
    }

    public void receiveDetections(Detector.Detections<TextBlock> detections) {
        mGraphicOverlay.clear();
        SparseArray<TextBlock> items = detections.getDetectedItems();
        String m_text;
        for (int i = 0; i < items.size(); ++i) {
            TextBlock item = items.valueAt(i);
            m_text=item.getValue();

            if (m_text.equals("TEN RUPEES") || (m_text.equals("10") ||(m_text.equals("ten")|| (m_text.equals("en")|| (m_text.equals("te")|| (m_text.equals("te"))))))){
                mainActivity.textSpeech("ten rupees");
            } else if (m_text.equals("ONE HUNDRED RUPEES") || m_text.equals("100") || (m_text.equals("NE HUNDRED")|| (m_text.equals("NE")))){
                mainActivity.textSpeech("hundred rupees");
            }else if (m_text.equals("TWENTY RUPEES")||m_text.equals("TWENTY")|| (m_text.equals("20")|| (m_text.equals("NTY RUPEES")))) {
                mainActivity.textSpeech("twenty rupees");
            }else if (m_text.equals("FIFTY RUPEES")||m_text.equals("FIFTY")|| (m_text.equals("50")|| (m_text.equals("FTY RUPEES")))){
                mainActivity.textSpeech("fifty rupees");
            }  else if (m_text.equals("FIVE HUNDRED RUPEES") || (m_text.equals("FIVE HUNDRED")|| (m_text.equals("500")|| (m_text.equals("VE HUNDRED RUPEES"))))) {
                mainActivity.textSpeech("five hundred rupees");
            }else if (m_text.equals("ONE THOUSAND RUPEES")|| (m_text.equals("ONE THOUSAND")|| (m_text.equals("1000")|| (m_text.equals("NE THOUSAND RUPEES"))))) {
                mainActivity.textSpeech("one thousand rupees");
            }else if (m_text.equals("FIVE THOUSAND RUPEES") || (m_text.equals("5000")|| (m_text.equals("IVE THOUSAND")|| (m_text.equals("VE THOUSAND RUPEES"))))) {
                mainActivity.textSpeech("five thousand rupees");
            }
            matchRef(m_text);
            matchRefNo(m_text);
//            OcrGraphic graphic = new OcrGraphic(mGraphicOverlay, item);
//            mGraphicOverlay.add(graphic);
        }

    }

    public void matchRefNo(String txt){
        if(flag1){
         t1=txt;
         Log.i("text","text1="+t1);
                flag1=false;
        }else {
            t2=txt;
            Log.i("text","text2="+t2);
            matchRefPlusNo(t1,t2);
            flag1=true;

        }

    }

    public void matchRef(String txt){
        if (txt.equals("PT6373727")) {
            mainActivity.textSpeech("one hundred rupees");
        }else if(txt.equals("ASU3721653")){
            mainActivity.textSpeech("ten rupees");
        }else if(txt.equals("NT4845396")){
            mainActivity.textSpeech("one thousand rupees");
        }else if(txt.equals("ET4817102")){
            mainActivity.textSpeech("five hundred rupees");
        }else if(txt.equals("KQ0934627")){
            mainActivity.textSpeech("fifty rupees");
        }else if(txt.equals("C1258787")){
            mainActivity.textSpeech("five thousand rupees");
        }else if(txt.equals("GV1809297")){
            mainActivity.textSpeech("twenty rupees");
        }
    }

    public void matchRefPlusNo(String txt,String no){
        if (txt.equals("PT6373727")&& no.equals("100")) {
            mainActivity.textSpeech("one hundred rupees");
        }else if(txt.equals("ASU3721653")&& no.equals("10")){
            mainActivity.textSpeech("ten rupees");
        }else if(txt.equals("NT4845396")&& no.equals("1000")){
            mainActivity.textSpeech("one thousand rupees");
        }else if(txt.equals("ET4817102")&& no.equals("500")){
            mainActivity.textSpeech("five hundred rupees");
        }else if(txt.equals("KQ0934627")&& no.equals("50")){
            mainActivity.textSpeech("fifty rupees");
        }else if(txt.equals("C1258787")&& no.equals("5000")){
            mainActivity.textSpeech("five thousand rupees");
        }else if(txt.equals("GV1809297")&& no.equals("20")){
            mainActivity.textSpeech("twenty rupees");
        }
    }

    @Override
    public void release() {
        mGraphicOverlay.clear();
    }
}
