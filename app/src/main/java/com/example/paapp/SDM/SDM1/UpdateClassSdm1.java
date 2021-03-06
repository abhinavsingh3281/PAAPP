package com.example.paapp.SDM.SDM1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.paapp.MainActivity;
import com.example.paapp.R;
import com.example.paapp.SDM.SDM2.UpdateSdm2;
import com.example.paapp.SDM.SDM3.SDM3;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UpdateClassSdm1 extends AppCompatActivity {
    DatabaseReference mdatabase;
    Button b1,b2;
    EditText editText;
    String name, mobileno, date, time, stremail, strreview, strvisitor;
    ProgressBar progressBar,progressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_class_sdm1);


        b1=findViewById(R.id.btnApprove);
        b2=findViewById(R.id.btnReject);

        Random random=new Random();

        int ra=random.nextInt(1000);

        progressBar=findViewById(R.id.progressbarsdm1);
        progressBar1=findViewById(R.id.progressbarsdm11);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                name=getIntent().getStringExtra("s1");
                mobileno=getIntent().getStringExtra("s2");
                stremail=getIntent().getStringExtra("s3");
                date=getIntent().getStringExtra("date");
                time=getIntent().getStringExtra("time");
                strreview=getIntent().getStringExtra("review");
                strvisitor=getIntent().getStringExtra("visitor");

                final String username = "appointmentmanagerdelhi@gmail.com";
                final String password = "hisar125005";

                String messageToSend = "------------------Your Appointment with SDM SARITA VIHAR is Booked Successfully please refer to the mail below " +
                        "------------------" +
                        "\n\n" +"Your Appointment Number is "+ra+"\n\n"
                        +"Given Information :: " + "\n\n"+ "Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet SDM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is completed Successfully." +
                        " The Confirmation Email  has an Appointment number inside it , You have to provide your appointment number before meeting SDM SARITA VIHAR." +
                        "\n\n\n" + "Thank You for Using this Appointment Booking Platform.";
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "587");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(stremail));
                    message.setSubject("Appointment Booked Successfully");
                    message.setText(messageToSend);
                    Transport.send(message);
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(UpdateClassSdm1.this);
                    builder1.setMessage("Mail Sent Successfully ... Appointment Booked");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(new Intent(UpdateClassSdm1.this, SDM1.class));
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }



                final String username1 = "appointmentmanagerdelhi@gmail.com";
                final String password1 = "hisar125005";

                String messageToSend1 = "------------------Your Appointment with SDM SARITA VIHAR is Booked Successfully please refer to the mail below " +
                        "------------------" +
                        "\n\n" +"Your Appointment Number is "+ra+"\n\n"
                        +"Given Information :: " + "\n\n"+ "Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet SDM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is completed Successfully." +
                        " The Confirmation Email  has an Appointment number inside it , You have to provide your appointment number before meeting SDM SARITA VIHAR" +
                        "\n\n\n" + "Thank You for Using this Appointment Booking Platform.";
                Properties properties1 = new Properties();
                properties1.put("mail.smtp.host", "smtp.gmail.com");
                properties1.put("mail.smtp.starttls.enable", "true");
                properties1.put("mail.smtp.auth", "true");
                properties1.put("mail.smtp.port", "587");

                Session session1 = Session.getInstance(properties1, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username1, password1);
                    }
                });

                try {
                    Message message1 = new MimeMessage(session1);
                    message1.setFrom(new InternetAddress(username1));
                    message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abhinavhissar1@gmail.com"));
                    message1.setSubject("Appointment Booked Successfully");
                    message1.setText(messageToSend1);
                    Transport.send(message1);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child("SDM");
                Query applesQuery = ref.child("SDM1").orderByChild("mobileno").equalTo(mobileno);

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("TAG", "onCancelled", databaseError.toException());
                    }
                });

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
                progressBar1.setVisibility(View.VISIBLE);
                name=getIntent().getStringExtra("s1");
                mobileno=getIntent().getStringExtra("s2");
                stremail=getIntent().getStringExtra("s3");
                date=getIntent().getStringExtra("date");
                time=getIntent().getStringExtra("time");
                strreview=getIntent().getStringExtra("review");
                strvisitor=getIntent().getStringExtra("visitor");

                final String username = "appointmentmanagerdelhi@gmail.com";
                final String password = "hisar125005";

                String messageToSend ="------------------Your Appointment with SDM SARITA VIHAR is Rejected" +
                        "------------------" +
                        "\n\n" + "PLEASE CHOOSE DIFFERENT DATE TO BOOK APPOINTMENT WITH SDM SARITA VIHAR" +"\n\n"+ "Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet SDM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is Rejected as SDM is having busy schedule." +"\n\n"+
                        "Please Try different date and time Slot"+
                        "\n\n\n" + "Thank You for Using this Appointment Booking Platform.";
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "587");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(stremail));
                    message.setSubject("APPOINTMENT REJECTED DUE TO BUSY SCHEDULE");
                    message.setText(messageToSend);
                    Transport.send(message);
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(UpdateClassSdm1.this);
                    builder1.setMessage("Mail Sent Successfully ... Appointment Rejected");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(new Intent(UpdateClassSdm1.this, SDM3.class));
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }



                final String username1 = "appointmentmanagerdelhi@gmail.com";
                final String password1 = "hisar125005";

                String messageToSend1 = "------------------Your Appointment with SDM SARITA VIHAR is Rejected" +
                        "------------------" +
                        "\n\n" + "PLEASE CHOOSE DIFFERENT DATE TO BOOK APPOINTMENT WITH SDM SARITA VIHAR" +"\n\n"+ "Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet SDM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is Rejected as SDM is having busy schedule." +"\n\n"+
                        "Please Try different date and time Slot"+
                        "\n\n\n" + "Thank You for Using this Appointment Booking Platform.";
                Properties properties1 = new Properties();
                properties1.put("mail.smtp.host", "smtp.gmail.com");
                properties1.put("mail.smtp.starttls.enable", "true");
                properties1.put("mail.smtp.auth", "true");
                properties1.put("mail.smtp.port", "587");

                Session session1 = Session.getInstance(properties1, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username1, password1);
                    }
                });

                try {
                    Message message1 = new MimeMessage(session1);
                    message1.setFrom(new InternetAddress(username1));
                    message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abhinavhissar1@gmail.com"));
                    message1.setSubject("APPOINTMENT REJECTED DUE TO BUSY SCHEDULE");
                    message1.setText(messageToSend1);
                    Transport.send(message1);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child("SDM");
                Query applesQuery = ref.child("SDM1").orderByChild("mobileno").equalTo(mobileno);

                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("TAG", "onCancelled", databaseError.toException());
                    }
                });


            }
        });
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}