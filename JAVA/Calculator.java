import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Java Calculator");
            System.out.println("Menu:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");

            System.out.print("Select an option (1/2/3/4/5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the calculator.");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double result = 0.0;
            String operation = "";

            switch (choice) {
                case 1:
                    result = num1 + num2;
                    operation = "Addition";
                    break;
                case 2:
                    result = num1 - num2;
                    operation = "Subtraction";
                    break;
                case 3:
                    result = num1 * num2;
                    operation = "Multiplication";
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                        operation = "Division";
                    } else {
                        System.out.println("Division by zero is not allowed.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    continue;
            }

            System.out.println(operation + " result: " + result);
        }

        scanner.close();
    }
}
