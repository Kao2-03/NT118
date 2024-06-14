package com.example.th3;

public class EmployeeFullTime extends Employee {
    @Override
    public double tinhLuong() {
        // Cách tính lương cho nhân viên chính thức
        // Giả sử lương cứng là 1000$
        return 1000;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Full-time\nSalary: " + tinhLuong();
    }
}