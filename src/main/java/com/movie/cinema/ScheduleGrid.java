/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import com.movie.cinema.model.Cinema;
import com.movie.cinema.model.Movie;
import com.movie.cinema.model.Schedule;

/**
 *
 * @author zhch
 */
public class ScheduleGrid extends javax.swing.JPanel {

    MainFrame frame;
    Movie movie;
    Schedule schedule;
    /**
     * Creates new form ScheduleGrid
     * @param schedule
     * @param movie
     * @param cinema
     */
    public ScheduleGrid(Schedule schedule, Movie movie, Cinema cinema) {
        initComponents();
        this.frame = MainFrame.getInstance();
        this.movie = movie;
        this.schedule = schedule;
        cinemaL.setText(cinema.getName());
        movieNameL.setText(movie.getName());
        timeL.setText(schedule.getShowtime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cinemaL = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        movieNameL = new javax.swing.JLabel();
        buyBtn = new javax.swing.JButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 100), 1, true));

        cinemaL.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        cinemaL.setText("cinemaName");

        timeL.setText("2020-12-12 12:20");

        movieNameL.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        movieNameL.setText("movieName");

        buyBtn.setText("Buy");
        buyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cinemaL, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movieNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyBtn))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cinemaL)
                    .addComponent(timeL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieNameL)
                    .addComponent(buyBtn))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBtnActionPerformed
        // TODO add your handling code here:
        SeatPanel seatPanel = new SeatPanel(schedule);
        frame.changePanel(seatPanel);
    }//GEN-LAST:event_buyBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyBtn;
    private javax.swing.JLabel cinemaL;
    private javax.swing.JLabel movieNameL;
    private javax.swing.JLabel timeL;
    // End of variables declaration//GEN-END:variables
}
