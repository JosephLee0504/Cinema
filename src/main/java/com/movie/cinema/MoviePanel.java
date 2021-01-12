/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import com.movie.cinema.model.Movie;
import javax.swing.ImageIcon;

/**
 *
 * @author zhch
 */
public class MoviePanel extends javax.swing.JPanel {

    /**
     * Creates new form MoviePanel
     */
    public MoviePanel() {
        initComponents();
    }
    
    /**
     * 初始化电影介绍界面
     * @param movie 
     */
    public MoviePanel(Movie movie) {
        initComponents();
        ImageIcon img = new ImageIcon("imgs/" + movie.getImage());
        imageL.setIcon(img);  // 用 JLabel 来显示图片
        descL.setText(movie.getMdesc());
        publishL.setText(movie.getPublishtime());
        timeL.setText(movie.getMtime() + " minutes");
        titleL.setText(movie.getName());
        typeL.setText(movie.getMtype());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageL = new javax.swing.JLabel();
        titleL = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        typeL = new javax.swing.JLabel();
        publishL = new javax.swing.JLabel();
        descL = new javax.swing.JLabel();

        titleL.setText("title");

        timeL.setText("time");

        typeL.setText("type");

        publishL.setText("publish");

        descL.setText("Desc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descL, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageL, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titleL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeL, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(publishL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(titleL)
                        .addGap(18, 18, 18)
                        .addComponent(timeL)
                        .addGap(18, 18, 18)
                        .addComponent(typeL)
                        .addGap(18, 18, 18)
                        .addComponent(publishL))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageL, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(descL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descL;
    private javax.swing.JLabel imageL;
    private javax.swing.JLabel publishL;
    private javax.swing.JLabel timeL;
    private javax.swing.JLabel titleL;
    private javax.swing.JLabel typeL;
    // End of variables declaration//GEN-END:variables
}