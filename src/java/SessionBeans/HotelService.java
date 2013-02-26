/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DTO.HotelDTO;
import Util.HotelListe;
import Util.XMLConverter;
import entities.Staedte;
import interfaces.IHotelService;
import java.io.IOException;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;


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
    @EJB
    XMLConverter con;
    
   
/*
 * Sucht alle Hotels einer Stadt. Ruft den XMLConverter auf und gibt ein Byte-Array zurueck, dass das XML Doc enthaelt.
 */
    @Override    
    public byte[] sucheHotelsInStadt(Staedte stadt){
     byte[] b = null;
        try{
        HotelListe liste = new HotelListe(dto.getHotelFromStadt(stadt));
        b = con.convertHotelsToXML(liste.getHotels());}
        catch(IOException e){
           e.printStackTrace(System.out);
        }
        catch(JAXBException e){
            e.printStackTrace(System.out);
        }
        return b;      
    }
   
/*
 * Sucht passende Hotels einer Stadt entsprechen der Suchkriterien. Ruft den XMLConverter auf und gibt ein Byte-Array zurueck, dass das XML Doc enthaelt.
 */
    @Override
    public byte[] suchePassendeHotels(Staedte stadt, int pool, int sterne) {
        byte[] bos = null;
        try{
            HotelListe liste = new HotelListe(dto.getMatchingHotels(stadt, pool, sterne));
            bos = con.convertHotelsToXML(liste.getHotels());
        }
        catch(IOException e){
           e.printStackTrace(System.out);
        }
        catch(JAXBException e){
            e.printStackTrace(System.out);
        }
       return bos;
    }
  
}
