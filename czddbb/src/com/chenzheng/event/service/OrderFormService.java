package com.chenzheng.event.service;

import com.chenzheng.event.bean.OrderFormInformation;
import com.chenzheng.event.dao.OrderFormDaoImp;

/**
 * @author cz
 * @date 2021/4/22
 */

/**
 *订单的service层
 */
public class OrderFormService {
    OrderFormDaoImp orderFormDaoImp = new OrderFormDaoImp();

    public void setOrderForm(OrderFormInformation orderFormInformation){
        orderFormDaoImp.setOrderForm(orderFormInformation);
    }
    public void getOrderForm(int currentPage) {
        orderFormDaoImp.getOrderForm(currentPage);

    }

}
