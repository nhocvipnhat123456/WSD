/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="user")
public class User implements Serializable {
    @XmlElement (name="email")
    private String email;
    @XmlElement (name = "name")
    private String name;
    @XmlElement(name="password")
    private String password;
    @XmlElement(name="gender")
    private String gender;
    @XmlElement (name="dob")
    private String dob;
    
    public User() {
        super();
    }
    
    public User(String email, String name, String password, String gender, String dob) {
        super();
        this.email = email;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
}

