package com.example.paapp.ADM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.paapp.DM.DM;
import com.example.paapp.DM.UpdateDM;
import com.example.paapp.ListAdapterClass1;
import com.example.paapp.R;
import com.example.paapp.SDM.SDM1.UpdateClassSdm1;
import com.example.paapp.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ADM extends AppCompatActivity {

    ListView listView;
    Button btnUpdate,btnDelete;

    DatabaseReference reference;

    ArrayList<User> list;
    ListAdapterClass1 adapter;
    ArrayAdapter arrAdp;

    String next;

    String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_m);






        List<User> userList =new ArrayList<>();


        listView= (ListView) findViewById(R.id.listviewtxtadm);


//
//            btnUpdate=findViewById(R.id.btnUpdate);
//            btnDelete=findViewById(R.id.btnDelete);

        reference = FirebaseDatabase.getInstance().getReference("users").child("ADM");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    User p = dataSnapshot1.getValue(User.class);
                    list.add(p);
                }
                adapter = new ListAdapterClass1(ADM.this,list);
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ADM.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                s1=list.get(position).getName();
                s2=list.get(position).getMobileno();
                s3=list.get(position).getEmail();
                String date=list.get(position).getDate();
                String time=list.get(position).getTime();
                String review=list.get(position).getReason();
                String visitor=list.get(position).getVisitor();


                Toast.makeText(ADM.this, list.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(), UpdateAdm.class);
                intent.putExtra("s1",s1);
                intent.putExtra("s2",s2);
                intent.putExtra("s3",s3);
                intent.putExtra("date",date);
                intent.putExtra("time",time);
                intent.putExtra("review",review);
                intent.putExtra("visitor",visitor);
                startActivity(intent);


            }
        });

    }
}