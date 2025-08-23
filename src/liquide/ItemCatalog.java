package liquide;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {
	private List<Item> items;
	
	// constructor for ItemCatalog class
	public ItemCatalog() {
		this.items=new ArrayList<Item>();
		defaultItems();
	}
	
	// adding the default items to the item lsit 
	public void defaultItems() {
		items.add(new Item("Oxygen (O2)", 17, 4.321));
		items.add(new Item("Hydrogen (H2)",18,0.5906));
		items.add(new Item("Nitrogen (N2)", 2, 3.06));
		items.add(new Item("Propene", 20, 2.3));
		items.add(new Item("Carbon Dioxide (CO2)", 10, 3.842));
		items.add(new Item("Methane", 18, 2.84));
		items.add(new Item("Benzene (Super E95)", 20, 2.93));
		items.add(new Item("Benzene (Super)", 20, 2.8));
		items.add(new Item("Water", 0, 3.785));
		items.add(new Item("Milk", 0, 3.95));
	}
	
	// getting all items in the item list
	public List<Item> getAllItems(){
		return this.items;
	}
	
	// getting item by name, if item user entered item name is wrong return null to control the correction
	public Item getItemByName(String name) {
		for(Item i:getAllItems()) {
			if(i.getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return null;
	}
	
	// printing all items' info
	public void printAllItems() {
		for(Item i:getAllItems()) {
			i.printItemInfo();
		}
	}
}
