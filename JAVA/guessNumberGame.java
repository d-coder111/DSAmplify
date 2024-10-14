import java.util.Scanner;  
public class NumberGuess {  
    public static void playGame() {  
        Scanner scanner = new Scanner(System.in);  
        int secretNumber = 1 + (int)(100 * Math.random());  
        int maxAttempts = 5;  
        int attempts, guess;  
        System.out.println("Welcome to the Number Guessing Game!");  
        System.out.println("A number has been chosen between 1 and 100.");  
        System.out.println("Your task is to guess the number within 5 attempts.");  
        for (attempts = 0; attempts < maxAttempts; attempts++) {  
            System.out.println("Attempt " + (attempts + 1) + ": Enter your guess:");  
            guess = scanner.nextInt();  
            if (secretNumber == guess) {  
                System.out.println("Congratulations! You've guessed the correct number.");  
                break;  
            } else if (secretNumber > guess && attempts != maxAttempts - 1) {  
                System.out.println("The secret number is greater than your guess.");  
            } else if (secretNumber < guess && attempts != maxAttempts - 1) {  
                System.out.println("The secret number is less than your guess.");  
            }  
        }  
        if (attempts == maxAttempts) {  
            System.out.println("You have exhausted all " + maxAttempts + " attempts.");  
            System.out.println("The secret number was " + secretNumber);  
        }  
    }  
    public static void main(String args[]) {  
        playGame();  
    }  
}  
