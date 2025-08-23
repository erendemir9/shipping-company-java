package distance;

import java.util.ArrayList;
import java.util.List;

// cities class
public class Cities {
	
	// citylist attribute to save cities
	private List<ShippingCity> cityList;

	// constructor for cities
	public Cities() {
		this.cityList = new ArrayList<ShippingCity>();
		defaultCities();
	}

	// adding the default cites to the city list
	public void defaultCities() {
		cityList.add(new ShippingCity("Berlin", 252));
		cityList.add(new ShippingCity("München", 612));
		cityList.add(new ShippingCity("Leipzig", 294));
		cityList.add(new ShippingCity("Dresden", 377));
		cityList.add(new ShippingCity("Köln", 357));
		cityList.add(new ShippingCity("Rome", 1309));
		cityList.add(new ShippingCity("Paris", 746));
		cityList.add(new ShippingCity("Wien", 743));
		cityList.add(new ShippingCity("Madrid", 1787));
	}

	// getting cities in the city list
	public List<ShippingCity> getCities() {
		return this.cityList;
	}

	// adding new city after the adding controls to the city list
	public void addCityToList(String name, double distanceKm) {
		cityList.add(new ShippingCity(name, distanceKm));
	}

	// control while adding new city, if city already exist in the database return false
	public boolean cityExists(String cityName) {
		for (ShippingCity c : getCities()) {
			if (c.getCityName().equalsIgnoreCase(cityName)) {
				return true;
			}
		}
		return false;
	}

	// printing all city information
	public void printAllCities() {
		for (ShippingCity c : getCities()) {
			c.printCityInfo();
		}
	}
	
	// getting city by name
	public ShippingCity getCityByName(String name) {
	    for (ShippingCity c : cityList) {
	        if (c.getCityName().equalsIgnoreCase(name)) {
	            return c;
	        }
	    }
	    return null;
	}
}
