package calculation;

import java.util.ArrayList;
import java.util.List;
import liquide.Item;
import liquide.ItemCatalog;
import tanks.LargeTruck;
import tanks.MediumTruck;
import tanks.SmallTruck;
import tanks.Truck;

public class Calculation {
	
	// attributes for the calculation class
	private List<Order> orders;
	private List<Truck> truckList;
	private List<Item> itemList;

	// Calculation class constructor. Creates a default list for items,trucks and orders.
	public Calculation() {
		this.itemList = new ArrayList<Item>();
		this.truckList = new ArrayList<Truck>();
		this.orders = new ArrayList<Order>();
		defaultTrucks();
	}

	// Adding default trucks to the truck list when the calculation class called
	public void defaultTrucks() {
		truckList.add(new SmallTruck());
		truckList.add(new MediumTruck());
		truckList.add(new LargeTruck());
	}

	// getting orders
	public List<Order> getOrders() {
		return orders;
	}

	// getting truck list
	public List<Truck> getTruckList() {
		return truckList;
	}

	// Getting item list
	public List<Item> getItemList() {
		return itemList;
	}

	// Printing default items
	public void printItemList() {
		new ItemCatalog().printAllItems();
	}
	
	// Printing default trucks
	public void printDefaultTrucks() {
		for (Truck t:truckList) {
			t.printTruckInfo();
		}
	}

	// Add item
	public void addItem(Item item) {
		this.itemList.add(item);
	}

	// Add default items
	public void addItems() {
		ItemCatalog items = new ItemCatalog();

		for (Item i : items.getAllItems()) {
			addItem(i);
		}
	}

	// Add new order
	public void addOrder(Order order) {
		orders.add(order);
	}

	
	// printing item info 
	public void printItem(Item item) {
		item.printItemInfo();
	}

	// printing order info
	public void printOrder(Order order) {
		order.printOrderInfo();
	}

	
	// the item's total volume in gallons
	public double totalVolumeInGallons(Item item) {
		return item.getVolumeInGallons();
	}

	// the item's total volume in cubic meters
	public double totalVolumeInCubicMeters(Item item) {
		return item.getVolumeCubicMeters();
	}

	// the item's total weight kg
	public double totalWeight(Item item) {
		return item.calculateWeightKg();
	}

	// finding the best shipping 
	public List<Truck> bestShipping(Item item) {
		List<Truck> selectedTrucks = new ArrayList<Truck>();
		double requiredVolume = item.getVolumeInGallons();

		Truck smallTruck = new SmallTruck();
		Truck mediumTruck = new MediumTruck();
		Truck largeTruck = new LargeTruck();

		if (smallTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(smallTruck);
		}

		else if (mediumTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(mediumTruck);

		}

		else if (largeTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(largeTruck);
		}

		else if (largeTruck.getVolumeInGallons() + smallTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new SmallTruck());
		}

		else if (largeTruck.getVolumeInGallons() + mediumTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new MediumTruck());

		}

		else if (2 * largeTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new LargeTruck());

		}

		else if (2 * largeTruck.getVolumeInGallons() + smallTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new SmallTruck());

		}

		else if (2 * largeTruck.getVolumeInGallons() + mediumTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new MediumTruck());

		}

		else if (3 * largeTruck.getVolumeInGallons() >= requiredVolume) {
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new LargeTruck());
			selectedTrucks.add(new LargeTruck());

		}

		return selectedTrucks;
	}

	// calculates the shipping price a order
	public double shippingPrice(Order order) {
		double gallons = order.getItem().getVolumeInGallons();
		double distance = order.getDestination().getDistanceKm();
		double riskFactor = order.getItem().getRiskFactor();

		double mainTransportationCost = gallons * distance * 0.01;
		double additionalCostWithRisk = mainTransportationCost * (riskFactor / 100.0);
		double returnToHamburgCost = distance * 0.6;

		return mainTransportationCost + additionalCostWithRisk + returnToHamburgCost;
	}

	// printing all orders in the order list
	public void printAllOrders() {
		for (Order o : orders) {
			printOrder(o);
		}
	}

	// getting item by name in the item list
	public Item getItemByName(String name) {
		ItemCatalog items = new ItemCatalog();
		return items.getItemByName(name);
	}
}
