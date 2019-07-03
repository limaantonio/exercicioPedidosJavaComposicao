package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date dateBirth = sdf.parse(sc.next());
		
		Client client = new Client(name,email,dateBirth);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		
		Order order = new Order(new Date(),OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.printf("Enter #%d item data:",i);
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			
			Product product = new Product(nameProduct, price);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, price, product);
			
			order.addItem(orderItem);
			
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		

	}
}
