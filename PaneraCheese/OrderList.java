//Olivia Cheung
//893664790

package PaneraCheese;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 
import java.text.SimpleDateFormat;

public class OrderList extends Order {
		
	protected Queue<Order> paneraQueue = new LinkedList<>();
	Scanner scan = new Scanner(System.in);
	
//adding order to queue
	public void addOrder() {
		
		System.out.println("Enter your order description:");
		String order = scan.nextLine();
		
		System.out.println("Enter customer name:");
		String name = scan.nextLine();
	
	//I didn't know how to do this part since it wasn't taught in class 
	//I know that it takes the date and formats it down to the time 
		java.util.Date date = new java.util.Date(); 
		SimpleDateFormat timeStamp = new SimpleDateFormat("HH:mm:ss");
		
		Order constructor = new Order(name, order, timeStamp.format(date));
		
		paneraQueue.add(constructor);
	}
//lists out all the orders in the queue	
	public void listOrders() {
		
		if (paneraQueue.size() > 0) {
		

			System.out.printf("%-10s %-10s %-10s\n", "Name" ,"Order", "Time");
			System.out.printf("%-10s\n", "-------------------------------------------------");
			
			for (Order n : paneraQueue) {
					
			
				System.out.printf("%-10s %-10s %-10s\n", n.Name, n.Order, n.TimeStamp); 
			}
		
		}
		
		else if (paneraQueue.size() <= 0) {
			
			System.out.println("There's no more pending orders. I stayed at PFT for 12 hours just to make sure the senior design teams are defeated by a bunch of freshmen and sophmores. I am dead.");
		    
		}
	}

//shows what's the next order to be served
	public void serveNextOrder() {
		
		Order nextOrder = paneraQueue.peek();
		
		System.out.printf("Now serving ... %-10s %-10s %-10s\n", nextOrder.Name, nextOrder.Order, nextOrder.TimeStamp);
		paneraQueue.poll();
	}

//cancels the order
	public void cancelOrder() {
	
	if (paneraQueue.size() > 0) {
		System.out.println("Enter customer name:");
		String pullOut = scan.nextLine();
		
		System.out.println(pullOut + "'s order has been removed");
		
		for (Order n : paneraQueue) {
			
			if (pullOut.equals(n.Name)) {
				
				paneraQueue.remove(n);
			}
		}
		
		
	}
	
	else {
		
		System.out.println("There's no more pending orders. I stayed at PFT for 12 hours just to make sure the senior design teams are defeated by a bunch of freshmen and sophmores. I am dead.");
	}
		
	}

}
