package com.chenzheng.event.bean;

import com.chenzheng.event.dao.ScenicSpotsDaoImp;

import java.util.Date;

/**
 * @author cz
 * @date 2021/4/22
 */
public class OrderFormInformation {
    private Integer o_id;
    private Date orderFormDate;
    private Integer u_id;
    private Integer s_id;
    private Integer orderFormPrice;
    public OrderFormInformation(Date orderFormDate, Integer u_id, Integer s_id,Integer orderFormPrice){
        this.orderFormDate = orderFormDate;
        this.u_id = u_id;
        this.s_id = s_id;
        this.orderFormPrice = orderFormPrice;
    }
    public Date getOrderFormDate() {
        return orderFormDate;
    }

    public void setOrderFormDate(Date orderFormDate) {
        this.orderFormDate = orderFormDate;
    }

    public Integer getOrderFormPrice() {
        return orderFormPrice;
    }

    public void setOrderFormPrice(Integer orderFormPrice) {
        this.orderFormPrice = orderFormPrice;
    }


    public Integer getO_id() {
        return o_id;
    }

    public void setO_id(Integer o_id) {
        this.o_id = o_id;
    }


    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getAllOrderForm() {
        return "门票有效日：" +orderFormDate.toString()+"   景点名称："+ ScenicSpotsDaoImp.scenicSpots.get(s_id-1).getsName() +"\n景点ID："+s_id.toString()+"\n景点门票价格："+orderFormPrice.toString();
    }




}
