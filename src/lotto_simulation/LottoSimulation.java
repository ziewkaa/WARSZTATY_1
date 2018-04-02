package lotto_simulation;

import java.util.*;

public class LottoSimulation {
	
	public static void main(String[] args) {
		
		try {
			simulation();
		} catch (Exception e ) {
			System.out.println("Error occured: " + e.getMessage());
		}
		
	}

	static void simulation () throws Exception {

		String typed = "";
		int[] randomArray = arrayOfRandoms();
		HashSet<Integer>  typedNumbers = new HashSet<Integer>();

		Scanner scan = new Scanner (System.in);
		System.out.println("Type 6 lucky numbers from 1 to 49!");
			
		while (typedNumbers.size() < 6) {
			typed = scan.nextLine();
			int letterError = 0;
			int rangeError = 0;
			
			for (String value : typed.split(" ")) {
				try {
					int typedValue = Integer.parseInt(value);
					if ( typedValue < 50 && typedValue > 0  ) {
						typedNumbers.add(typedValue);
					} else {
						rangeError++;
					}
				} catch (Exception e) {
					letterError++;
				}
			}
			checkTypedValues(typedNumbers, letterError, rangeError);
		}
		
		int guessedNumbers = compareNumbers(randomArray, typedNumbers);
		
			if (guessedNumbers > 0) {
				checkIfWon(guessedNumbers);
			} else {
				System.out.println("No luck this time, try again!");
			}
			
		scan.close();
	}
	
	public static void checkTypedValues(HashSet<Integer> typedNumbers, int letterError, int rangeError) {
		
		if (letterError > 0) {
			System.out.println("Some values are not numbers");
		}
		if (rangeError > 0) {
			System.out.println("Some values are out of range");
		}
		if (typedNumbers.size() < 6) {
			int typedSize = 6 - typedNumbers.size();
			System.out.println("Type " + typedSize + " more number(s)");
		}
	}
	
	static int[] arrayOfRandoms () {
		
		//creates array of 49 numbers
		Integer[] arrayOfNumbers = new Integer[49];
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			arrayOfNumbers[i] = i + 1;
		}
		// shuffles array as arraylist
		int counter = 0;
		List<Integer> shuffledArray = Arrays.asList(arrayOfNumbers);
		Collections.shuffle(shuffledArray);	
		int[] finalArray = new int[6];
		
		//pushes random numbers to final array
		for (int number : shuffledArray) {
			finalArray[counter] = number;
			if(counter == 5) {
				break;
			} else {
				counter++;
			}
		}
		
		Arrays.sort(finalArray);
		return finalArray;
		
	}
	
	public static int compareNumbers (int[] randomArray, HashSet<Integer> typedNumbers) {
		
		int counter = 0;
		for (int guessedNumber : typedNumbers) {
			for (int givenRandom : randomArray) {
				if (guessedNumber == givenRandom) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static void checkIfWon(int counter) {
		
		switch (counter) {
		case 3:
			System.out.println("You've guessed 3 !");
			break;
		case 4:
			System.out.println("You've guessed 4 !");
			break;
		case 5:
			System.out.println("You've guessed 5 !");
			break;
		case 6:
			System.out.println("Lotto ! Yoy've guessed all 6 numbers!");
			break;
		}
	}
}

