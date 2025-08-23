package liquide;

import calculation.VolumeConverter;
import calculation.VolumeConvertible;

// Item class implements methods from VolumeConvertible
public class Item implements VolumeConvertible{

	// attributes for Item class
	private String name;
	private double riskFactor;
	private double densityKgPerGallon;
	private double volumeInGallons;

	// Constructor for Item Class
	public Item(String name, double riskFactor, double densityKgPerGallon) {
		this.name = name;
		this.riskFactor = riskFactor;
		this.densityKgPerGallon = densityKgPerGallon;
	}

	// getting item name
	public String getName() {
		return this.name;
	}

	// getting risk factor
	public double getRiskFactor() {
		return this.riskFactor;
	}

	// getting density kg per gallonn
	public double getDensityKgPerGallon() {
		return this.densityKgPerGallon;
	}

	// getting volume in gallons
	public double getVolumeInGallons() {
		return this.volumeInGallons;
	}

	// user entered gallons for shipment, if value is not valid, return false
	public boolean setVolumeInGallons(double amountGallons) {
		if (amountGallons <= 0) {
			System.out.println("\n! ! ! ! ! ! ! ! ! ! ! ! !\nINVALID VALUE !!! PLEASE ENTER A VALUE GREATER THAN '0'\n! ! ! ! ! ! ! ! ! ! ! ! !\n");
			return false;
		} 
		
			this.volumeInGallons = amountGallons;
			return true;
		
	}

	
	// getting volume cubic meters by VolumeConverter method
	public double getVolumeCubicMeters() {
		VolumeConverter converter=new VolumeConverter();
		return converter.gallonsToCubicMeters(getVolumeInGallons());
	}

	// calculates weight kg
	public double calculateWeightKg() {
		return getVolumeInGallons() * getDensityKgPerGallon();
	}

	// printing item information
	public void printItemInfo() {
		
		if (getVolumeInGallons()==0) {
			System.out.println("*-*-*-*-*-* ITEM INFO -*-*-*-*-*-*" + "\nItem Name: " + getName() + "\nRisk Factor(%): "
					+ getRiskFactor() + "\n-----------------------------------\n");
		}
		else {
			System.out.println("\n*-*-*-*-*-* ITEM INFO -*-*-*-*-*-*");
			System.out.println("Item Name: " + getName());
			System.out.printf("Risk Factor(%%): %.2f\n",getRiskFactor());
			System.out.printf("Density (Kg/Gallon): %.2f\n", getDensityKgPerGallon());
			System.out.printf("Volume (Gallons): %.2f\n", getVolumeInGallons());
			System.out.printf("Volume (Cubic Meter): %.2f\n", getVolumeCubicMeters());
			System.out.printf("Weight (Kg): %.2f\n", calculateWeightKg());
			System.out.println("-----------------------------------\n");
		}

	}
}
