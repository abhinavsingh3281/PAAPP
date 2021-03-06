package com.example.paapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class ListAdapterClass1 extends ArrayAdapter {

    private Activity mContent;
    List<User> studentList;

    public ListAdapterClass1(Activity mContent, List<User>studentList)
    {
        super(mContent, R.layout.list_item,studentList);
        this.mContent=mContent;
        this.studentList=studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=mContent.getLayoutInflater();
        View listItemView=layoutInflater.inflate(R.layout.list_item,null,true);

        TextView tvName=listItemView.findViewById(R.id.tvname);
        TextView tvEmail=listItemView.findViewById(R.id.tvEmail);
        TextView tvMobile=listItemView.findViewById(R.id.tvmobileno);
        TextView tvreason=listItemView.findViewById(R.id.tvreason);
        TextView tvmembers=listItemView.findViewById(R.id.tvmembers);
        TextView tvdate=listItemView.findViewById(R.id.tvdate);
        TextView tvtime=listItemView.findViewById(R.id.tvtime);




        User student=studentList.get(position);

        tvName.setText(student.getName());
        tvEmail.setText(student.getEmail());
        tvMobile.setText(student.getMobileno());
        tvreason.setText(student.getReason());
        tvmembers.setText(student.getVisitor());
        tvdate.setText(student.getDate());
        tvtime.setText(student.getTime());
        return listItemView;
    }
}
