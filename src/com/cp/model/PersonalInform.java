package com.cp.model;

import java.sql.Date;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class PersonalInform {
    private Integer id;  //主键
    private String receiverNumber;  //接收方工号
    private String senderNumber;  //发送方工号
    private String informContent;  //通知内容
    private Date sendDate;  //通知日期
    private String isRead;  //是否已读

    public PersonalInform() {
    }

    public PersonalInform(String receiverNumber,
                          String senderNumber, String informContent,
                          Date sendDate) {

        this.receiverNumber = receiverNumber;
        this.senderNumber = senderNumber;
        this.informContent = informContent;
        this.sendDate = sendDate;
    }

    public PersonalInform(String receiverNumber, String senderNumber, String informContent, Date sendDate, String isRead) {
        this.receiverNumber = receiverNumber;
        this.senderNumber = senderNumber;
        this.informContent = informContent;
        this.sendDate = sendDate;
        this.isRead = isRead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
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

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "PersonalInformDAO{" +
                "id=" + id +
                ", receiverNumber='" + receiverNumber + '\'' +
                ", senderNumber='" + senderNumber + '\'' +
                ", informContent='" + informContent + '\'' +
                ", sendDate=" + sendDate +
                ", isRead='" + isRead + '\'' +
                '}';
    }
}