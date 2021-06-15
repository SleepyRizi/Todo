package com.example.todolist;

public class ItemContents {
    String listName,item1,item2,item3,priority,time;
    public ItemContents(){

    }

    public ItemContents(String listName, String item1, String item2, String item3, String priority, String time) {
        this.listName = listName;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.priority = priority;
        this.time = time;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
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

    @Override
    public String toString() {
        return "ItemContents{" +
                "listName='" + listName + '\'' +
                ", item1='" + item1 + '\'' +
                ", item2='" + item2 + '\'' +
                ", item3='" + item3 + '\'' +
                ", priority='" + priority + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
