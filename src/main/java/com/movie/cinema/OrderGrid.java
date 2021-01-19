/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import com.movie.cinema.db.AccountDao;
import com.movie.cinema.db.OrderDao;
import com.movie.cinema.db.ScheduleDao;
import com.movie.cinema.model.Cinema;
import com.movie.cinema.model.Movie;
import com.movie.cinema.model.Order;
import com.movie.cinema.model.Schedule;

/**
 *
 * @author Jiacheng Lv
 */
public class OrderGrid extends javax.swing.JPanel {

    MainFrame frame;
    // Booking data dao
    OrderDao orderDao = new OrderDao();
    // Film Arrangement Record dao
    ScheduleDao scheduleDao = new ScheduleDao();
    // user information dao
    AccountDao accDao = new AccountDao();
    // Booking information
    Order order;
    
    /**
     * Creates new form OrderGrid
     * @param order
     * @param schedule
     * @param cinema
     * @param movie
     */
    public OrderGrid(Order order, Schedule schedule, Cinema cinema, Movie movie) {
        frame = MainFrame.getInstance();
        this.order = order;
        
        initComponents();
        if(order.getStatus() == 0){
            statusL.setText("status: not used");
        }else{
            statusL.setText("status:used");
        }
        if(schedule != null){
            timeL.setText(schedule.getShowtime());
        }
        if(cinema != null){
            cinemaNameL.setText(cinema.getName());
        }
        if(movie != null){
            movieNameL.setText(movie.getName());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movieNameL = new javax.swing.JLabel();
        cinemaNameL = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        useBtn = new javax.swing.JButton();
        statusL = new javax.swing.JLabel();
        refundBtn = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        movieNameL.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        movieNameL.setText("movie name");

        cinemaNameL.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N
        cinemaNameL.setText("cinema");

        timeL.setText("2020-12-12 12:12");

        useBtn.setText("Use");
        useBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useBtnActionPerformed(evt);
            }
        });

        statusL.setText("status:");

        refundBtn.setText("Refund");
        refundBtn.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                refundBtnComponentAdded(evt);
            }
        });
        refundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(movieNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(statusL))
                    .addComponent(cinemaNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(useBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(refundBtn)
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeL)
                    .addComponent(statusL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cinemaNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(useBtn)
                    .addComponent(refundBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void useBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useBtnActionPerformed
        order.setStatus(1);
        int res = orderDao.updateStatus(order);
        if(res > 0){
            useBtn.setEnabled(false);
            BaseDialog.showInfo("Use ticket successfully.");
        }else{
            BaseDialog.showErr("Use ticket failed.");
        }
    }//GEN-LAST:event_useBtnActionPerformed

    private void refundBtnComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_refundBtnComponentAdded
        
        
    }//GEN-LAST:event_refundBtnComponentAdded

    private void refundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundBtnActionPerformed
                                                
        Schedule schedule = scheduleDao.getSchedule(order.getScheduleid());
        orderDao.deleteOrder(order.getId());
        if(schedule != null){
            frame.acc.setBalance(frame.acc.getBalance() + schedule.getPrice());
            accDao.updateAccount(frame.acc);
        }
        
        BaseDialog.showInfo("Refund ticket successfully.");
    }//GEN-LAST:event_refundBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cinemaNameL;
    private javax.swing.JLabel movieNameL;
    private javax.swing.JButton refundBtn;
    private javax.swing.JLabel statusL;
    private javax.swing.JLabel timeL;
    private javax.swing.JButton useBtn;
    // End of variables declaration//GEN-END:variables
}
