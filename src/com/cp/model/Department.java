package com.cp.model;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class Department {
    private String deptNumber; //部门编号
    private String deptName; //部门名称

    public Department() {
    }

    public Department(String deptNumber, String deptName) {
        this.deptNumber = deptNumber;
        this.deptName = deptName;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptNumber='" + deptNumber + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}