package business;


import java.util.List;

import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;
@RequestScoped
@Path("/orders")
@ApplicationPath("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
@LocalBean
public class OrdersRestService {
	
	@Inject
	OrdersBusinessInterface service;
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson(){
		return service.getOrder();
	}

	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXml() {
		List<Order> orders = service.getOrder();
		return orders.toArray(new Order[orders.size()]);
	}
}
