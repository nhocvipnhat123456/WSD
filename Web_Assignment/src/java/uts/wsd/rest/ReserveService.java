package uts.wsd.rest;
 
import uts.wsd.ReservationsApplication;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import uts.wsd.*;
 
@Path("/reserveApp")
public class ReserveService {
 @Context
 private ServletContext application;
 
  private ReservationsApplication getReserveApp() throws Exception {
  // The web server can handle requests from different clients in parallel.
  // These are called "threads".
  //
  // We do NOT want other threads to manipulate the application object at the same
  // time that we are manipulating it, otherwise bad things could happen.
  //
  // The "synchronized" keyword is used to lock the application object while
  // we're manpulating it.
  synchronized (application) {
   ReservationsApplication reserveApp = (ReservationsApplication)application.getAttribute("reserveApp");
   if (reserveApp == null) {
    reserveApp = new ReservationsApplication();
    reserveApp.setFilePath(application.getRealPath("WEB-INF/reservations.xml"));
    application.setAttribute("reserveApp", reserveApp);
   }
   return reserveApp;
  }
 }
        @GET
	@Path("reserves/username/{username}")
	@Produces(MediaType.APPLICATION_XML)
	public Reservations getListbyName(@PathParam("username")String username) throws JAXBException, IOException, Exception {
		return getReserveApp().getReservations().getReservationbyUsername(username);
	}

        @GET
	@Path("reserves/status/{status}")
	@Produces(MediaType.APPLICATION_XML)
	public Reservations getListbyStatus(@PathParam("status")String status) throws Exception {
		return getReserveApp().getReservations().getReservationbyStatus(status);
	}
        
}