package guessing_game_1;

import java.util.Random;
import java.util.Scanner;

public class TryToGuess {

	public static void main(String[] args) {
		
		try {
			guessing();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	static void guessing () {
		
		Scanner scan = new Scanner (System.in);
		int range = 100;
		int numberChosen  =  randomNumber(range);
		boolean win = false;
		System.out.println("Try to guess the number from 0 to 100!");
		
		while (!scan.hasNextInt()) {
			System.out.println("It's not a number! Try again.");
			scan.next();
		}	
		
		while (win == false) {
			
			int numberGuessed = scan.nextInt(); //value from user
		
			if ( numberGuessed > 100 || numberGuessed < 0 ) {
				System.out.println("Typed value is out of range, try again!");
			} else if (numberGuessed == numberChosen) {
				System.out.println("You guessed the right number!");
				win = true;
				scan.close();
		
			} else if (numberGuessed < numberChosen) {
				System.out.println("Your number is too low, try again!");
				
			} else if (numberGuessed > numberChosen) {
				System.out.println("Your number is too high, try again!");
			}
		}
		scan.close();
	}	
	
    static int randomNumber (int range) {
    	
    	Random rand = new Random();
    	int number = rand.nextInt(range) + 1;
    	return number;
    	
    }
}

