package com.example.paapp.SDM.SDM1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.paapp.ADM.ADM;
import com.example.paapp.DM.DMVerify;
import com.example.paapp.R;

public class SDM1Verify extends AppCompatActivity {
    EditText username,password;
    Button login;
    String strUsername,strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_d_m1_verify);

        username=findViewById(R.id.loginsdm1);
        password=findViewById(R.id.loginpasswordsdm1);

        login=findViewById(R.id.btnLoginsdm1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strUsername=username.getText().toString();
                strPassword=password.getText().toString();

                if(strUsername.equals("sdm1") && strPassword.equals("12345"))
                {
                    startActivity(new Intent(getApplicationContext(), SDM1.class));
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext())
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