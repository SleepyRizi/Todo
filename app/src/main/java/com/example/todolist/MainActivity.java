package com.example.todolist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todolist.adapters.Adapteritem;
import com.example.todolist.adapters.ListTask;
import com.example.todolist.adapters.TaskAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addTodo;
    private TextView tvcurrentDate;
    final int ADD_Activity = 1;
    private RecyclerView recyclerView;
    TaskAdapter adapter;
    ImageView imageempty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setDate();


        addTodo.setOnClickListener(new View.OnClickListener() {  //floating button
            @Override
            public void onClick(View v) {
                Intent intet= new Intent(MainActivity.this, com.example.todolist.addTasks.class);
                startActivityForResult(intet, ADD_Activity);


            }
        });
        if(!Arraystatic.mytask.isEmpty()){
            imageempty.setVisibility(View.INVISIBLE);
        }

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        TaskAdapter adapter = new TaskAdapter(Arraystatic.mytask,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_Activity){
            if(resultCode==RESULT_OK){
                boolean repeat;
                String time,date,name,item1,item2,item3,priority;
                name= data.getStringExtra("name");
                priority= data.getStringExtra("priority");
                time = data.getStringExtra("time");
                date =data.getStringExtra("date");
                repeat= data.getBooleanExtra("repeat",false);
                Arraystatic.mytask.add(new ListTask(repeat,priority,time,date,name,"mobile","laptop","phone"));

            }
        }

    }

    private void setDate() {
        Calendar calendar = Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance().format(calendar.getTime()); //getting date
        tvcurrentDate.setText(currentDate.toString().trim());  //setting date to textView
    }

    private void init() {
        addTodo=(FloatingActionButton) findViewById(R.id.fab);
        tvcurrentDate= (TextView) findViewById(R.id.tvCurrentDate);
        recyclerView=(RecyclerView) findViewById(R.id.rvTasks);
        imageempty = (ImageView) findViewById(R.id.img_empty);
    }
}