
package uts.wsd;

import java.io.*;
import javax.xml.bind.*;

public class BooksApplication implements Serializable {
    private String filePath;
    private Books books;
     
    public BooksApplication() {
        
    }
    
    public BooksApplication (String filePath, Books books) {
        super();
        this.filePath = filePath;
        this.books = books;
    }
	
    public String getFilePath() {
        return filePath;
    }
  
    public void setFilePath(String filePath) throws Exception {
        // create unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Books.class, Book.class);
	Unmarshaller u = jc.createUnmarshaller();
        
        this.filePath = filePath;
        // now unmarshal the object from the file
	FileInputStream fin = new FileInputStream(filePath);
	books = (Books)u.unmarshal(fin); //this loads "user" object
	fin.close();
        setBooks(books);
    }
    
    public Books getBooks() {
	return books;
    }

    public void setBooks(Books books) throws JAXBException{
	this.books = books;
    }   
    
    //add new book and transform it into xml, save to same location
    public void updateXML (Books books, String filePath) throws Exception{
            this.books = books;
            this.filePath = filePath;
            JAXBContext jc = JAXBContext.newInstance(Books.class, Book.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileOutputStream fos = new FileOutputStream(filePath);
            m.marshal(books, fos);
            fos.close();
    }
        
    public void saveBooks() throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Books.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fos = new FileOutputStream(filePath);
        m.marshal(books, fos);
        fos.close();
    }
    
    public void loadBooks() throws JAXBException, FileNotFoundException, IOException {
        // Create the unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Books.class);
        Unmarshaller u = jc.createUnmarshaller();

        // Now unmarshal the object from the file
        FileInputStream fin = new FileInputStream(filePath);
        books = (Books) u.unmarshal(fin); // This loads the "books" object
        fin.close();
    }
    
}
