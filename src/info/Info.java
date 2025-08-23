package info;

public class Info {

	private String name;
	private String creationDate;
	private int totalNumberLineOfCodes;

	public Info() {
		this.name = "Halil Eren Demir";
		this.creationDate = "01.06.2025";
		this.totalNumberLineOfCodes = 847;
	}

	public String getName() {
		return this.name;
	}

	public String getCreationDate() {
		return this.creationDate;
	}

	public int getTotalNumberLineOfCodes() {
		return this.totalNumberLineOfCodes;
	}

	public void printMyInfo() {
		System.out.println("Name: " + getName() + "\nCreation Date: " + getCreationDate() +
				"\nTotal Number Line Of Codes: " + getTotalNumberLineOfCodes() + "\n");

	}

}
