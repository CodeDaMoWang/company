package com.cp.model;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class Staff {

    private String staffNumber; //工号
    private String staffName; //姓名
    private String staffAge; //年龄
    private String staffSex; //性别
    private String deptNumber; //部门编号
    private String staffPost;  //职位
    private String staffPlace; //籍贯
    private String staffMarriage;  //婚姻状况
    private String staffPhone;  //联系方式
    private String staffMailbox;  //邮箱
    private byte[] staffPicture;  //照片
    private Date staffEntrytime;  //入职时间

    public Staff() {
    }



    public Staff(String staffNumber, String staffName, String staffAge, String staffSex, String deptNumber,
                 String staffPost, String staffPlace, String staffMarriage, String staffPhone, String staffMailbox,
                 byte[] staffPicture, Date staffEntrytime) {
        this.staffNumber = staffNumber;
        this.staffName = staffName;
        this.staffAge = staffAge;
        this.staffSex = staffSex;
        this.deptNumber = deptNumber;
        this.staffPost = staffPost;
        this.staffPlace = staffPlace;
        this.staffMarriage = staffMarriage;
        this.staffPhone = staffPhone;
        this.staffMailbox = staffMailbox;
        this.staffPicture = staffPicture;
        this.staffEntrytime = staffEntrytime;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(String staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getStaffPost() {
        return staffPost;
    }

    public void setStaffPost(String staffPost) {
        this.staffPost = staffPost;
    }

    public String getStaffPlace() {
        return staffPlace;
    }

    public void setStaffPlace(String staffPlace) {
        this.staffPlace = staffPlace;
    }

    public String getStaffMarriage() {
        return staffMarriage;
    }

    public void setStaffMarriage(String staffMarriage) {
        this.staffMarriage = staffMarriage;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffMailbox() {
        return staffMailbox;
    }

    public void setStaffMailbox(String staffMailbox) {
        this.staffMailbox = staffMailbox;
    }

    public byte[] getStaffPicture() {
        return staffPicture;
    }

    public void setStaffPicture(byte[] staffPicture) {
        this.staffPicture = staffPicture;
    }

    public Date getStaffEntrytime() {
        return staffEntrytime;
    }

    public void setStaffEntrytime(Date staffEntrytime) {
        this.staffEntrytime = staffEntrytime;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNumber='" + staffNumber + '\'' +
                ", staffName='" + staffName + '\'' +
                ", staffAge='" + staffAge + '\'' +
                ", staffSex='" + staffSex + '\'' +
                ", deptNumber='" + deptNumber + '\'' +
                ", staffPost='" + staffPost + '\'' +
                ", staffPlace='" + staffPlace + '\'' +
                ", staffMarriage='" + staffMarriage + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffMailbox='" + staffMailbox + '\'' +
                ", staffPicture=" + Arrays.toString(staffPicture) +
                ", staffEntrytime=" + staffEntrytime +
                '}';
    }
}