/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.model;

import java.io.Serializable;

/**
 *
 * @author Jiacheng Lv
 */
public class Room implements Serializable {
    private Integer id;

    private String name;

    private Integer cinemaid;

    private Integer seatcount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCinemaid() {
        return cinemaid;
    }

    public void setCinemaid(Integer cinemaid) {
        this.cinemaid = cinemaid;
    }

    public Integer getSeatcount() {
        return seatcount;
    }

    public void setSeatcount(Integer seatcount) {
        this.seatcount = seatcount;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Room other = (Room) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCinemaid() == null ? other.getCinemaid() == null : this.getCinemaid().equals(other.getCinemaid()))
            && (this.getSeatcount() == null ? other.getSeatcount() == null : this.getSeatcount().equals(other.getSeatcount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCinemaid() == null) ? 0 : getCinemaid().hashCode());
        result = prime * result + ((getSeatcount() == null) ? 0 : getSeatcount().hashCode());
        return result;
    }
}