package iceCream;

import java.util.Random;
import java.util.Scanner;

public class IceCream {
	Scanner sc = new Scanner(System.in);

	// Method for determining number of customers and type of orders
	public void customer() {
		Random ran = new Random();
		int customers = ran.nextInt(4) + 1;

		for (int i = 0; i < customers; i++) {
			int scoopsWanted = scoopAmount();
			String flavorPicked = flavorChoice();
			System.out.println("I want " + scoopsWanted + " scoops of " + flavorPicked + " flavor ice cream please.");
			giveOrder(scoopsWanted, flavorPicked);
		}
	}

	// Method to make number of scoops
	public int scoopAmount() {
		Random ran = new Random();
		int scoops;
		scoops = ran.nextInt(3) + 1;
		return scoops;
	}

	// Method for setting the flavors
	public String flavorChoice() {
		Random ran = new Random();

		String[] flavors = { "vanilla", "chocolate", "strawberry" };
		int arrayLength = flavors.length;

		int flavor = ran.nextInt(arrayLength);
		String pick = flavors[flavor];
		return pick;
	}

	// Method for returning customer order
	public void giveOrder(int scoopsWanted, String flavorPicked) {

		int scoopsGiven = 0;
		boolean check = true;
		while (check) {
			sc = new Scanner(System.in);
			System.out.println("How many number of scoops?");
			if (sc.hasNextInt()) {
				scoopsGiven = sc.nextInt();
				check = false;
			} else {
				System.out.println("That is not a number. Enter the number of scoops.");
			}
		}

		System.out.println("You give " + scoopsGiven + " scoops.");
		System.out.println("What flavor does the customer want?");
		String pickFlavor = sc.next();
		System.out.println("You give " + pickFlavor + " flavor.");

		if (checkOrder(scoopsWanted, flavorPicked, pickFlavor, scoopsGiven) == true) {
			System.out.println("You filled the customer order correctly.");
			System.out.println();
		} else {
			System.out.println("You got the customer order wrong.");
			System.out.println();
		}

	}

	// Boolean to check if you processed the order correctly
	public boolean checkOrder(int scoopsWanted, String flavorPicked, String pickFlavor, int scoopsGiven) {
		if (scoopsGiven == scoopsWanted && (pickFlavor.equalsIgnoreCase(flavorPicked) == true)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		IceCream obj = new IceCream();
		obj.customer();
		obj.sc.close();
	}

}
