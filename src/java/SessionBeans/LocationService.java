/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import entities.Staedte;
import interfaces.ILocationService;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author mariusbrederlow
 */
@Stateless
@Remote(ILocationService.class)
public class LocationService implements ILocationService{

   @PersistenceContext   
    private EntityManager em;
   
   
    @Override
    public List<Integer> getSecKnoten(int id) {
       return null;
    }

    
    
    @Override
    public Staedte getStadt(int k1, int k2, int k3) {
       Staedte stadt;
       //Try Catch für getSingleResult einfügen
       Query q = em.createNamedQuery("Staedte.findStadt").setParameter("knoten1", k1).setParameter("knoten2", k2).setParameter("knoten3", k3);
       stadt = (Staedte) q.getSingleResult();
       
       return stadt;
    }
    
    
    
    
    @Override
    public List<Staedte> getTrdKnoten(int knotenID, int knotenID2) {
        List knoten;
       
      
       Query q = em.createNamedQuery("Staedte.thirdKnoten").setParameter("knoten1", knotenID).setParameter("knoten2", knotenID2);
       knoten = q.getResultList();
   
       return knoten;
    }
   
   
   
   
   
   
   
   
   
   @Override
   public List<Staedte> getNextKnoten(int knotenID){
        
       List knoten;
       
      
       Query q = em.createNamedQuery("Staedte.secondKnoten").setParameter("knoten1", knotenID);
       knoten = q.getResultList();
       
       
       
      
      
       
       return knoten;
       
   }
   
   
   
   @Override
   public List<Staedte> getNextKnoten(int knotenID, int knotenID2){
        System.out.println("trdKnotenLesen");
       List knoten;
       
      
       Query q = em.createNamedQuery("Staedte.thirdKnoten").setParameter("knoten1", knotenID).setParameter("knoten2", knotenID2);

       knoten = q.getResultList();
 
       return knoten;
       
   }

    @Override
    public Set nextKnotenSet(int knotenID) {
        
        Set knotenSet;
       
      
       Query q = em.createNamedQuery("Staedte.secondKnoten").setParameter("knoten1", knotenID);
       knotenSet = (Set)q.getResultList();
      
       return knotenSet;
    }

    

   

}
