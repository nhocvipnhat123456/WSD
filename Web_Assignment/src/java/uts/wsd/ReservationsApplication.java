
package uts.wsd;

import java.io.*;
import javax.xml.bind.*;

public class ReservationsApplication implements Serializable {
    private String filePath;
    private Reservations reservations;
     
    public ReservationsApplication() {
        
    }
    
    public ReservationsApplication (String filePath, Reservations reservations) {
        super();
        this.filePath = filePath;
        this.reservations = reservations;
    }
	

    public void setFilePath(String filePath) throws Exception {
        // create unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Reservations.class, Reservation.class);
	Unmarshaller u = jc.createUnmarshaller();
        
        this.filePath = filePath;
        // now unmarshal the object from the file
	FileInputStream fin = new FileInputStream(filePath);
	reservations = (Reservations)u.unmarshal(fin); //this loads "user" object
	fin.close();
        setReservations(reservations);
    }
    
    public Reservations getReservations() {
	return reservations;
    }

    public void setReservations(Reservations reservations) throws JAXBException{
	this.reservations = reservations;
    }   
    
    public String getFilePath() {
        return filePath;
    }
    
    //add new reservation and transform it into xml, save to same location
    public void updateXML (Reservations reservations, String filePath) throws Exception{
            this.reservations = reservations;
            this.filePath = filePath;
            JAXBContext jc = JAXBContext.newInstance(Reservations.class, Reservation.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileOutputStream fos = new FileOutputStream(filePath);
            m.marshal(reservations, fos);
            fos.close();
    }
        
    public void saveReservations() throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Reservations.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fos = new FileOutputStream(filePath);
        m.marshal(reservations, fos);
        fos.close();
    }
    
    public void LoadReservations() throws JAXBException, FileNotFoundException, IOException {
        // Create the unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Reservations.class);
        Unmarshaller u = jc.createUnmarshaller();

        // Now unmarshal the object from the file
        FileInputStream fin = new FileInputStream(filePath);
        reservations = (Reservations) u.unmarshal(fin); // This loads the "users" object
        fin.close();
    }
    
    
}
