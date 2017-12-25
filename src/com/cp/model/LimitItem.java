package com.cp.model;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class LimitItem {
    private String itemID;  //权限项ID
    private String groupID;  //权限组ID
    private String itemName;  //权限项名称

    public LimitItem() {
    }

    public LimitItem(String itemID, String groupID, String itemName) {
        this.itemID = itemID;
        this.groupID = groupID;
        this.itemName = itemName;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "LimitItem{" +
                "itemID='" + itemID + '\'' +
                ", groupID='" + groupID + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}