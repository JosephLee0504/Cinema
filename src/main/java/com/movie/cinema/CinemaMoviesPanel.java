/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import com.movie.cinema.db.MovieDao;
import com.movie.cinema.db.ScheduleDao;
import com.movie.cinema.model.Cinema;
import com.movie.cinema.model.Movie;
import com.movie.cinema.model.Schedule;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author zhch
 */
public class CinemaMoviesPanel extends javax.swing.JPanel {

    // 排片信息 dao
    ScheduleDao scheduleDao = new ScheduleDao();
    // 影片信息 dao
    MovieDao movieDao = new MovieDao();
    
    Cinema cinema;
    /**
     * Creates new form CinemaMoviesPanel
     * @param cinema
     */
    public CinemaMoviesPanel(Cinema cinema) {
        this.cinema = cinema;
        initComponents();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        updateData();
    }
    
    private void updateData(){
        List<Schedule> list = scheduleDao.getCinemaSchedules(cinema.getId());
        conPanel.setLayout(new GridLayout(list.size(), 1));
        List<Integer> movieids = new ArrayList<>();
        list.forEach((Schedule sch) -> {
            movieids.add(sch.getMovieid());
        });
        Map<Integer, Movie> movies = movieDao.getMoviesMap(movieids);
        list.stream().map(sch -> {
            Movie movie = movies.get(sch.getMovieid());
            CinemaMovieGrid grid = new CinemaMovieGrid(sch, movie);
            return grid;
        }).forEachOrdered(grid -> {
            conPanel.add(grid);
        });
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
            .addGap(0, 771, Short.MAX_VALUE)
        );
        conPanelLayout.setVerticalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(conPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel conPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
