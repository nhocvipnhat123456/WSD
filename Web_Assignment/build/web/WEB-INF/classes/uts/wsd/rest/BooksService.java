package uts.wsd.rest;
 
import uts.wsd.ReservationsApplication;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import uts.wsd.*;
 
@Path("/bookApp")
public class BooksService {
 @Context
 private ServletContext application;
 
 private BooksApplication getBookApp() throws Exception {
  // The web server can handle requests from different clients in parallel.
  // These are called "threads".
  //
  // We do NOT want other threads to manipulate the application object at the same
  // time that we are manipulating it, otherwise bad things could happen.
  //
  // The "synchronized" keyword is used to lock the application object while
  // we're manpulating it.
  synchronized (application) {
   BooksApplication bookApp = (BooksApplication)application.getAttribute("bookApp");
   if (bookApp == null) {
    bookApp = new BooksApplication();
    bookApp.setFilePath(application.getRealPath("WEB-INF/books.xml"));
    application.setAttribute("bookApp", bookApp);
   }
   return bookApp;
  }
 }
        @GET
	@Path("books")
	@Produces(MediaType.APPLICATION_XML)
	public Books getBooks() throws Exception {
		return getBookApp().getBooks();
	}
}