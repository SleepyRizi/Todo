package com.example.todolist.adapters;

public class ListTask {
    boolean repeat;
    String time,date,name,item1,item2,item3,priority;
    ListTask(){

    }

    public ListTask(boolean repeat, String priority, String time, String date, String name, String item1, String item2, String item3) {
        this.repeat = repeat;
        this.priority = priority;
        this.time = time;
        this.date = date;
        this.name = name;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return "ListTask{" +
                "repeat=" + repeat +
                ", priority=" + priority +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", item1='" + item1 + '\'' +
                ", item2='" + item2 + '\'' +
                ", item3='" + item3 + '\'' +
                '}';
    }
}
