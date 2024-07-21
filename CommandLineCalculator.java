import java.util.Scanner;
public class CommandLineCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter operation (+, -, *, /) or 'exit' to end:");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            if (!isValidOperation(operation)) {
                System.out.println("Invalid operation. Please enter a valid operation (+, -, *, /).");
                continue;
            }

            System.out.println("Enter first number:");
            double num1 = getValidNumber(scanner);

            System.out.println("Enter second number:");
            double num2 = getValidNumber(scanner);

            double result = performOperation(num1, num2, operation);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static boolean isValidOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/");
    }

    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static double performOperation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero. Please enter a non-zero divisor.");
                    return Double.NaN;
                }
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
