package com.chenzheng.event.bean;

import javax.xml.soap.Node;
import java.sql.Date;

/**
 * @author cz
 * @date 2021/4/12
 */
public class ScenicSpots {
    private Integer sid;
    private String sName ;
    private Integer ticketPrice;
    private String information;
    private Integer ticketNumber;
    private Date date;


    public ScenicSpots(int sid, String sName , int ticketPrice, String information, int ticketNumber, Date date){
        this.sid = sid;
        this.sName = sName ;
        this.ticketPrice = ticketPrice;
        this.information = information;
        this.ticketNumber = ticketNumber;
        this.date = date;

    }
    public int getSid() { return sid; }
    public void setSid(Integer sid) { this.sid = sid; }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getTicketPrice() { return ticketPrice; }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) { this.date = date; }


    public String getAll() {
        return "景点ID："+sid.toString()+"  景点名称："+sName+"\n  "+information+"\n剩余票数："+ticketNumber.toString();
    }


}
