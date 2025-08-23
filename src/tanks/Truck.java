package tanks;

import java.lang.Math;

import calculation.VolumeConverter;
import calculation.VolumeConvertible;

// Abstract Base Truck class implements methods from VolumeConvertible interface
public abstract class Truck implements VolumeConvertible {

	// attributes for Truck class
	private String type;
	private double lengthInches;
	private double radiusInches;
	private VolumeConverter converter;

	// Constructor for Truck class
	public Truck(String type, double lengthInches, double radiusInches) {
		this.type = type;
		this.lengthInches = lengthInches;
		this.radiusInches = radiusInches;
		this.converter = new VolumeConverter();
	}

	// getting type
	public String getType() {
		return type;
	}

	// getting length inches
	public double getLengthInches() {
		return lengthInches;
	}

	// getting radius inches
	public double getRadiusInches() {
		return radiusInches;
	}

	// printing truck info
	public void printTruckInfo() {
		System.out.println(" *-*-*-*-*-* TRUCK INFO -*-*-*-*-*-*");
		System.out.println("Truck Type        : " + getType());
		System.out.printf("Length (Inches)   : %.2f\n", getLengthInches());
		System.out.printf("Radius (Inches)   : %.2f\n", getRadiusInches());
		System.out.printf("Volume (Gallons)  : %.2f\n", getVolumeInGallons());
		System.out.printf("Volume (Cubic Inches)    : %.2f\n", calculateVolume());
		System.out.printf("Volume (Cubic Meters)       : %.2f\n", getVolumeCubicMeters());
		System.out.println("-----------------------------------");
	}

	// calculate maximum volume of truck in cubic inches
	public double calculateVolume() {
		return Math.PI * getRadiusInches() * getRadiusInches() * getLengthInches(); // Cubic Inches - inch3
	}

	/*
	 * override method from volumeConvertible interface converting maximum volume to
	 * the gallons by using VolumeConverter class
	 */
	@Override
	public double getVolumeInGallons() {
		return this.converter.cubicInchesToGallon(calculateVolume()); // Gallons
	}

	/*
	 * override method from volumeConvertible interface converting maximum volume to
	 * the cubic meters by using VolumeConverter class
	 */
	@Override
	public double getVolumeCubicMeters() {
		return this.converter.cubicInchesToCubicMeters(calculateVolume()); // Cubic Meter
	}

}
