
package uts.wsd;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reservation")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Reservation {
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "useremail")
    private String useremail;
    
    public Reservation() {
        super();
    }
    
    public Reservation(String title, String status, String username, String useremail) 
    {
        super();
        this.title = title;
        this.status = status;
        this.username = username;
        this.useremail = useremail;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getUsername() {
        return username;
    }

    public void getUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void getUseremail(String useremail) {
        this.useremail = useremail;
    }
    
}
