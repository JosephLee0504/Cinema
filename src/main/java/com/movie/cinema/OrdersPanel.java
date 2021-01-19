/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import com.movie.cinema.db.AccountDao;
import com.movie.cinema.db.CinemaDao;
import com.movie.cinema.db.MovieDao;
import com.movie.cinema.db.OrderDao;
import com.movie.cinema.db.ScheduleDao;
import com.movie.cinema.model.Cinema;
import com.movie.cinema.model.Movie;
import com.movie.cinema.model.Order;
import com.movie.cinema.model.Schedule;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jiacheng Lv
 */
public class OrdersPanel extends javax.swing.JPanel {
    
    MainFrame frame;
    // Booking information dao
    OrderDao orderDao = new OrderDao();
    // Movie Arrangement dao
    ScheduleDao scheduleDao = new ScheduleDao();
    // User Information dao
    AccountDao accDao = new AccountDao();
    // Cinema Information dao
    CinemaDao cinemaDao = new CinemaDao();
    // Cinema Information dao
    MovieDao movieDao = new MovieDao();

    /**
     * Creates new form OrdersPanel
     */
    public OrdersPanel() {
        frame = MainFrame.getInstance();
        initComponents();
        
        updateData();
    }
    
    public void updateData(){
        int accid = frame.acc.getId();
        List<Order> list = orderDao.getAccountOrders(accid);
        conPanel.setLayout(new GridLayout(list.size(),1));
        List<Integer> scheids = new ArrayList<>();
        List<Integer> cinemaids = new ArrayList<>();
        List<Integer> movieids = new ArrayList<>();
        for(Order order : list){
            scheids.add(order.getScheduleid());
            
        }
        Map<Integer, Schedule> scheMap = scheduleDao.getSchedulesMap(scheids);
        for(Schedule sch : scheMap.values()){
            cinemaids.add(sch.getCinemaid());
            movieids.add(sch.getMovieid());
        }
        Map<Integer, Cinema> cinemaMap = cinemaDao.getCinemasMap(cinemaids);
        Map<Integer, Movie> movieMap = movieDao.getMoviesMap(movieids);
        for(Order order : list){
            Schedule sch = scheMap.get(order.getScheduleid());
            Cinema cinema = null;
            if(sch != null){
                cinema = cinemaMap.get(sch.getCinemaid());
            }
            Movie movie = null;
            if(sch != null){
                movie = movieMap.get(sch.getMovieid());
            }
            OrderGrid grid = new OrderGrid(order, sch, cinema, movie);
            conPanel.add(grid);
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

        scrollPane = new javax.swing.JScrollPane();
        conPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout conPanelLayout = new javax.swing.GroupLayout(conPanel);
        conPanel.setLayout(conPanelLayout);
        conPanelLayout.setHorizontalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        conPanelLayout.setVerticalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(conPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
