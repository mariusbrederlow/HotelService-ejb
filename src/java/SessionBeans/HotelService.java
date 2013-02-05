/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

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
    public void createHotel(Object hotel) {
        
        em.persist(hotel);
    }

    @Override
    public List<Object> getallHotels() {
        TypedQuery<Object> querry = em.createQuery("select h from Hotels h", Object.class);
        return querry.getResultList();
    }

    @Override
    public List<Object> getMatchingHotels() {
        
       Query querry = em.createNamedQuery("Hotels.findBySterne").setParameter("sterne",5);
       return querry.getResultList();
    }

  

  
    
    
    
}
