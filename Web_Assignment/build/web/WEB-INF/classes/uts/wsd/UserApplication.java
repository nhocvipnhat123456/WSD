/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.util.*;
import java.io.*;
import javax.xml.bind.*;

public class UserApplication implements Serializable{
    private String filePath;
    private Users users;
    
    public UserApplication () {
        
    }
    
    public UserApplication(String filePath, Users users) {
        super();
        this.filePath = filePath;
        this.users = users;
    }
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws Exception {
        // create unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Users.class, User.class);
	Unmarshaller u = jc.createUnmarshaller();
        
        this.filePath = filePath;
        // now unmarshal the object from the file
	FileInputStream fin = new FileInputStream(filePath);
	users = (Users)u.unmarshal(fin); //this loads "user" object
	fin.close();
        setUsers(users);
    }

    public void updateXML (Users users, String filePath) throws Exception{
            this.users = users;
            this.filePath = filePath;
            JAXBContext jc = JAXBContext.newInstance(Users.class, User.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileOutputStream fos = new FileOutputStream(filePath);
            m.marshal(users, fos);
            fos.close();
    }
    
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) throws JAXBException {
        this.users = users;
    }

    public void saveUsers() throws JAXBException, IOException {
	JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
	m.marshal(users, fout);
	fout.close();
    }
    
    public void LoadUsers() throws JAXBException, FileNotFoundException, IOException {
        // Create the unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Unmarshaller u = jc.createUnmarshaller();

        // Now unmarshal the object from the file
        FileInputStream fin = new FileInputStream(filePath);
        users = (Users) u.unmarshal(fin); // This loads the "users" object
        fin.close();
    }
    
    
}
