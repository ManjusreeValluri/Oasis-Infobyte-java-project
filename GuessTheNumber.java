/*---------------------------------------------------/
 Project Title: Guess-The-Number Game

 Description : "Guess the Number" is a simple Java game where the computer picks a random number, and the player tries to guess it. 
    The game gives feedback if the guess is too high or too low and continues until the correct number is guessed, optionally with limited attempts and scoring.
 
    Name: Manjusree Valluri

 Concepts used :  Random Number Generation
                 User Input.
                 Loops
                 Conditionals 
                 Variables
                 Basic Scoring Logic
------------------------------------------------------*/


import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 3;
        int totalScore = 0;
        
        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 3;
            boolean guessed = false;

            System.out.println("Round " + round + ": Guess a number between 1 and 100.");

            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    guessed = true;
                    totalScore += (100 - attempts * 10); // Example scoring
                } else if (userGuess < numberToGuess) {
                    System.out.println("Higher!");
                } else {
                    System.out.println("Lower!");
                }
            }
            if (!guessed) {
                System.out.println("Sorry, the number was: " + numberToGuess);
            }
        }
        System.out.println("Game Over! Total score: " + totalScore);
        scanner.close();
    }
}




/*    Output : 
 Round 1: Guess a number between 1 and 100.
Enter guess: 23
Higher!
Enter guess: 45
Lower!
Enter guess: 34
Higher!
Sorry, the number was: 39
Round 2: Guess a number between 1 and 100.
Enter guess: 23
Higher!
Enter guess: 45
Higher!
Enter guess: 50
Lower!
Sorry, the number was: 46
Round 3: Guess a number between 1 and 100.
Enter guess: 55
Lower!
Enter guess: 43
Lower!
Enter guess: 23
Higher!
Sorry, the number was: 36
Game Over! Total score: 0

 */