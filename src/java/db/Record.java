/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amon.Sabul
 */
@Entity
@Table(name = "record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Record.findAll", query = "SELECT r FROM Record r")
    , @NamedQuery(name = "Record.findByIdrecord", query = "SELECT r FROM Record r WHERE r.idrecord = :idrecord")
    , @NamedQuery(name = "Record.findByName", query = "SELECT r FROM Record r WHERE r.name = :name")
    , @NamedQuery(name = "Record.findByAge", query = "SELECT r FROM Record r WHERE r.age = :age")
    , @NamedQuery(name = "Record.findByGender", query = "SELECT r FROM Record r WHERE r.gender = :gender")
    , @NamedQuery(name = "Record.findByCounty", query = "SELECT r FROM Record r WHERE r.county = :county")})
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecord")
    private Integer idrecord;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "county")
    private String county;

    public Record() {
    }

    public Record(Integer idrecord) {
        this.idrecord = idrecord;
    }

    public Record(Integer idrecord, String name, int age, String gender, String county) {
        this.idrecord = idrecord;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.county = county;
    }

    public Integer getIdrecord() {
        return idrecord;
    }

    public void setIdrecord(Integer idrecord) {
        this.idrecord = idrecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecord != null ? idrecord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Record)) {
            return false;
        }
        Record other = (Record) object;
        if ((this.idrecord == null && other.idrecord != null) || (this.idrecord != null && !this.idrecord.equals(other.idrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Record[ idrecord=" + idrecord + " ]";
    }
    
}
