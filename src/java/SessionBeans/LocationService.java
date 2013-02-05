/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import interfaces.ILocationService;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mariusbrederlow
 */
@Stateless
@LocalBean
public class LocationService implements ILocationService{

   @PersistenceContext
    private EntityManager em;
   
   public List getNextKnoten(int i){
        
       List knoten;
       
       Query q = em.createNamedQuery("Staedte.findNextKnoten").setParameter(":knoten1", i);
       
       knoten = q.getResultList();
       Iterator itr = knoten.iterator();
       while(itr.hasNext()){
           Object element = itr.next();
         System.out.print(element + " ");
       }
      
      
       
       return knoten;
       
   }

}
