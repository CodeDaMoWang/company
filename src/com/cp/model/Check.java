package com.cp.model;

import java.sql.Date;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class Check {
    private Integer id;//流水号
    private String staffNumber;//工号
    private String checkType;//状态
    private Date checkDate;//时间

    public Check( String staffNumber, String checkType, Date checkDate) {

        this.staffNumber = staffNumber;
        this.checkType = checkType;
        this.checkDate = checkDate;
    }

    public Check(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", staffNumber='" + staffNumber + '\'' +
                ", checkType='" + checkType + '\'' +
                ", checkDate=" + checkDate +
                '}';
    }
}
