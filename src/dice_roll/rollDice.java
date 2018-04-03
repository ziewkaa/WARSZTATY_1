package dice_roll;

import java.util.Random;
import java.util.Scanner;

public class rollDice {

	public static void main(String[] args) {
		
		try {
			diceRolling();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	static void diceRolling() {
		
		Scanner scan = new Scanner(System.in);
		String answer = "";
		String sign ;
		int signIndex = -1;
		int rounds = 1;
		int diceType = 0;
		int positionOfD;
		int additional = 0;
		
		
		System.out.println("Type the code to roll the dice!");
		answer = scan.next();
		
		positionOfD = answer.indexOf("D");
		
		if (answer.contains(sign = "+") || answer.contains(sign = "-")) {
			signIndex = answer.indexOf(sign);
		} 
		
		if (positionOfD == 0) {
			if (signIndex != -1) {
				diceType = Integer.parseInt(answer.substring(1,signIndex));
				additional = Integer.parseInt(answer.substring(signIndex + 1));
			} else if (signIndex == -1) {
				diceType = Integer.parseInt(answer.substring(1));
			}
		} else {
			if (signIndex != -1) {
				rounds = Integer.parseInt(answer.substring(0, positionOfD));
				diceType = Integer.parseInt(answer.substring(positionOfD + 1,signIndex));
				additional = Integer.parseInt(answer.substring(signIndex+1));
			} else if (signIndex == -1){
				rounds = Integer.parseInt(answer.substring(0, positionOfD));
				diceType = Integer.parseInt(answer.substring(positionOfD + 1));
			}
		}
		System.out.print(rollTheDice ( rounds, diceType, additional, sign));
	}
	
	 static int randomNumber (int range) {
	    	
	    	Random rand = new Random();
	    	int number = rand.nextInt(range) + 1;
	    	return number;
	    	
	    }

	static int rollTheDice (int rounds, int diceType, int additional, String sign) {
		
		int result = 0;
		int counter = 0;
		
		while(counter < rounds) {
			result += randomNumber(diceType);
			counter++;
		}
		
		switch(sign) {
		case "+":
			result += additional;
			return result;
		case "-":
			result -= additional;
			return result;
		default:
			return result;
		}
		
	}
	
}