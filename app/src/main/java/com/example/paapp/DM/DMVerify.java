package com.example.paapp.DM;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.paapp.ADM.ADM;
import com.example.paapp.ADM.ADMVerify;
import com.example.paapp.R;

public class DMVerify extends AppCompatActivity {


    EditText username,password;
    Button login;
    String strUsername,strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_m_verify);

        username=findViewById(R.id.logindm);
        password=findViewById(R.id.loginpassworddm);

        login=findViewById(R.id.btnLogindm);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strUsername=username.getText().toString();
                strPassword=password.getText().toString();

                if(strUsername.equals("dm") && strPassword.equals("12345"))
                {
                    startActivity(new Intent(DMVerify.this, ADM.class));
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(DMVerify.this)
                            .setTitle("Invalid Details")
                            .setMessage("Check Your Credentials")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, null)
//                                                new DialogInterface.OnClickListener() {
//                                            public void onClick(DialogInterface dialog, int which) {
//                                                // Continue with delete operation;
//                                            }
//                                        })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });

    }
}