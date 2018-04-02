package guessing_game_2;

import java.util.Scanner;

public class GuessMyNumber {

	public static void main(String[] args) {
		
		guessing();
		
	}
	
	static void guessing () {
		
		Scanner scan = new Scanner (System.in);
		System.out.println ("Think about a number from 1 to 1000, and I'll try to guess !");
		int round = 0;
		int max = 1000;
		int min = 0;
		int guess = ((max - min)/2) + min;
		
		String tooMuch = "too much";
		String notEnough = "not enough";
		String right = "right";
		
		System.out.println("I'm guessing it's " + guess);
		String answer = "";
		
		while (round < 10) {
			answer = scan.nextLine(); // takes some value
			
			if (answer.toLowerCase().equals(tooMuch)) {
				max = guess;
				guess = ((max - min)/2) + min;
				round++;
				System.out.println("So maybe "+ guess);
			} else if (answer.toLowerCase().equals(notEnough)) {
				min = guess;
				guess = ((max - min)/2) + min;
				round++;
				System.out.println("So maybe "+ guess);
			} else if (answer.toLowerCase().equals(right)){
				System.out.println("I won!");
				break;
			} 
		}
		scan.close();
	}
	
}
