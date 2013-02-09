/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import entities.Hotels;
import entities.Staedte;
import interfaces.IHotelService;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author mariusbrederlow
 */
@Stateless
@Remote(IHotelService.class)
@PermitAll


public class HotelService implements IHotelService{

    @PersistenceContext
    private EntityManager em;
    
   

    @Override
    public List<Hotels> getHotelFromStadt(Staedte stadt){
        
        Query q = em.createNamedQuery("Hotels.findHotelByStadt").setParameter("stadtid", stadt);
        
        
        return q.getResultList();
    }
   

    @Override
    public void createHotel(Object hotel) {
        
        em.persist(hotel);
    }

    @Override
    public List<Object> getallHotels() {
        TypedQuery<Object> querry = em.createQuery("select h from Hotels h", Object.class);
        return querry.getResultList();
    }

    @Override
    public List<Hotels> getMatchingHotels(Staedte stadt, int pool, int sterne) {
        
        
        
       Query querry = em.createNamedQuery("Hotels.findMatchingHotelByStadt").setParameter("stadtid", stadt).setParameter("sterne", sterne).setParameter("pool", pool);
       return querry.getResultList();
    }

  

  
    
    
    
}
