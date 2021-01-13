/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema;

import com.movie.cinema.model.Account;
import com.movie.cinema.model.Comment;

/**
 *
 * @author zhch
 */
public class CommentGrid extends javax.swing.JPanel {

    /**
     * Creates new form CommentGrid
     * @param comment
     * @param acc
     */
    public CommentGrid(Comment comment, Account acc) {
        initComponents();
        commentL.setText(comment.getComment());
        timeL.setText(comment.getPublishtime());
        if(acc != null){
            usernameL.setText("User:"+acc.getUsername());
        }else{
            usernameL.setText("User:unknow");
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

        usernameL = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        commentL = new javax.swing.JLabel();

        usernameL.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        usernameL.setText("username");

        timeL.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        timeL.setText("time");

        commentL.setText("comment");
        commentL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commentL, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernameL, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameL)
                    .addComponent(timeL))
                .addGap(18, 18, 18)
                .addComponent(commentL, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commentL;
    private javax.swing.JLabel timeL;
    private javax.swing.JLabel usernameL;
    // End of variables declaration//GEN-END:variables
}
