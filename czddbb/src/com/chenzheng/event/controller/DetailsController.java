package com.chenzheng.event.controller;

import com.chenzheng.event.bean.OrderFormInformation;
import com.chenzheng.event.dao.ScenicSpotsDaoImp;
import com.chenzheng.event.dao.UserDao;
import com.chenzheng.event.dao.UserDaoImp;
import com.chenzheng.event.service.OrderFormService;
import com.chenzheng.event.service.ScenicSpotsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/19
 */
public class DetailsController implements Initializable {
    @FXML
    private Label label1;
    @FXML
    private Button comfirm;
    @FXML
    private Button go;
    @FXML
    private TextArea text;
    /**
     *购买确认按钮，当获得点击按钮的事件执行
     */
    @FXML
    void comfirm(ActionEvent event) {
        /**
         *获取dao层中user的虚拟货币信息，减掉它该减掉的趣币并保存
         */
        UserDaoImp.user2.setIdealMoney(UserDaoImp.user2.getIdealMoney() - HomepageController.getSss());
        OrderFormService orderFormService = new OrderFormService();
        /**
         *调用景点在dao层的剩余票数信息，并减少一张票后保存；
         */
        ScenicSpotsDaoImp.scenicSpots.get(HomepageController.getAaa()-1).setTicketNumber(ScenicSpotsDaoImp.scenicSpots.get(HomepageController.getAaa()-1).getTicketNumber() - 1);
        /**
         *调用景点在dao层的更新方法，将票数改变的景点连接数据库后更新；
         */
        ScenicSpotsDaoImp.updateScenicSpots(ScenicSpotsDaoImp.scenicSpots);
        /**
         *调用user在dao层的更新方法，将虚拟币改变的user连接数据库后更新；
         */
        UserDaoImp.updateUser(UserDaoImp.user2);
        /**
         *将订单信息封装成一个订单信息对象后放入订单信息链表中，并马上更新到数据库中的历史订单表
         */
        OrderFormInformation ord = new OrderFormInformation(ScenicSpotsDaoImp.scenicSpots.get(HomepageController.getAaa()-1).getDate(),UserDaoImp.user2.getId(),ScenicSpotsDaoImp.scenicSpots.get(HomepageController.getAaa()-1).getSid(),ScenicSpotsDaoImp.scenicSpots.get(HomepageController.getAaa()-1).getTicketPrice());
        orderFormService.setOrderForm(ord);
        /**
         *打开提示界面（没啥用，但是让你知道花了钱）
         */
        Stage stage = new Stage();
        Stage3 commonStage = new Stage3();
        try {
            commonStage.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *没时间写
     */
    @FXML
    void go(ActionEvent event) {
    }
    /**
     *进行详情页面的初始化，将景点信息放入页面中
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.setText(HomepageController.getTtt());
        text.setWrapText(true);
        text.setEditable(false);
        label1.setText(HomepageController.getSss().toString());
    }

}
