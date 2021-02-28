package business;

import java.util.ArrayList;
import java.util.List;
import javax.jms.Queue;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import beans.Orders;
/**
 * Session Bean implementation class OrderBusinessService
 */
@Local(OrdersBusinessInterface.class)
@Alternative
@Stateless
@LocalBean
public class OrdersBusinessService implements OrdersBusinessInterface {
	List<Order> orders = new ArrayList<Order>();
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	
	
	public OrdersBusinessService() {
		orders.add(new Order("100" , "This is product: 1", (float) (Math.random() * 100.0),1));
		orders.add(new Order("000000000", "This is product 0", (float)1.00, 12));
		orders.add(new Order("000000001", "This is product 1", (float)1.00, 13));
		orders.add(new Order("000000002", "This is product 2", (float)1.00, 15));
		orders.add(new Order("000000003", "This is product 3", (float)1.00, 16));
		orders.add(new Order("000000004", "This is product 4", (float)1.00, 17));
		orders.add(new Order("000000005", "This is product 5", (float)1.00, 18));
		orders.add(new Order("000000006", "This is product 6", (float)1.00, 19));
		orders.add(new Order("000000007", "This is product 7", (float)1.00, 10));
		orders.add(new Order("000000008", "This is product 8", (float)1.00, 10));
		orders.add(new Order("000000009", "This is product 9", (float)1.00, 1));
	}

	
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService" );
		
	}
	
	@Inject
	OrdersBusinessService ord;
	
	@Override
	public List<Order> getOrder() {
		return orders;
	}

	@Override
	public void setOrder(List<Order> order) {
		this.orders = order;
		
	}



	@Override
	public void sendOrder(Order order) {
		try 
		{
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			ObjectMessage message2 = session.createObjectMessage();
			message2.setObject(order);
			message1.setText("This is test message");
			messageProducer.send(message1);
			messageProducer.send(message2);
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}

		
	}



	@Override
	public void insertOrder(Order order) {
		Orders.orders.add(order);
		//orders.add(order);
		
	}
	


}
