package com.cp.model;

import java.sql.Date;

/**
 * Created by 熊康 on 2017/12/19.
 */
public class Salary {
    private Integer id;//流水号
    private String staffNumber;//员工工号
    private Integer basicSalary;//基础工资
    private Integer bfSalary;//补发工资
    private Integer deductSalary;//应扣工资
    private Integer personalTax;//税收
    private Integer socialSec;//社保
    private Integer reservedFunds;//公积金
    private Integer finalSalary;//实发工资
    private Date time;//发放时间

    public Salary( String staffNumber, Integer basicSalary, Integer bfSalary,
                  Integer deductSalary, Integer personalTax, Integer socialSec,
                  Integer reservedFunds, Integer finalSalary, Date time) {

        this.staffNumber = staffNumber;
        this.basicSalary = basicSalary;
        this.bfSalary = bfSalary;
        this.deductSalary = deductSalary;
        this.personalTax = personalTax;
        this.socialSec = socialSec;
        this.reservedFunds = reservedFunds;
        this.finalSalary = finalSalary;
        this.time = time;
    }
    public Salary(){

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

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getBfSalary() {
        return bfSalary;
    }

    public void setBfSalary(Integer bfSalary) {
        this.bfSalary = bfSalary;
    }

    public Integer getDeductSalary() {
        return deductSalary;
    }

    public void setDeductSalary(Integer deductSalary) {
        this.deductSalary = deductSalary;
    }

    public Integer getPersonalTax() {
        return personalTax;
    }

    public void setPersonalTax(Integer personalTax) {
        this.personalTax = personalTax;
    }

    public Integer getSocialSec() {
        return socialSec;
    }

    public void setSocialSec(Integer socialSec) {
        this.socialSec = socialSec;
    }

    public Integer getReservedFunds() {
        return reservedFunds;
    }

    public void setReservedFunds(Integer reservedFunds) {
        this.reservedFunds = reservedFunds;
    }

    public Integer getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(Integer finalSalary) {
        this.finalSalary = finalSalary;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", staffNumber='" + staffNumber + '\'' +
                ", basicSalary=" + basicSalary +
                ", bfSalary=" + bfSalary +
                ", deductSalary=" + deductSalary +
                ", personalTax=" + personalTax +
                ", socialSec=" + socialSec +
                ", reservedFunds=" + reservedFunds +
                ", finalSalary=" + finalSalary +
                ", time=" + time +
                '}';
    }
}
