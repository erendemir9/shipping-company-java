package distance;

// class shipping city
public class ShippingCity {
	
	// attributes for class shipping city
	private String cityName;
	private double distanceKm;
	
	// constructor for shipping city
	public ShippingCity(String cityName,double distanceKm) {
		this.cityName=cityName;
		this.distanceKm=distanceKm;
	}
	
	// getting city name
	public String getCityName() {
		return this.cityName;
	}
	
	// getting distance km to Hamburg
	public double getDistanceKm() {
		return this.distanceKm;
	}
	
	// printing city information
	public void printCityInfo() {
		System.out.println("*-*-*-*-*-* SHIPPING CITY -*-*-*-*-*-*");
		System.out.println("City: "+getCityName()+
				"\nDistance to Hamburg: "+getDistanceKm()+" KM");
		System.out.println("------------------------------------------");
	}
}
