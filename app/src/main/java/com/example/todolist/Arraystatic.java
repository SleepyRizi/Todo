package com.example.todolist;

import android.app.Application;

import com.example.todolist.adapters.ListTask;

import java.util.ArrayList;

public class Arraystatic extends Application {
    public static ArrayList<singleItem> myitems;
    public static ArrayList<ListTask> mytask;
    @Override
    public void onCreate() {
        super.onCreate();
        myitems=new ArrayList<>();
        mytask= new ArrayList<>();

    }
    public static void addtask(ListTask a){
        mytask.add(a);
    }
    public static void removeTask(int index){
        mytask.remove(index);
    }

    public static void addItem(singleItem a){
        myitems.add(a);
    }
    public static void removeitem(int index){
        myitems.remove(index);
    }
}
