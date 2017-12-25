package com.cp.model;

/**
 * Created by 熊康 on 2017/12/19.
 */
public class LimitGroup {
    private String groupID;//权限组ID
    private String groupName;//权限组名称

    public LimitGroup(String groupID, String groupName) {
        this.groupID = groupID;
        this.groupName = groupName;
    }
    public LimitGroup(){

    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "LimitGroup{" +
                "groupID='" + groupID + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
