package com.banfikristof.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Main3Activity extends AppCompatActivity {

    EditText etBemenet;
    Button general, generalAztec;
    ImageView qrKod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etBemenet.getText().toString().isEmpty()){
                    Toast.makeText(Main3Activity.this,"Nincs beírva semmi!",Toast.LENGTH_SHORT).show();
                    return;
                }
                MultiFormatWriter writer = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = writer.encode(etBemenet.getText().toString(), BarcodeFormat.QR_CODE,1000,1000);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(bitMatrix);
                    qrKod.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

        generalAztec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etBemenet.getText().toString().isEmpty()){
                    Toast.makeText(Main3Activity.this,"Nincs beírva semmi!",Toast.LENGTH_SHORT).show();
                    return;
                }
                MultiFormatWriter writer = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = writer.encode(etBemenet.getText().toString(), BarcodeFormat.AZTEC,1000,1000);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(bitMatrix);
                    qrKod.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void init() {
        etBemenet = findViewById(R.id.etBemenet);
        general = findViewById(R.id.btnGenerate);
        generalAztec = findViewById(R.id.btnGenerateAztec);
        qrKod = findViewById(R.id.ivQRkod);
    }
}
