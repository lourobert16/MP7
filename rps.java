import java.util.Scanner;

public class rps {
	//0 = rock
	//1 = paper
	//2 = scissors
	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int z = 0;
		int w = 0;
		game(x, y, z, w);
	}
	
	public static void game(int gameCount, int winCount, int loseCount, int drawCount) {

		Scanner getUserInput = new Scanner(System.in);
		System.out.println("Enter rock, paper, or scissors");
		String x = getUserInput.nextLine();
		String userInput = x.toLowerCase();
		
		if (userInput.equals("rock") || userInput.equals("paper") || 
				userInput.equals("scissors")) {	
		int computerInput = (int) (Math.random() * 3);
		if (computerInput == 0) {
			System.out.println("The computer played rock.");
			if(userInput.equals("rock")) {
				System.out.println("It's a draw!");
				gameCount++;
				drawCount++;
			}
			if(userInput.equals("paper")) {
				System.out.println("You win!");
				gameCount++;
				winCount++;
			}
			if(userInput.equals("scissors")) {
				System.out.println("You lose!");
				gameCount++;
				loseCount++;
			}
		} else if (computerInput == 1) {
			System.out.println("The computer played paper.");
			if(userInput.equals("rock")) {
				System.out.println("You lose!");
				gameCount++;
				loseCount++;
			}
			if(userInput.equals("paper")) {
				System.out.println("It's a draw!");
				gameCount++;
				drawCount++;
			}
			if(userInput.equals("scissors")) {
				System.out.println("You win!");
				gameCount++;
				winCount++;
			}
		} else if (computerInput == 2) {
			System.out.println("The computer played scissors.");
			if(userInput.equals("rock")) {
				System.out.println("You win!");
				gameCount++;
				winCount++;
			}
			if(userInput.equals("paper")) {
				System.out.println("You lose!");
				gameCount++;
				loseCount++;
			}
			if(userInput.equals("scissors")) {
				System.out.println("It's a draw!");
				gameCount++;
				drawCount++;
			}
		}
		
		System.out.println("Do you want to continue playing? Yes or No?");
		String y = getUserInput.nextLine();
		String answer =	y.toLowerCase();
		if (answer.equals("yes") || answer.equals("y") || answer.equals("ya") 
				|| answer.equals("yeah") || answer.equals("yup")) {
			game(gameCount, winCount, loseCount, drawCount);
		} else {
			if (gameCount == 1) {
				System.out.print("You played " + gameCount + " game. ");
			} else {
				System.out.print("You played " + gameCount + " games. ");
			}
			if (winCount == 1) {
				System.out.print("You won " + winCount + " game, ");
			} else {
				System.out.print("You won " + winCount + " games, ");
			}
			if (loseCount == 1) {
				System.out.print("lost " + loseCount + " game, ");
			} else {
				System.out.print("lost " + loseCount + " games, ");
			}
			if (drawCount == 1) {
				System.out.println("and there was " + drawCount + " draw.");
			} else {
				System.out.println("there were " + drawCount + " draws. ");
			}
			System.out.println("Thanks for Playing!");
			return;
		}
		} else {
			System.out.println("Please enter a valid response");
			game(gameCount, winCount, loseCount, drawCount);
		}
		getUserInput.close();
	}
}
