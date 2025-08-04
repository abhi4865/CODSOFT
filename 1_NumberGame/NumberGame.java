import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)){ // to read user input
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int attemptsAllowed = 5;
            int secretNumber = getRandomNumber(1, 100);
            boolean won = false;

            System.out.println("\nYou have " + attemptsAllowed + " tries to guess a number between 1 and 100.");

            // First round of guessing
            for (int attempt = 1; attempt <= attemptsAllowed; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");

                // check if user entered an integer
                if (!input.hasNextInt()) {
                    System.out.println("That's not a valid number. Please type an integer.");
                    input.next(); // discard wrong input
                    attempt--; // don't count this as a used attempt
                    continue;
                }

                int guess = input.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed it right. The number was " + secretNumber + ".");
                    totalScore++;
                    won = true;
                    break;
                } else if (guess > secretNumber) {
                    System.out.println("Too high. Try a smaller number.");
                } else {
                    System.out.println("Too low. Try a bigger number.");
                }
            }

            if (!won) {
                System.out.println("Sorry! You used all your attempts. The correct number was " + secretNumber + ".");
            }

            // Ask for play again
            System.out.print("Do you want to play again? (y/n): ");
            String answer = input.next().trim();
            playAgain = answer.equalsIgnoreCase("y");
        }

        System.out.println("\nThank you for playing! Your total score is: " + totalScore);
        input.close();
    }
    }

    //To get a random number between min and max
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
