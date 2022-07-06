package com.datit.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DatIT
 */
@Entity
@Table(name = "budget")

public class Budget implements Serializable, Comparable<Budget> {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "des")
    private String des;

    @Column(name = "create_date")
    @Basic
    private Date createDate;

    @Column(name = "value")
    private double values;

    @Column(name = "status")
    private boolean status;

    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private User User;

    public Budget() {
    }

    public Budget(Long id) {
        this.id = id;
    }

    public Budget(String title, String des, boolean status, double values, Date create_date) {
        this.title = title;
        this.des = des;
        this.status = status;
        this.values = values;
        this.createDate = create_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Budget)) {
            return false;
        }
        Budget other = (Budget) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.datit.model.Budget[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Budget o) {
        return this.values > o.values ? 1 : -1;
    }

}
