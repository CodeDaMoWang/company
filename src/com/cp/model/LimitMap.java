package com.cp.model;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class LimitMap {
    private Integer id;  //id
    private String staffNumber;  //员工工号
    private String itemID;  //权限项id

    public LimitMap() {
    }

    public LimitMap( String staffNumber, String itemID) {

        this.staffNumber = staffNumber;
        this.itemID = itemID;
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

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String toString() {
        return "LimitMap{" +
                "id=" + id +
                ", staffNumber='" + staffNumber + '\'' +
                ", itemID='" + itemID + '\'' +
                '}';
    }
}