
package uts.wsd;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name="books")
public class Books implements Serializable{
    @XmlElement(name="book")
    private ArrayList<Book> booklist = new ArrayList<Book>();
    
    public ArrayList<Book> getList() 
    {
	return booklist;
    }
    
    public void addBook(Book book)
    {
	booklist.add(book);
    }
    
    public void removeBook(Book book)
    {
        booklist.remove(book);
    }
    
}
