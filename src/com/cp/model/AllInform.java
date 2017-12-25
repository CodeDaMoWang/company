package com.cp.model;

import java.sql.Date;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class AllInform {
    private Integer id;//流水哈
    private String senderNumber;//发送者工号
    private String informTitle;//主题
    private String informContent;//内容
    private Date sendDate;//发送时间

    public AllInform( String senderNumber, String informTitle,
                     String informContent, Date sendDate) {

        this.senderNumber = senderNumber;
        this.informTitle = informTitle;
        this.informContent = informContent;
        this.sendDate = sendDate;
    }

    public AllInform(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getInformTitle() {
        return informTitle;
    }

    public void setInformTitle(String informTitle) {
        this.informTitle = informTitle;
    }

    public String getInformContent() {
        return informContent;
    }

    public void setInformContent(String informContent) {
        this.informContent = informContent;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "AllInformDAO{" +
                "id=" + id +
                ", senderNumber='" + senderNumber + '\'' +
                ", informTitle='" + informTitle + '\'' +
                ", informContent='" + informContent + '\'' +
                ", sendDate=" + sendDate +
                '}';
    }
}
