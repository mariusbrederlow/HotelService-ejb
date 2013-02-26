/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;



import entities.Hotels;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author mariusbrederlow
 */
@Stateless
@LocalBean
public class XMLConverter {

    static final Logger logger = Logger.getLogger("logger");
    
    /*
 * Marshalling einer HotelListe in XML mittels JAXB. Das Ergebnis wird in ein
 * Byte-Array geschrieben und zurueck gegeben.
 */
     public byte[] convertHotelsToXML(List<Hotels> hotels) throws IOException, JAXBException {
      
         
        JAXBContext context;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b;
        
        context = JAXBContext.newInstance(HotelListe.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new HotelListe(hotels), bos);
      
        b=bos.toByteArray();
        
        logger.info("Inhalt des gemarshallten XML\n" + bos.toString());
       

        
        
         return b;
    }

}
