/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import com.movie.cinema.db.MovieDao;
import com.movie.cinema.db.OrderDao;
import com.movie.cinema.db.RoomDao;
import com.movie.cinema.model.Movie;
import com.movie.cinema.model.Order;
import com.movie.cinema.model.Room;
import com.movie.cinema.model.Schedule;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author zhch
 */
public class SeatPanel extends javax.swing.JPanel {
    
    // 订票记录 dao
    OrderDao orderDao = new OrderDao();
    // 电影 dao
    MovieDao movieDao = new MovieDao();
    // 放映厅 dao
    RoomDao roomDao = new RoomDao();
    MainFrame frame;
    public final SeatPanel thisPanel;
    Schedule schedule;
    Movie movie;
    int choosedSeat = -1;
    /**
     * Creates new form SeatPanel
     */
    public SeatPanel(Schedule schedule) {
        frame = MainFrame.getInstance();
        thisPanel = this;
        this.schedule = schedule;
        initComponents();
        movie = movieDao.getMovie(schedule.getMovieid());
        List<Order> list = orderDao.getOrders(schedule.getId());
        List<Integer> orderedSeats = new ArrayList<>();
        for(Order order : list){
            orderedSeats.add(order.getSeat());
        }
        Room room = roomDao.getRoomById(schedule.getRoomid());
        int n = room == null ? 100 : room.getSeatcount();
        conPanel.setLayout(new GridLayout((n+9)/10, 10));
        ImageIcon img = new ImageIcon("imgs/seat.png");
        Image image = img.getImage();
        img.setImage(image.getScaledInstance(40, 30,Image.SCALE_DEFAULT));
        for(int i=0;i<n;i++){
            JButton btn = new JButton("");
            btn.setIcon(img);
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    thisPanel.setText(i);
                }
            });
            if(orderedSeats.contains(i)){
                btn.setEnabled(false);
            }
            conPanel.add(btn);
        }
    }
    /**
     * 设置选中的座位
     * @param i 
     */
    public final void setText(int i){
        choosedL.setText("" + i);
        choosedSeat = i;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseHintL = new javax.swing.JLabel();
        choosedL = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        conPanel = new javax.swing.JPanel();

        chooseHintL.setText("Choose your seat:");

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conPanelLayout = new javax.swing.GroupLayout(conPanel);
        conPanel.setLayout(conPanelLayout);
        conPanelLayout.setHorizontalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        conPanelLayout.setVerticalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(conPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(chooseHintL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(choosedL, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(submitBtn)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseHintL)
                    .addComponent(choosedL, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        Order order = new Order();
        order.setScheduleid(schedule.getId());
        order.setAccountid(frame.acc.getId());
        order.setSeat(choosedSeat);
        order.setStatus(0);  // 0 是没有看 1 是看过了
        orderDao.addOrder(order);
        BaseDialog.showInfo("Buy ticket successfully.");
    }//GEN-LAST:event_submitBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chooseHintL;
    private javax.swing.JLabel choosedL;
    private javax.swing.JPanel conPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}