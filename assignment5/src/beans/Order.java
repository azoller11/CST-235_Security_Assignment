package beans;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean
@ViewScoped
@Model
@XmlRootElement(name = "Order")
public class Order implements Serializable {
	
	
	String orderNo = "";
	String productName = "";
	float price = 0;
	int quantity = 0;
	
	public Order() {}
	
	public Order(String orderNo, String productName, float price, int quantity) {
		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
	

}
