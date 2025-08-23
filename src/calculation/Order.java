package calculation;

import java.util.ArrayList;
import java.util.List;

import distance.ShippingCity;
import liquide.Item;
import tanks.Truck;

public class Order {

	// attributes for Order Class
	private Item item;
	private ShippingCity destination;
	private List<Truck> selectedTrucks = new ArrayList<Truck>();
	private double shippingCost;

	// constructor for order class
	public Order(Item item, ShippingCity destination) {
		this.item = item;
		this.destination = destination;
	}

	// getting item of order
	public Item getItem() {
		return this.item;
	}

	// getting destination of order
	public ShippingCity getDestination() {
		return this.destination;
	}

	// havent used yet
	public List<Truck> getSelectedTrucks() {
		return selectedTrucks;
	}

	// adding selected trucks to the order 
	public void setSelectedTrucks(List<Truck> selectedTrucks) {
		this.selectedTrucks = selectedTrucks;
	}

	// getting shipping cost
	public double getShippingCost() {
		return this.shippingCost;
	}

	// setting shipping cost
	public void setShippingCost(double cost) {
		this.shippingCost = cost;
	}

	// printing order information
	public void printOrderInfo() {
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("-_-_-_-_- ORDER INFORMATION -_-_-_-_- ");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
		new Calculation().printItem(getItem());

		System.out.println("*-*-*-*-*-* DESTINATION INFO -*-*-*-*-*-*");
		System.out.println("Destination: " + getDestination().getCityName());
		System.out.printf("Distance from Hamburg: %.2f km\n", getDestination().getDistanceKm());
		System.out.println("-----------------------------------\n");

		System.out.println("*-*-*-*-*-* SELECTED TRUCKS FOR YOUR SHIPMENT -*-*-*-*-*-*");
		for (Truck t : getSelectedTrucks()) {
			System.out.println("Truck Type: " + t.getType());
			System.out.printf("Max Capacity: %.2f Gallons.\n", t.getVolumeInGallons());
			System.out.printf("Max Capacity: %.2f Cubic Meters\n", t.getVolumeCubicMeters());
			System.out.println("****************");
		}

		System.out.println("*-*-*-*-*-* TOTAL SHIPPING COST -*-*-*-*-*-*");
		System.out.printf("%.2f EURO\n", getShippingCost());
		System.out.println("--------------------------------------------------------------------------------------");

	}

}
