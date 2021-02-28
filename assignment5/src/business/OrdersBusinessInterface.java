package business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import beans.Order;

@Stateless
@LocalBean
@Local(OrdersBusinessInterface.class)
public interface OrdersBusinessInterface  {
	
	public List<Order> getOrder();
	
	public void setOrder(List<Order> order);
	
	
	public void test();
	
	public void sendOrder(Order order);
	
	public void insertOrder(Order order);
	

}
