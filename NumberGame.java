import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("================================");

        do {

            // Generate random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;

            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();

                // Check valid range
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess == randomNumber) {

                    guessedCorrectly = true;

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Number was: " + randomNumber);
                    System.out.println("Attempts used: " + attempts);

                    // Calculate score
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Round Score: " + score);

                    break;

                } else if (guess < randomNumber) {

                    System.out.println("Too Low! Try a higher number.");

                } else {

                    System.out.println("Too High! Try a lower number.");
                }
            }

            // If user could not guess the number
            if (!guessedCorrectly) {

                System.out.println("\nSorry! You have used all your attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n================================");
        System.out.println("           GAME OVER");
        System.out.println("================================");
        System.out.println("Your Total Score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}