package main;

import tanks.*;
import java.util.Scanner;
import java.util.List;
import calculation.*;
import distance.*;
import info.Info;
import liquide.*;

// Class which includes all the menu and user panel which called in the Main class
public class ShippingApp {

	// attributes for shippingApp class
	private Calculation calculation;
	private Cities cities;
	private Scanner scanner;

	// constructor for shipping app class
	public ShippingApp() {
		this.calculation = new Calculation();
		this.cities = new Cities();
		this.scanner = new Scanner(System.in);
		calculation.addItems();
	}

	// run method for calling in the Main class, and show the menu and do everything.
	public void run() {
		printMyInformation();
		System.out.println("WELCOME TO THE SHIPPING COMPANY APPLICATION..");
		boolean running = true;

		do {
			
			
			printShippingMenu();

			System.out.print("Your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				calculation.printItemList();
				break;

			case 2:
				cities.printAllCities();
				break;

			case 3:
				createOrder();
				break;

			case 4:
				if (calculation.getOrders().isEmpty()) {
					System.out.println("\nNo order in the system !!!");
				} else {
					calculation.printAllOrders();
				}
				break;

			case 5:addNewCity(); break;
			case 6: calculation.printDefaultTrucks(); break;
			case 0: System.out.println("Exiting the program..."); running=false; break;
			default:
				System.out.println("Invalid option !!!!");
			}

		} while (running);
	}

	// Creating new order
	public void createOrder() {
		System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("-_-_-_-_-_- ITEM LIST -_-_-_-_-_-_- ");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
		calculation.printItemList();
		System.out.print(
				"\n************************\nPlease enter an item name from the item list above.. \n\n************************\nYour Choice: ");
		String iChoice = scanner.nextLine();

		Item selectedItem;
		selectedItem = calculation.getItemByName(iChoice);
		while (selectedItem == null) {
			System.out.print(
					"\n! ! ! ! ! ! ! ! ! ! ! ! !\nINVALID ITEM NAME. PLEASE TYPE IT CORRECTLY (Example -> Oxygen (o2) <-)\n! ! ! ! ! ! ! ! ! ! ! ! !\nYour Choice:");
			iChoice = scanner.nextLine();
			selectedItem = calculation.getItemByName(iChoice);
		}

		System.out.print("Enter the amount (in gallons): ");
		double gallons = scanner.nextDouble();
		scanner.nextLine();

		while (!selectedItem.setVolumeInGallons(gallons)) {
			System.out.print("Enter the amount (in gallons)(Greater than 0) correctly: ");
			gallons = scanner.nextDouble();
			scanner.nextLine();
		}

		System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("-_-_-_-_-_- CITY LIST -_-_-_-_-_-_- ");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
		cities.printAllCities();
		System.out.print(
				"\n************************\nPlease enter a city name from the list above for the destination. \n************************\nYour Choice: ");

		String cityChoice = scanner.nextLine();

		ShippingCity selectedCity;
		selectedCity = cities.getCityByName(cityChoice);
		while (selectedCity == null) {
			System.out.print(
					"! ! ! ! ! ! ! ! ! ! ! ! !\nINVALID CITY NAME. PLEASE TYPE IT CORRECTLY\n! ! ! ! ! ! ! ! ! ! ! ! !\nYour Choice:");
			cityChoice = scanner.nextLine();
			selectedCity = cities.getCityByName(cityChoice);
		}

		List<Truck> bestTrucks = calculation.bestShipping(selectedItem);
		Order newOrder = new Order(selectedItem, selectedCity);
		newOrder.setSelectedTrucks(bestTrucks);
		newOrder.setShippingCost(calculation.shippingPrice(newOrder));

		calculation.addOrder(newOrder);
		System.out.println("\n**************** ORDER CREATED SUCCESSFULLY ****************\n");

		calculation.printOrder(newOrder);
	}
	
	
	// Printing my info from the Info class
	public void printMyInformation() {
		new Info().printMyInfo();
	}
	
	// Printing The Shipping Menu
	public void printShippingMenu() {
		System.out.println("\n============ SHIPPING COMPANY MENU ============\n" + "1- Show All Items\n" + "2- Show All Cities\n"
				+ "3- Create New Order\n" + "4- Show All Orders\n" +"5- Add A New City\n"+"6- Show All Trucks\n"+ "0- Exit");
		System.out.println("-------------------------------------------");
	}
	
	// Adding new city user wanted to the cities, if city already exist, dont add it
	public void addNewCity() {
		System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("-_-_-_-_-_- CURRENT CITY LIST -_-_-_-_-_-_- ");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
		cities.printAllCities();
		
		System.out.print(
				"\n************************\nPlease enter a new city name that is not on the list above. \n************************\nYour Choice: ");
		String newCityName=scanner.nextLine();
		
		
		while(cities.cityExists(newCityName)) {
			System.out.print("! ! ! ! ! ! ! ! ! ! ! ! !\nTHIS CITY ALREADY EXISTS IN OUR DATABASE. PLEASE ENTER ANOTHER NAME\n! ! ! ! ! ! ! ! ! ! ! ! !\nYour Choice:");
			newCityName=scanner.nextLine();
		}
		
		System.out.print(
				"\n************************\nPlease enter the distance KM of the new city to Hamburg. \n************************\nYour Choice: ");
		double newCityDistance=scanner.nextDouble();
		scanner.nextLine();
		
		while (newCityDistance<=0) {
			System.out.print(
					"\n! ! ! ! ! ! ! ! ! ! ! ! !\nINVALID DISTANCE KM. PLEASE ENTER IT GREATER THAN '0' \n! ! ! ! ! ! ! ! ! ! ! ! ! \nYour Choice:");
			newCityDistance=scanner.nextDouble();
			scanner.nextLine();
		}
		
		cities.addCityToList(newCityName, newCityDistance);
		
		System.out.println("\n**************** NEW CITY ADDED SUCCESSFULLY TO THE CITY LIST ****************\n");
		
		System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("-_-_-_-_-_- NEW CITY LIST -_-_-_-_-_-_- ");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n");
		cities.printAllCities();
		
	}
}
