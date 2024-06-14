package com.example.recyclerview_th4;

public class Employee {
    public String id;
    public String name;
    public boolean isManager;
    public float TinhLuong(){
        return 0;
    };
    public Employee(String name,String id,boolean ismanger){
        this.name = name;
        this.id = id;
        this.isManager = ismanger;
    }
}