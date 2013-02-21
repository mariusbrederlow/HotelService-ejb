/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Hotels;
import entities.Staedte;
import java.util.List;
import javax.annotation.security.PermitAll;
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


public class HotelDTO {

    @PersistenceContext
    private EntityManager em;
    
   

    
    public List<Hotels> getHotelFromStadt(Staedte stadt){
       Query q = em.createNamedQuery("Hotels.findHotelByStadt").setParameter("stadtid", stadt);
       return q.getResultList();
    }
   

       
    
    public List<Hotels> getMatchingHotels(Staedte stadt, int pool, int sterne) {
       Query querry = em.createNamedQuery("Hotels.findMatchingHotelByStadt").setParameter("stadtid", stadt).setParameter("sterne", sterne).setParameter("pool", pool);
       return querry.getResultList();
    }
    
}
