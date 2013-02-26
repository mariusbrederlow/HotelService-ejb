/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Staedte;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mariusbrederlow
 */
@Stateless
@LocalBean
public class StadtDTO {

    @PersistenceContext
    private EntityManager em;
    
    
    /*
     * Gibt eine Stadt zurueck, die anhand der 3 uebergebenen WLAN-Knoten identifiziert wird
     */
    public Staedte findeStadt(int k1, int k2, int k3) {
        Staedte stadt;
        //Try Catch für getSingleResult einfügen
        Query q = em.createNamedQuery("Staedte.findStadt").setParameter("knoten1", k1).setParameter("knoten2", k2).setParameter("knoten3", k3);
        stadt = (Staedte) q.getSingleResult();

        return stadt;
    }
    
/*
 * Gibt eine Liste zurück, die alle möglichen 2. Knoten enthaelt
 */
    public List<Staedte> findeZweitenKnoten(int knotenID) {

        List knoten;

        Query q = em.createNamedQuery("Staedte.secondKnoten").setParameter("knoten1", knotenID);
        knoten = q.getResultList();

        return knoten;
    }
    
    /*
 * Gibt eine Liste zurück, die alle möglichen 3. Knoten enthaelt
 */
    public List<Staedte> findeDrittenKnoten(int knotenID, int knotenID2) {
        
        List knoten;

        Query q = em.createNamedQuery("Staedte.thirdKnoten").setParameter("knoten1", knotenID).setParameter("knoten2", knotenID2);
        knoten = q.getResultList();

        return knoten;

    }
    
    
}
