package com.example.sentencepiece;

import androidx.appcompat.app.AppCompatActivity;

import com.github.google.sentencepiece.SentencePieceProcessor;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    SentencePieceProcessor spp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spp = new SentencePieceProcessor();
        try {
            String path = assetFilePath(this, "spm.model");
            Log.d("SentencePiece", path);
            spp.load(path);
        } catch (IOException e) {
            e.printStackTrace();
            finish();
        }
    }

    private static String assetFilePath(Context context, String path) throws IOException {
        File file = new File(context.getFilesDir(), path);
        try (InputStream is = context.getAssets().open(path)) {
            try (OutputStream os = new FileOutputStream(file)) {
                byte[] buffer = new byte[4 * 1024];
                int read;
                while ((read = is.read(buffer)) != -1) {
                    os.write(buffer, 0, read);
                }
                os.flush();
            }
            return file.getAbsolutePath();
        }
    }


}
