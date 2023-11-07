import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int totalRounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("You have " + maxAttempts + " attempts for each round.");

        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int roundScore = 0;

            System.out.println("Round " + round + ": Guess a number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    roundScore = maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number. Attempts left: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Try a lower number. Attempts left: " + (maxAttempts - attempts));
                }
            }

            System.out.println("Round " + round + " score: " + roundScore);
            totalScore += roundScore;
        }

        System.out.println("Game Over! Total Score: " + totalScore);
        scanner.close();
    }
}
