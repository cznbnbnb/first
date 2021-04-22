package com.chenzheng.event.controller;

import com.chenzheng.event.entity.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author cz
 * @date 2021/4/17
 */
public class OrderFormController implements Initializable {
    @FXML
    private TextArea t4;
    @FXML
    private TextArea t5;
    @FXML
    private TextArea t6;
    @FXML
    private TextArea t7;
    @FXML
    private TextArea t8;
    @FXML
    private Button back;
    @FXML
    private Button next;
    @FXML
    private ToggleButton userSet;
    @FXML
    private ToggleButton orderForm;
    @FXML
    private ToggleButton recharge;
    @FXML
    private TextArea t1;
    @FXML
    private TextArea t2;
    @FXML
    private ToggleButton homepage;
    @FXML
    private TextArea t3;
    Page page1 = new Page();
    /**
     *点了跳到主页
     */
    @FXML
    void homepage(ActionEvent event) {
        Stage stage = new Stage();
        Homepage homepage1 = new Homepage();
        try {
            homepage1.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage sta = (Stage)homepage.getScene().getWindow();
        sta.close();
    }
    /**
     *点了无事发生
     */
    @FXML
    void orderForm(ActionEvent event) {
    }
    /**
     *点了跳到充值界面
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
    /**
     *  点了跳到下一页
     */
    @FXML
    void next(ActionEvent event) {
        /**
        *只有最后一条文字框中还有信息才能到下一页
        */
        if (t8.getText() != null){
            page1.setCurrentPage(page1.getCurrentPage()+1);
            page1.setData2();
            Stage stage = new Stage();
            Search search1 = new Search();
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            t5.setText(null);
            t6.setText(null);
            t7.setText(null);
            t8.setText(null);
            for (int i = 0; i < page1.getData2().size(); i++) {
                switch (i+1){
                    case 1 : t1.setText(page1.getData2().get(0).getAllOrderForm());break;
                    case 2 : t2.setText(page1.getData2().get(1).getAllOrderForm());break;
                    case 3 : t3.setText(page1.getData2().get(2).getAllOrderForm());break;
                    case 4 : t4.setText(page1.getData2().get(3).getAllOrderForm());break;
                    case 5 : t5.setText(page1.getData2().get(4).getAllOrderForm());break;
                    case 6 : t6.setText(page1.getData2().get(5).getAllOrderForm());break;
                    case 7 : t7.setText(page1.getData2().get(6).getAllOrderForm());break;
                    case 8 : t8.setText(page1.getData2().get(7).getAllOrderForm());break;
                    default:
                        System.out.println("false");
                }
            }
            t1.setWrapText(true);
            t2.setWrapText(true);
            t3.setWrapText(true);
            t4.setWrapText(true);
            t5.setWrapText(true);
            t6.setWrapText(true);
            t7.setWrapText(true);
            t8.setWrapText(true);

            t1.setEditable(false);
            t2.setEditable(false);
            t3.setEditable(false);
            t4.setEditable(false);
            t5.setEditable(false);
            t6.setEditable(false);
            t7.setEditable(false);
            t8.setEditable(false);
        }
    }
    /**
     *点了跳到上一页
     */
    @FXML
    void back(ActionEvent event) {
        /**
         *必须大于一页才能回退
         */
        if (page1.getCurrentPage() > 1){
            page1.setCurrentPage(page1.getCurrentPage()-1);
            page1.setData2();
            Stage stage = new Stage();
            Search search1 = new Search();
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            t5.setText(null);
            t6.setText(null);
            t7.setText(null);
            t8.setText(null);
            for (int i = 0; i < page1.getData2().size(); i++) {
                switch (i+1){
                    case 1 : t1.setText(page1.getData2().get(0).getAllOrderForm());break;
                    case 2 : t2.setText(page1.getData2().get(1).getAllOrderForm());break;
                    case 3 : t3.setText(page1.getData2().get(2).getAllOrderForm());break;
                    case 4 : t4.setText(page1.getData2().get(3).getAllOrderForm());break;
                    case 5 : t5.setText(page1.getData2().get(4).getAllOrderForm());break;
                    case 6 : t6.setText(page1.getData2().get(5).getAllOrderForm());break;
                    case 7 : t7.setText(page1.getData2().get(6).getAllOrderForm());break;
                    case 8 : t8.setText(page1.getData2().get(7).getAllOrderForm());break;
                    default:
                        System.out.println("false");
                }
            }

            t1.setWrapText(true);
            t2.setWrapText(true);
            t3.setWrapText(true);
            t4.setWrapText(true);
            t5.setWrapText(true);
            t6.setWrapText(true);
            t7.setWrapText(true);
            t8.setWrapText(true);

            t1.setEditable(false);
            t2.setEditable(false);
            t3.setEditable(false);
            t4.setEditable(false);
            t5.setEditable(false);
            t6.setEditable(false);
            t7.setEditable(false);
            t8.setEditable(false);
        }
    }
    /**
     *初始化订单页面，实现了分页功能，通过蜜汁循环和switch语句规避了报错，将订单表中的数据放了上来
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /**
         *将搜索出来的东西放入page的属性中
         */
        page1.setSearchText(HomepageController.searchText1);
        page1.setCurrentPage(1);
        page1.setData2();
        /**
         *能放的都放了，这是我能想到的唯一能避免报错的方法，尽力了
         */
        for (int i = 0; i < page1.getData2().size(); i++) {
            switch (i+1){
                case 1 : t1.setText(page1.getData2().get(0).getAllOrderForm());break;
                case 2 : t2.setText(page1.getData2().get(1).getAllOrderForm());break;
                case 3 : t3.setText(page1.getData2().get(2).getAllOrderForm());break;
                case 4 : t4.setText(page1.getData2().get(3).getAllOrderForm());break;
                case 5 : t5.setText(page1.getData2().get(4).getAllOrderForm());break;
                case 6 : t6.setText(page1.getData2().get(5).getAllOrderForm());break;
                case 7 : t7.setText(page1.getData2().get(6).getAllOrderForm());break;
                case 8 : t8.setText(page1.getData2().get(7).getAllOrderForm());break;
                default:
                    System.out.println("orderFalse");
            }
        }
        t1.setWrapText(true);
        t2.setWrapText(true);
        t3.setWrapText(true);
        t4.setWrapText(true);
        t5.setWrapText(true);
        t6.setWrapText(true);
        t7.setWrapText(true);
        t8.setWrapText(true);

        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t8.setEditable(false);
    }


}
