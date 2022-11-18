package com.bluesoftit.scancam;

import static java.util.Calendar.getInstance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import com.bluesoftit.scancam.databinding.ActivityMainBinding;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //On Click Listener For Capture Button
        //================================================
        binding.captureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
                binding.detectedText.setText("");
            }
        });

        //On Click Listener For Detect Button
        //================================================
        binding.detectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                detectTextFromImage();
            }
        });

        //On Click Listener For Copy Button
        //================================================
        binding.copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            binding.scanner.setImageBitmap(imageBitmap);
        }
    }

    private void detectTextFromImage(){



    }

//    private void displayTextFromImage(){
//        List<FirebaseVisionText.TextBlock> BlockList = FirebaseVisionText.zzbxm.getTextBlocks();
//        if (BlockList.size()==0){
//            Toast.makeText(this, "No Text Found In Image", Toast.LENGTH_SHORT).show();
//        } else {
//            for (FirebaseVisionText.TextBlock block: FirebaseVisionText.zzbxm.getTextBlocks()){
//                String text = block.getText();
//                binding.detectedText.setText(text);
//            }
//        }
//    }


}