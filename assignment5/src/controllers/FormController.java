package controllers;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.OrdersBusinessInterface;
//import business.OrdersBusinessService;


@ManagedBean
@ViewScoped
public class FormController {
	@Inject
	OrdersBusinessInterface service;

	

	//@EJB
	//OrdersBusinessService serve;

	public String onLogoff() {
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "Response.xhtml?faces-redirect=true";

	}
	

	
	public OrdersBusinessInterface getService(){
		return service;
	}
	
	
	
	
	public String onSendOrder() {
		Order order =  new Order();
		order.setOrderNo("12345");
		order.setPrice(500);
		order.setProductName("Spongbob");
		order.setQuantity(420);
		
		service.sendOrder(order);
		return "OrderResponse.xhtml";
	}
}
