package calculation;

public class VolumeConverter {

	// gallons to cubic meters
	public double gallonsToCubicMeters(double gallons) {
		return gallons * 0.00378541188;
	}

	// cubic meters to gallons
	public double cubicMetersToGallons(double cubicMeters) {
		return cubicMeters / 0.0037854118;
	}

	// cubic inches to gallons
	public double cubicInchesToGallon(double inch3) {
		return inch3 / 231.0;
	}

	// cubic inches to cubic meters
	public double cubicInchesToCubicMeters(double inch3) {
		return inch3 / 61023.7;
	}
}
