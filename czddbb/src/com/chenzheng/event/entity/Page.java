package com.chenzheng.event.entity;

import com.chenzheng.event.bean.OrderFormInformation;
import com.chenzheng.event.bean.ScenicSpots;
import com.chenzheng.event.dao.OrderFormDaoImp;
import com.chenzheng.event.dao.ScenicSpotsDaoImp;
import com.chenzheng.event.service.OrderFormService;
import com.chenzheng.event.service.ScenicSpotsService;
import sun.java2d.pipe.SpanClipRenderer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cz
 * @date 2021/4/21
 */

/**
 *实现分页功能
 */
public class Page {
    private final static int DATA_SIZE = 5;
    private int currentPage = 0;
    private int pageSize;
    private LinkedList<ScenicSpots> data = new LinkedList<>();
    private LinkedList<OrderFormInformation> data2 = new LinkedList<>();

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    private String searchText;

    public static int getDataSize() {
        return DATA_SIZE;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ScenicSpots> getData() {
        return this.data;
    }
    public List<OrderFormInformation> getData2() {
        return this.data2;
    }

    public void setData() {
        ScenicSpotsService scenicSpotsService = new ScenicSpotsService();
        scenicSpotsService.search(this.searchText,this.currentPage);
        this.data = ScenicSpotsDaoImp.scenicSpots2;
    }

    public void setData2() {
        OrderFormService orderFormService = new OrderFormService();
        orderFormService.getOrderForm(this.currentPage);
        this.data2 = OrderFormDaoImp.ord;
    }
}
