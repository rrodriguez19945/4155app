package com.example.navigationmenu;

import com.example.navigationmenu.ExampleEventItems;

import java.util.ArrayList;

public class Singleton {

    private ArrayList<ExampleEventItems> arrayList;

    private static Singleton instance;

    private Singleton(){
        arrayList = new ArrayList<>();
    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public ArrayList<ExampleEventItems> getArrayList() {
        return arrayList;
    }
}