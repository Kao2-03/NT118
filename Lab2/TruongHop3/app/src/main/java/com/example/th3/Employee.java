package com.example.th3;

public class Employee {
    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Phương thức tính lương (giả định tạo phương thức abstract để ghi đè)
    public double tinhLuong() {
        return 0;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name;
    }
}