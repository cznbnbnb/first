package com.chenzheng.event.controller;


import com.chenzheng.event.dao.ScenicSpotsDaoImp;
import com.chenzheng.event.dao.UserDao;
import com.chenzheng.event.dao.UserDaoImp;
import com.chenzheng.event.service.ScenicSpotsService;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/13
 */
public class HomepageController implements Initializable {
    public static String searchText1 = null;
    @FXML
    private TextArea t4;
    @FXML
    private TextArea t5;
    @FXML
    private TextArea t6;
    @FXML
    private TextArea t7;
    @FXML
    private Button idsearch;
    @FXML
    private TextField idsearchText;
    @FXML
    private ToggleButton userSet;

    @FXML
    private ToggleButton orderForm;
    @FXML
    private TextField searchText;
    @FXML
    private Button search;
    @FXML
    private ToggleButton recharge;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextArea t1;
    @FXML
    private TextArea t2;
    @FXML
    private TextArea t3;

    @FXML
    public int getIdsearchText() {return Integer.parseInt(idsearchText.getText()); }
    @FXML
    public String getSearchText(){return searchText.getText();}
    public static String ttt = null;
    public static String getTtt(){return ttt;}
    public static Integer sss = null;
    public static Integer getSss(){return sss;}
    public static Integer aaa = null;
    public static Integer getAaa(){return aaa;}
    /**
     *点了跳到订单页面
     */
    @FXML
    void orderForm(ActionEvent event) {
        Stage stage = new Stage();
        OrderForm orderForm1 = new OrderForm();
        try {
            orderForm1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)orderForm.getScene().getWindow();
        sta.close();
    }
    /**
     *点了跳到充值页面
     */
    @FXML
    void recharge(ActionEvent event) {
        Stage stage = new Stage();
        Recharge recharge1 = new Recharge();
        try {
            recharge1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)recharge.getScene().getWindow();
        sta.close();
    }
    /**
     *点了跳到设置界面
     */
    @FXML
    void userSet(ActionEvent event) {
        Stage stage = new Stage();
        UserSet userSet1 = new UserSet();
        try {
            userSet1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)userSet.getScene().getWindow();
        sta.close();
    }
    @FXML
    void search(ActionEvent event) {
        /**
         * 将储存的信息放在静态属性中，方便接下来调用
         */
        searchText1 = getSearchText();
        /**
         *打开搜索结果页面
         */
        Stage stage = new Stage();
        Search search1 = new Search();
        try {
            search1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void idsearch(ActionEvent event) {
        /**
         *将搜索到的东西放在静态属性中存一下，现在已经有了更好的方法，但是来不及改了
         * 这里还调用了放在景点的dao层中的静态信息
         */
        aaa = ScenicSpotsDaoImp.scenicSpots.get(getIdsearchText()-1).getSid();
        ttt = ScenicSpotsDaoImp.scenicSpots.get(getIdsearchText()-1).getAll();
        sss = ScenicSpotsDaoImp.scenicSpots.get(getIdsearchText()-1).getTicketPrice();
        /**
         *打开详情页面
         */
        Stage stage = new Stage();
        Details details1 = new Details();
        try {
            details1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /**
     *这里是主页的控制器，初始化主页中的textarea内容
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         *将用户名放在这个标签中，让它看起来像你的号
         */
        label2.setText(UserDaoImp.user2.getUsername());
        /**
         *将一些景点的信息放在主页撑场面，看起来没有那么空荡荡
         */
        t1.setText(ScenicSpotsDaoImp.scenicSpots.get(0).getAll());
        t2.setText(ScenicSpotsDaoImp.scenicSpots.get(1).getAll());
        t3.setText(ScenicSpotsDaoImp.scenicSpots.get(2).getAll());
        t4.setText(ScenicSpotsDaoImp.scenicSpots.get(3).getAll());
        t5.setText(ScenicSpotsDaoImp.scenicSpots.get(4).getAll());
        t6.setText(ScenicSpotsDaoImp.scenicSpots.get(5).getAll());
        t7.setText(ScenicSpotsDaoImp.scenicSpots.get(6).getAll());
        /**
         *设置不可更改
         */
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        /**
         *设置触底换行
         */
        t1.setWrapText(true);
        t2.setWrapText(true);
        t3.setWrapText(true);
        t4.setWrapText(true);
        t5.setWrapText(true);
        t6.setWrapText(true);
        t7.setWrapText(true);

    }



}
