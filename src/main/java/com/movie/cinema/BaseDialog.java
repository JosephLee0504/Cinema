/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import javax.swing.JOptionPane;

/**
 *
 * @author zhch
 */
public class BaseDialog {
     public static void showErr(String msg){
        JOptionPane.showMessageDialog(null, msg, "错误",
                            JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfo(String msg){
        JOptionPane.showMessageDialog(null, msg, "信息",
                            JOptionPane.INFORMATION_MESSAGE);
    }
}
