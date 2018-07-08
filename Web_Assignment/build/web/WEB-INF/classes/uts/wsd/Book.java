
package uts.wsd;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)

@XmlRootElement(name = "book")
public class Book implements Serializable{
    @XmlElement(name = "ID")
    private int ID;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "author")
    private String author;
    @XmlElement(name = "category")
    private String category;
    @XmlElement(name = "ISBN")
    private int ISBN;
    @XmlElement(name = "edition")
    private int edition;
    @XmlElement(name = "year")
    private int year;
    @XmlElement(name = "publicshername")
    private String publicshername;
    @XmlElement(name = "status")
    private String status;

    public Book() {
        super();
    }
    
    public Book(int ID, String title, String author, String category, int ISBN, int edition, int year, String publicshername, String status)
    {
        super();
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.ISBN = ISBN;
        this.edition = edition;
        this.year = year;
        this.publicshername = publicshername;
        this.status = status;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublicshername() {
        return publicshername;
    }

    public void setPublicshername(String publicshername) {
        this.publicshername = publicshername;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
