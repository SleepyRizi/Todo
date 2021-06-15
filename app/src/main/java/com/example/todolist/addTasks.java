package com.example.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.todolist.adapters.Adapteritem;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.todolist.R.drawable.*;

public class addTasks extends AppCompatActivity /*implements Adapteritem.itemSelected*/ {


   private ImageView ivCancelbtn;
   private EditText et_itemEnter;
   private TextView tvAdddate,tvaddDate,tvTimepicker,tvAdditem;
   EditText nameTask;
   private ImageView ivshowCalender,ivTimepicker,repeate_task,designimageView,ivRemove;;
   boolean repeate = false; //for repeate icon
    Button btnSavetask;
    RadioGroup radioGroup;
   RadioButton radioButton;
   private RecyclerView recyclerView;

   //
   int radiobuttonid;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);
        init();

        ivCancelbtn.setOnClickListener(new View.OnClickListener() {  //toolbar cancel button
            @Override
            public void onClick(View v) {
                Intent backTomain = new Intent(addTasks.this,com.example.todolist.MainActivity.class);
                startActivity(backTomain);
                finish();
            }
        });
        //Show time picker
        settimePicker();
        // show calender
        showCalendar();
       if(Arraystatic.myitems.isEmpty()){
                       designimageView.setVisibility(View.INVISIBLE);
               }


        repeate_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(repeate){
                    repeate_task.setImageResource(repeat);
                    repeate=false;
                }else{
                    repeate_task.setImageResource(repeat_);
                    repeate=true;

                }

            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Adapteritem adapter = new Adapteritem(Arraystatic.myitems,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        adapter.notifyDataSetChanged();
        btnSavetask.setOnClickListener(new View.OnClickListener() { //save button
            @Override
            public void onClick(View v) {
                String tname = nameTask.getText().toString().trim();
                String priority= (String) radioButton.getText();
                String time= tvTimepicker.getText().toString().trim();
                String date= tvaddDate.getText().toString().trim();
                boolean rpt = repeate;
                if(!tname.isEmpty() && !priority.isEmpty() && !time.isEmpty() && !date.isEmpty()){
                        Intent saveTask =getIntent();
                        saveTask.putExtra("tname",tname);
                        saveTask.putExtra("priority",priority);
                        saveTask.putExtra("time",time);
                        saveTask.putExtra("date",date);
                        saveTask.putExtra("repeat",rpt);
                        setResult(RESULT_OK,saveTask);
                        finish();

                }else{
                    Toast.makeText(addTasks.this, "Please complete information", Toast.LENGTH_SHORT).show();
                }

                }
        });


    }

    private void settimePicker() {
        final int[] thours = new int[1];
        final int[] tmints = new int[1];
        ;

        ivTimepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Time picker dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addTasks.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        thours[0] =hourOfDay;
                        tmints[0] = minute;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0, thours[0], tmints[0]);
                        //set to tvText
                        tvTimepicker.setText(DateFormat.format("hh:mm aa",calendar ));
                    }
                },12,0,false
                );
                timePickerDialog.updateTime(thours[0], tmints[0]);
                timePickerDialog.show();
            }
        });

    }

    private void showCalendar() {    //show calendar dialog
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int  month= calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        ivshowCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        addTasks.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month= month+1;
                        String date = day+" / "+month+" / "+year;
                        tvaddDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        }); 

    }

    private void init() {
        ivCancelbtn = (ImageView) findViewById(R.id.ivCancelbtnIcon);
        tvAdddate= (TextView) findViewById(R.id.tvaddDate);
        ivshowCalender= (ImageView) findViewById(R.id.ivshowCalender);
        tvaddDate = (TextView)findViewById(R.id.tvaddDate);
        ivTimepicker = (ImageView) findViewById(R.id.ivTimepicker);
        tvTimepicker = (TextView) findViewById(R.id.tvTimepicker);
        repeate_task= (ImageView) findViewById(R.id.repeate_task);
        radioGroup= (RadioGroup) findViewById(R.id.rbgroup);
        et_itemEnter= (EditText) findViewById(R.id.et_itemEnter);
        recyclerView=(RecyclerView) this.findViewById(R.id.rvitems);
        designimageView= (ImageView) findViewById(R.id.designimageView);
        ivRemove=(ImageView) findViewById(R.id.ivremoveitem);
        tvAdditem=(TextView) findViewById(R.id.tvAdditem);
       nameTask= (EditText) findViewById(R.id.nameTask);
        btnSavetask=(Button) findViewById(R.id.btnSaveTask);




    }

    public void btn_showDialog(View view){  //show item enter dialog
            final AlertDialog.Builder alert = new AlertDialog.Builder(addTasks.this);
            View myview = getLayoutInflater().inflate(R.layout.custom_dialog,null);
            final ImageView additemplus= (ImageView) myview.findViewById(R.id.ivaddItemplus);
            final EditText inputItem= (EditText) myview.findViewById(R.id.et_itemEnter);
            Button btnSaveItem= (Button) myview.findViewById(R.id.btnSaveItem);
            alert.setView(myview);
            final AlertDialog alertDialog =alert.create();
            alertDialog.setCanceledOnTouchOutside(true);
            btnSaveItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   designimageView.setVisibility(View.INVISIBLE);

                   // tvAdditem.setText( inputItem.getText().toString().trim());

                     Arraystatic.myitems.add(new singleItem(inputItem.getText().toString()));
//                    if(Arraystatic.myitems.size()>1){
//                        designimageView.setVisibility(View.INVISIBLE);
//                    }
                    alertDialog.dismiss();
                }

            });

            alertDialog.show();

    }

    public void rbclick(View view) {
        int radiobuttonid = radioGroup.getCheckedRadioButtonId();
        radioButton= (RadioButton) findViewById(radiobuttonid);
        //Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onContentClick(int index) {
//
//        ivRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Arraystatic.myitems.remove(index);
//            }
//        });
//    }
}