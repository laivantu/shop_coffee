package form;

import java.util.List;

import entities.DataOrder;
import entities.DataOrderDetail;


public class OrderForm {

	private DataOrder order;
	private List<DataOrderDetail> orderDetails;
	
	
	public DataOrder getOrder() {
		return order;
	}
	public void setOrder(DataOrder order) {
		this.order = order;
	}
	public List<DataOrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<DataOrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
