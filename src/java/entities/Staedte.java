/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mariusbrederlow
 */
@Entity
@Table(name = "Staedte", catalog = "Hotelsuche", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staedte.findNextKnoten", query = "SELECT s.knoten1,s.knoten2,s.knoten3 FROM Staedte s WHERE s.knoten1 = :knoten1 or s.knoten2 = :knoten1 or s.knoten3 = :knoten1"),
    @NamedQuery(name = "Staedte.findAll", query = "SELECT s FROM Staedte s"),
    @NamedQuery(name = "Staedte.findByStadtID", query = "SELECT s FROM Staedte s WHERE s.stadtID = :stadtID"),
    @NamedQuery(name = "Staedte.findByStadtName", query = "SELECT s FROM Staedte s WHERE s.stadtName = :stadtName"),
    @NamedQuery(name = "Staedte.findByKnoten1", query = "SELECT s FROM Staedte s WHERE s.knoten1 = :knoten1"),
    @NamedQuery(name = "Staedte.findByKnoten2", query = "SELECT s FROM Staedte s WHERE s.knoten2 = :knoten2"),
    @NamedQuery(name = "Staedte.findByKnoten3", query = "SELECT s FROM Staedte s WHERE s.knoten3 = :knoten3")})
public class Staedte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Stadt_ID")
    private Integer stadtID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Stadt_Name")
    private String stadtName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Knoten1")
    private int knoten1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Knoten2")
    private int knoten2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Knoten3")
    private int knoten3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staedteStadtID")
    private Collection<Hotels> hotelsCollection;

    public Staedte() {
    }

    public Staedte(Integer stadtID) {
        this.stadtID = stadtID;
    }

    public Staedte(Integer stadtID, String stadtName, int knoten1, int knoten2, int knoten3) {
        this.stadtID = stadtID;
        this.stadtName = stadtName;
        this.knoten1 = knoten1;
        this.knoten2 = knoten2;
        this.knoten3 = knoten3;
    }

    public Integer getStadtID() {
        return stadtID;
    }

    public void setStadtID(Integer stadtID) {
        this.stadtID = stadtID;
    }

    public String getStadtName() {
        return stadtName;
    }

    public void setStadtName(String stadtName) {
        this.stadtName = stadtName;
    }

    public int getKnoten1() {
        return knoten1;
    }

    public void setKnoten1(int knoten1) {
        this.knoten1 = knoten1;
    }

    public int getKnoten2() {
        return knoten2;
    }

    public void setKnoten2(int knoten2) {
        this.knoten2 = knoten2;
    }

    public int getKnoten3() {
        return knoten3;
    }

    public void setKnoten3(int knoten3) {
        this.knoten3 = knoten3;
    }

    @XmlTransient
    public Collection<Hotels> getHotelsCollection() {
        return hotelsCollection;
    }

    public void setHotelsCollection(Collection<Hotels> hotelsCollection) {
        this.hotelsCollection = hotelsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stadtID != null ? stadtID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staedte)) {
            return false;
        }
        Staedte other = (Staedte) object;
        if ((this.stadtID == null && other.stadtID != null) || (this.stadtID != null && !this.stadtID.equals(other.stadtID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Staedte[ stadtID=" + stadtID + " ]";
    }
    
}
