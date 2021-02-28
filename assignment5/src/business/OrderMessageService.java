package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import beans.Orders;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {
	
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	@Inject
	OrdersBusinessInterface service;
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        try {
        	if(message instanceof TextMessage) {
        		System.out.println("===============> OrderMessageService.onMessage() with a Text Message: " + ((TextMessage)message).getText());
        	}
        	else if(message instanceof ObjectMessage) {
        		System.out.println("==============> OrderMessageService.onMessage() with a Send Order Message.");
        		Orders.orders.add((Order)((ObjectMessage)message).getObject());
        	}
        	else {
        		System.out.println("===============> OrderMessageService.onMessage() with unknown message type");
        	}
        }
        catch(JMSException e) 
        {
        	e.printStackTrace();
        }
    }

}
