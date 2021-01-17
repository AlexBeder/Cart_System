package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
	private HashMap<String, Item> itemCollection;

	TheSystem() {
		// Your code here
		itemCollection = new HashMap<String, Item>();

		try {
			if (getClass().getSimpleName().equals("AppSystem")) {
				Scanner scanner = new Scanner(new File("resources\\sample.txt"));
				while (scanner.hasNextLine()) {
					String[] itemInfo = scanner.nextLine().split("\s ");
					Item item = new Item();
					item.setItemName(itemInfo[0]);
					item.setItemDesc(itemInfo[1]);
					item.setItemPrice(Double.valueOf(itemInfo[2]));
					item.setAvailableQuantity(Integer.valueOf(itemInfo[3]));
					itemCollection.put(item.getItemName(), item);
				}
				scanner.close();
			} else
				itemCollection = new HashMap<String, Item>();
		} catch (Exception e) {
			System.out.println("error");
			e.getMessage();
		}
	}

	// SETTER
	public void setItemCollection(HashMap<String, Item> itemCollection) {
		this.itemCollection = itemCollection;
	}

	// GETTER
	public HashMap<String, Item> getItemCollection() {
		return itemCollection;
	}

	public Boolean checkAvailability(Item item) {
		// Your code here
		if (item.getQuantity() >= item.getAvailableQuantity()) {
			System.out.println(" System is unable to add " + item.getItemName() + " to the card." + "System only has "
					+ item.getAvailableQuantity() + " " + item.getItemName());
			return false;
		} else
			return true;

	}

	public Boolean add(Item item) {
		// Your code here
		if (item == null) {
			return false;
		} else if (itemCollection.containsKey(item.getItemName()) && checkAvailability(item) == true) {
			item.setQuantity(item.getQuantity() + 1);
			return true;
		} else if (!itemCollection.containsKey(item.getItemName())) {
			itemCollection.put(item.getItemName(), item);
			return true;
		}
		return false;
	}

	public Item remove(String itemName) {
		// Your code here
		if (itemCollection.containsKey(itemName)) {
			return itemCollection.remove(itemName);			
		}
		return null;	
	}

	public abstract void display();
}
