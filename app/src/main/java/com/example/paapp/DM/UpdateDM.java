package com.example.paapp.DM;

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
import com.example.paapp.SDM.SDM1.SDM1;
import com.example.paapp.SDM.SDM1.UpdateClassSdm1;
import com.example.paapp.SDM.SDM3.SDM3;
import com.example.paapp.SDM.SDM3.UpdateSdm3;
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

public class UpdateDM extends AppCompatActivity {

    DatabaseReference mdatabase;
    Button b1,b2;
    EditText editText;
    String name, mobileno, date, time, stremail, strreview, strvisitor;
    ProgressBar progressBar,progressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_d_m);



        b1=findViewById(R.id.btnApprovedm);

        Random random=new Random();

        int ra=random.nextInt(1000);

        b2=findViewById(R.id.btnRejectdm);

        progressBar=findViewById(R.id.progressbardm1);
        progressBar1=findViewById(R.id.progressbardm2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b1.setVisibility(View.INVISIBLE);
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

                String messageToSend = "------------------Your Appointment with DM is Booked Successfully please refer to the mail below " +
                        "------------------" +
                        "\n\n" +
                         "Your Appointment Number is "+ra+"\n\n"
                        +"Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet DM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is completed Successfully." +
                        " The Confirmation Email  has an Appointment number inside it , You have to provide your appointment number before meeting DM." +
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
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(UpdateDM.this);
                    builder1.setMessage("Mail Sent Successfully .... Appointment Booked");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(new Intent(UpdateDM.this, DM.class));
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }



                final String username11 = "appointmentmanagerdelhi@gmail.com";
                final String password11 = "hisar125005";

                String messageToSend11 = "------------------Your Appointment with DM is Booked Successfully please refer to the mail below " +
                        "------------------" +
                        "\n\n" + "\n\n" +
                        "Your Appointment Number is "+ra+"\n\n"+"Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet DM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is completed Successfully." +
                        " The Confirmation Email  has an Appointment number inside it , You have to provide your appointment number before meeting DM." +
                        "\n\n\n" + "Thank You for Using this Appointment Booking Platform.";
                Properties properties11 = new Properties();
                properties11.put("mail.smtp.host", "smtp.gmail.com");
                properties11.put("mail.smtp.starttls.enable", "true");
                properties11.put("mail.smtp.auth", "true");
                properties11.put("mail.smtp.port", "587");

                Session session11 = Session.getInstance(properties11, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username11, password11);
                    }
                });

                try {
                    Message message11 = new MimeMessage(session11);
                    message11.setFrom(new InternetAddress(username11));
                    message11.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abhinavhissar1@gmail.com"));
                    message11.setSubject("Appointment Booked Successfully");
                    message11.setText(messageToSend11);
                    Transport.send(message11);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
                Query applesQuery = ref.child("DM").orderByChild("mobileno").equalTo(mobileno);

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

                String messageToSend ="------------------Your Appointment with DM is Rejected" +
                        "------------------" +
                        "\n\n" + "PLEASE CHOOSE DIFFERENT DATE TO BOOK APPOINTMENT WITH DM" +"\n\n"+ "Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet DM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is Rejected as DM is having busy schedule." +"\n\n"+
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
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(UpdateDM.this);
                    builder1.setMessage("Mail Sent Successfully ... Appointment Rejected");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    startActivity(new Intent(UpdateDM.this, DM.class));
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }



                final String username1 = "appointmentmanagerdelhi@gmail.com";
                final String password1 = "hisar125005";

                String messageToSend1 = "------------------Your Appointment with DM is Rejected" +
                        "------------------" +
                        "\n\n" + "PLEASE CHOOSE DIFFERENT DATE TO BOOK APPOINTMENT WITH SDM SARITA VIHAR" +"\n\n"+ "Given Information :: " + "\n\n" + "Name : " + name + "\n\n" + "Mobile No. : " + mobileno + "\n\n" +
                        "Date of Appointment : " + date + "\n\n" + "Time of Appointment : "
                        + time + "\n\n" + "Email : " + stremail + "\n\n" + "Reason To Meet DM : " + strreview + "\n\n" + "No. of Visitors : " + strvisitor
                        + "\n\n" + "Note :  Your Appointment Request is Rejected as DM is having busy schedule." +"\n\n"+
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

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
                Query applesQuery = ref.child("DM").orderByChild("mobileno").equalTo(mobileno);

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