package com.example.th3;

public class EmployeePartTime extends Employee {
    @Override
    public double tinhLuong() {
        // Cách tính lương cho nhân viên thời vụ
        // Giả sử lương tính theo số giờ làm việc và mức lương giờ
        // Ví dụ: 20$ mỗi giờ
        double luongGio = 20;
        // Giả sử nhân viên làm 25 giờ
        double soGioLam = 25;
        return luongGio * soGioLam;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Part-time\nSalary: " + tinhLuong();
    }
}