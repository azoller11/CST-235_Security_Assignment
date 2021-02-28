package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;

@ManagedBean
@LocalBean
public class Orders {
	
	public static List<Order> orders = new ArrayList<Order>();
	
	
	
	public Orders() {
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

	
	
	public List<Order> getOrder() {
		return orders;
	}

	public void setOrder(List<Order> order) {
		this.orders = order;
	}

	
}
