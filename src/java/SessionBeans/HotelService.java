/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DTO.HotelDTO;
import entities.Hotels;
import entities.Staedte;
import interfaces.IHotelService;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


/**
 *
 * @author mariusbrederlow
 */
@Stateless
@Remote(IHotelService.class)
@PermitAll


public class HotelService implements IHotelService{

    @EJB
    HotelDTO dto;
    
   

    @Override
    public List<Hotels> sucheHotelsInStadt(Staedte stadt){        
        return dto.getHotelFromStadt(stadt);      
    }
   

    @Override
    public List<Hotels> suchePassendeHotels(Staedte stadt, int pool, int sterne) {
       return dto.getMatchingHotels(stadt, pool, sterne);
    }
  
}
