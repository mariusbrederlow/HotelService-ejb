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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Object> getMatchingHotels() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  

  
    
    
    
}
