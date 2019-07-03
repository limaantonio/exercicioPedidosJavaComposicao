package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy : HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	
	List<OrderItem> itens = new ArrayList();
	Client client;
	
	
	public Order() {
		
	}
	public Order(Date moment, OrderStatus status,  Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void addItem(OrderItem item) {
		itens.add(item);
	}
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	public double total() {
		double total = 0;
		for(OrderItem item : itens) {
			total += item.subTotal();
		}
		return total;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order moment: ");
		builder.append(sdf.format(moment)+"\n");
		builder.append("Order status: ");
		builder.append(status+"\n");
		builder.append("Client: ");
		builder.append(client+"\n");
		builder.append("Order items: \n");
		for(OrderItem item : itens) {
			builder.append(item + "\n");
		}
		builder.append("Total price: $");
		builder.append(String.format("%.2f",total()));
		return builder.toString();
	}
}
