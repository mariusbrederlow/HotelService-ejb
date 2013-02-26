/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DTO.StadtDTO;
import entities.Staedte;
import interfaces.ILocationService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author mariusbrederlow
 */


/*
 * Sucht Staedte im DTO und gibt die Passende Stadt bzw eine Liste moeglicher Knoten zurueck.
 */
@Stateless
@Remote(ILocationService.class)
public class LocationService implements ILocationService {

   
    @EJB
    StadtDTO dto;


    @Override
    public Staedte getStadt(int k1, int k2, int k3) {
        return dto.findeStadt(k1, k2, k3);
    }


    @Override
    public List<Staedte> getNextKnoten(int knotenID) {
        return dto.findeZweitenKnoten(knotenID);
    }

    @Override
    public List<Staedte> getNextKnoten(int knotenID, int knotenID2) {
        return dto.findeDrittenKnoten(knotenID, knotenID2);
    }

}
