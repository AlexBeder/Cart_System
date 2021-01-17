package com.example;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

    @Override
    public void display() {
        // Your code here
    	double sum = 0.0;
    	
    	System.out.println("App System Inventory:");
    	String heading1 = "Name";
		String heading2 = "Description";
		String heading3 = "Price";
		String heading4 = "Quantity";
		String heading5 = "Sub Total";

		System.out.printf("%-20s %-20s %-10s %-10s %-10s %n", heading1, heading2, heading3, heading4, heading5);
    	
    	
    	for (Item item : getItemCollection().values()) {
    		Double subTotal = item.getItemPrice() * item.getQuantity();
    		System.out.printf("%-20s %-20s %-10s %-10s %-10s %n", item.getItemName(), item.getItemDesc(), item.getItemPrice().toString(), item.getAvailableQuantity().toString(), subTotal.toString());
    		sum += item.getItemPrice();
    	}
    	
    	
    	System.out.println(String.format("Sub total: %.2f", sum));
		System.out.println(String.format("Tax: %.2f", sum*0.05));
		System.out.println(String.format("Total: %.2f", sum+(sum*0.05)));
	}
    
}
