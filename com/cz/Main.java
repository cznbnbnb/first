package com.cz;

import java.util.Scanner;

import static com.cz.Login.login;
import static com.cz.Register.register;

/**
 * @author cz
 * @date 2021/4/9
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("请输入想要的功能，0注册，1登陆");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a == 0){
            register();
        }else if (a == 1){
            login();
        }

    }
}
