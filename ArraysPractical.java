/**
 * 
 */
package csc1025.prac6.part2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * @author student Ahmed
 * @version 13-11-2024
 */
public class ArraysPractical {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] stations = 
			{"Coleraine", "Ballymoney", "Cullybackey", "Ballymena", "Antrim", "Mossley", "West", "York Street", "Lanyon Place", "Botanic", "City Hospital", "Grand Central"};
		boolean checkAgain = true;
		
		screenTime();
		System.out.println("\n");
		treasureHunt();
		System.out.println("\n");
		printStations(stations);
		System.out.println("\n----------------------------------------------------");
		System.out.printf("The total number of \uD83D\uDE86 stations of this route are:  %d", (countStations(stations)));
		System.out.println("\n----------------------------------------------------");
		System.out.print("Would you like to check for a train station?(YES/NO): ");
		String repeat = scan.nextLine();
		
		while (repeat.equalsIgnoreCase("YES")) {
			System.out.print("Enter a train station to check if it's in the route(CASE SENSITIVE): ");
			String stationCheck = scan.nextLine();
			isStationPresent(stations, stationCheck);
			System.out.print("\nWould you like to check again?(YES/NO)*Case sensitive*: ");
			repeat = scan.nextLine();
		}
		String[] reversedStations = getReverseRoute(stations);
	    for (String station : reversedStations) {
	        System.out.println(station);
	    }
		scan.close();
	}

	public static void screenTime() {
		String[] weekDays = {"Monday","Tuesday","Wednesday", "Thursday", "Friday","Saturday", "Sunday"};
		int[] screenHours = {3,4,4,3,5,6,5};
		int i = 0;
		int totalHours = 0;
		System.out.print("Day        : Hours\n\n");
		for (String day : weekDays) {
			System.out.printf("%-10s : %d\n", day, screenHours[i]);
			totalHours += screenHours[i];
			i++;
		}
		System.out.printf("\nThe total screen time for the week %d hours.", totalHours);
		double dailyAvg = totalHours / (double)screenHours.length;
		System.out.printf("\nDaily average screen time is %.2f.\n", dailyAvg);
		
	    if (totalHours < 15) {
	        System.out.println("\nYou have a low screen time usage this week. Your device is collecting dust!");
	    } else if (totalHours <= 30) {
	        System.out.println("\nYour screen time usage is moderate this week. Balanced, as all things should be.");
	    } else {
	        System.out.println("\nD: Your screen time usage is high this week. Consider reducing it.");
	    }
	}
	
	
	public static void treasureHunt() {
	    Scanner scan = new Scanner(System.in);
	    boolean[][] treasureArray = new boolean[5][5];
	    int random = (int) (Math.random() * 6); // Adjust random range if needed

	    for (int i = 0; i < 5; i++) {
	        for (int j = 0; j < 5; j++) {
	            treasureArray[i][j] = false;
	        }
	    }
	    treasureArray[random][random] = true;

	    System.out.println("Hello, welcome to the treasure hunt game!");
	    System.out.println("Try to find the treasure by finding its co-ordinates on this 5x5 grid!");

	    for (int i = 0; i < 5; i++) {
	        System.out.println();
	        for (int j = 0; j < 5; j++) {
	            System.out.print("X ");
	        }
	    }

	    boolean treasureFound = false;
	    do {
	        try {
	            System.out.print("\n\nEnter Row (1-5): ");
	            int row = scan.nextInt();
	            System.out.print("\nEnter collumn (1-5): ");
	            int collumn = scan.nextInt();

	            // Validate input within bounds
	            if (row < 1 || row > 5 || collumn < 1 || collumn > 5) {
	                throw new IllegalArgumentException("Invalid input: Row and column must be between 1 and 5.");
	            }

	            if (treasureArray[row - 1][collumn - 1]) { // Access array using zero-based indexing
	                treasureFound = true;
	                System.out.println("\nCongratulations, you've found the treasure!");
	                System.out.printf("The treasure was found in row %d and collumn %d.\n", row, collumn);
	            } else {
	                System.out.println("Treasure not found, try again.");
	            }
	        } catch (IllegalArgumentException e) {
	            System.err.println("Error: " + e.getMessage());
	            System.out.println("Please enter a valid row and column within the specified range.");
	        } catch (InputMismatchException e) {
	            System.err.println("Error: Invalid input. Please enter integers only.");
	            scan.nextLine(); // Clear invalid input from scanner buffer
	        }
	    } while (!treasureFound);

	    // Display final treasure array (unchanged)
	    for (int i = 0; i < 5; i++) {
	        System.out.println();
	        for (int j = 0; j < 5; j++) {
	            if (i == random && j == random) {
	                System.out.print("T ");
	            } else {
	                System.out.print("X ");
	            }
	        }
	    }
	}
	public static void printStations(String[] stations) {
		System.out.println("The \uD83D\uDE86 stations along the route are below.\n");
		for (int i = 0; i<stations.length; i++) {
			System.out.println(stations[i]);
		}
	}
	public static int countStations(String[] stations) {
		return stations.length;
		
	}
	public static boolean isStationPresent(String[] stations, String stationName) {
		for (String station : stations) {
			if (station.equals(stationName)) {
				System.out.printf("\n\uD83D\uDE86Station %s is available.\n", stationName);
				return true;
			}
		}
		System.out.printf("\n\uD83D\uDE86Station %s is not available.\n", stationName);
		return false;
	}
	public static String[] getReverseRoute(String[] stations) {
		System.out.println("\n\n----------------------------------------");
		System.out.println("Here are the \uD83D\uDE86 stations in reverse order\n");
		int size = stations.length;
		String[] reverseStations = new String[size];
	    for (int i = 0; i < size; i++) {
	        reverseStations[i] = stations[size - i - 1];
	    }
	    return reverseStations;
	}
	
}
