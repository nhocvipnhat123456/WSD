
package uts.wsd;

import java.io.File;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="reservations")
public class Reservations implements Serializable{
    
    @XmlElement(name="reservation")
    private ArrayList<Reservation> reservationlist = new ArrayList<Reservation>();
    
    public ArrayList<Reservation> getList() 
    {
	return reservationlist;
    }
    
    public void addReservation(Reservation reservation)
    {
	reservationlist.add(reservation);
    }
    
    public void removeReservation(Reservation reservation)
    {
        reservationlist.remove(reservation);
    }

    public Reservations getReservationbyStatus(String status) {
        Reservations temp = new Reservations();
    	for(Reservation reservation :reservationlist)
    	{
            if(reservation.getStatus().equals(status))			
            {
		temp.addReservation(reservation);
            }	
    	}
    	return temp;
    }

    public Reservations getReservationbyUsername(String username) {
        Reservations temp = new Reservations();
    	for(Reservation reservation :reservationlist)
    	{
            if(reservation.getUsername().equals(username))			
            {
		temp.addReservation(reservation);
            }	
    	}
    	return temp;
    }
    
    public Reservations getReservationbyUseremail(String useremail) {
        Reservations temp = new Reservations();
    	for(Reservation reservation :reservationlist)
    	{
            if(reservation.getUseremail().equals(useremail))			
            {
		temp.addReservation(reservation);
            }	
    	}
    	return temp;
    }
    
}
