package com.example.paapp.SDM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.paapp.R;
import com.example.paapp.SDM.SDM1.SDM1;
import com.example.paapp.SDM.SDM1.SDM1Verify;
import com.example.paapp.SDM.SDM2.SDM2;
import com.example.paapp.SDM.SDM2.SDM2Verify;
import com.example.paapp.SDM.SDM3.SDM3;
import com.example.paapp.SDM.SDM3.SDM3Verify;


public class SDM extends AppCompatActivity {

    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_d_m);
        b1=findViewById(R.id.btnsdm1);
        b2=findViewById(R.id.btnsdm2);
        b3=findViewById(R.id.btnsdm3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SDM1Verify.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SDM2Verify.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SDM3Verify.class));
            }
        });

    }
}