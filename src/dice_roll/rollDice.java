package dice_roll;

import java.util.Random;
import java.util.Scanner;

public class rollDice {

	public static void main(String[] args) {
		
		try {
			diceRolling();
		} catch (Exception e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}
	}

	static void diceRolling () {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Type the code to roll the dice!");
		String answer = "";
		int rounds = 1;
		int diceType = 0;
		int diceRange = 0;
		int calculation = 0;
		
		String signType = "";
		// take string 
		answer = scan.next(); 
		// analyze
		if (answer.indexOf("D") == 0) {
			if (answer.indexOf(signType = "+") != -1 || answer.indexOf(signType = "-") != -1 ) {
				diceRange = answer.indexOf(signType);
				diceType = Integer.parseInt(answer.substring(1, diceRange));
				calculation = Integer.parseInt(answer.substring(diceRange +1));
			} else {
				signType =""; 
				diceType = Integer.parseInt(answer.substring(1));
				calculation = 0;
			}
		} else {
			rounds = Integer.parseInt(answer.substring(0, answer.indexOf("D")));
			if (answer.indexOf(signType = "+") != -1 || answer.indexOf(signType = "-") != -1 ) {
				diceRange = answer.indexOf(signType);
				diceType = Integer.parseInt(answer.substring(1, diceRange));
				calculation = Integer.parseInt(answer.substring(diceRange +1));
			} else {
				signType =""; 
				diceType = Integer.parseInt(answer.substring(1));
				calculation = 0;
			}
		}	
		
		rollTheDice(rounds, diceType, calculation, signType );
		scan.close();
	}
	
	static void rollTheDice (int rounds, int diceType, int calculation, String signType) {
		
		int roll = randomNumber (diceType);
		int counter = 0;
		int result = 0;
		
		while (counter > rounds) {
			result = roll + Integer.parseInt(signType) + calculation;
			System.out.println(result);
		}
	}
	
    static int randomNumber (int range) {
    	
    	Random rand = new Random();
    	int number = rand.nextInt(range) + 1;
    	return number;
    	
    }
}
