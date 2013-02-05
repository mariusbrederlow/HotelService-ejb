/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariusbrederlow
 */
@Entity
@Table(name = "Hotels", catalog = "Hotelsuche", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotels.findAll", query = "SELECT h FROM Hotels h"),
    @NamedQuery(name = "Hotels.findByHotelID", query = "SELECT h FROM Hotels h WHERE h.hotelID = :hotelID"),
    @NamedQuery(name = "Hotels.findByHotelName", query = "SELECT h FROM Hotels h WHERE h.hotelName = :hotelName"),
    @NamedQuery(name = "Hotels.findBySterne", query = "SELECT h FROM Hotels h WHERE h.sterne = :sterne"),
    @NamedQuery(name = "Hotels.findByPool", query = "SELECT h FROM Hotels h WHERE h.pool = :pool"),
    @NamedQuery(name = "Hotels.findAll5StarHotels", query = "SELECT h FROM Hotels h")})
public class Hotels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hotel_ID")
    private Integer hotelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Hotel_Name")
    private String hotelName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sterne")
    private int sterne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pool")
    private short pool;
    @JoinColumn(name = "Staedte_Stadt_ID", referencedColumnName = "Stadt_ID")
    @ManyToOne(optional = false)
    private Staedte staedteStadtID;

    public Hotels() {
    }

    public Hotels(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public Hotels(Integer hotelID, String hotelName, int sterne, short pool) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.sterne = sterne;
        this.pool = pool;
    }

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getSterne() {
        return sterne;
    }

    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    public short getPool() {
        return pool;
    }

    public void setPool(short pool) {
        this.pool = pool;
    }

    public Staedte getStaedteStadtID() {
        return staedteStadtID;
    }

    public void setStaedteStadtID(Staedte staedteStadtID) {
        this.staedteStadtID = staedteStadtID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelID != null ? hotelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotels)) {
            return false;
        }
        Hotels other = (Hotels) object;
        if ((this.hotelID == null && other.hotelID != null) || (this.hotelID != null && !this.hotelID.equals(other.hotelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hotels[ hotelID=" + hotelID + " ]";
    }
    
}
