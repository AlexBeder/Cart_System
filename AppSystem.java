package com.example;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        // Your code here
    	System.out.println("AppSystem Inventory:");
    	String heading1 = "Name";
		String heading2 = "Description";
		String heading3 = "Price";
		String heading4 = "Available Quantity";

		System.out.printf("%-20s %-20s %-10s %-10s %n", heading1, heading2, heading3, heading4);
    	
    	
    	for (Item item : getItemCollection().values()) {
    		System.out.printf("%-20s %-20s %-10s %-10s %n", item.getItemName(), item.getItemDesc(), item.getItemPrice().toString(), item.getAvailableQuantity().toString());
    	}
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        // Your code here
    	if (item == null) {
			return false;
    	} else if (getItemCollection().containsKey(item.getItemName())) {
			System.out.println(item.getItemName() + " is already in the App System");
			return false;
		} else if (!getItemCollection().containsKey(item.getItemName())) {
			getItemCollection().put(item.getItemName(), item);
			return true;
		}
		return false;
    }

    public Item reduceAvailableQuantity(String itemName) {
        // Your code here
    	Item item = getItemCollection().get(itemName);
    	if (getItemCollection().containsKey(itemName)) {
    	item.setAvailableQuantity(getItemCollection().get(itemName).getAvailableQuantity() - 1);
		return item;				
		}
		return null;	
    }
}
