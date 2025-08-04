import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_TO_INR_RATE = 87.25;
    private static final double EUR_TO_INR_RATE = 99.79;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Welcome to Currency Converter! (Rates as of August 2025)");
        System.out.println("1. USD to Rupee");
        System.out.println("2. Rupee to USD");
        System.out.println("3. Euro to Rupee");
        System.out.println("4. Rupee to Euro");
        System.out.print("Enter your choice (1, 2, 3 or 4): ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            scanner.close();
            return;
        }

        int choice = scanner.nextInt();
        double amount;
        switchValidation:
        if (choice == 1) {
            System.out.print("Enter the amount in USD: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount."); break switchValidation;
            }
            amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be non-negative."); break switchValidation;
            }
            double inr = usdToRupee(amount);
            System.out.println("₹" + df.format(inr) + " INR");
        } else if (choice == 2) {
            System.out.print("Enter the amount in Rupee: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount."); break switchValidation;
            }
            amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be non-negative."); break switchValidation;
            }
            double usd = rupeeToUsd(amount);
            System.out.println("$" + df.format(usd) + " USD");
        } else if (choice == 3) {
            System.out.print("Enter the amount in Euro: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount."); break switchValidation;
            }
            amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be non-negative."); break switchValidation;
            }
            double inr = euroToRupee(amount);
            System.out.println("₹" + df.format(inr) + " INR");
        } else if (choice == 4) {
            System.out.print("Enter the amount in Rupee: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount."); break switchValidation;
            }
            amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Amount must be non-negative."); break switchValidation;
            }
            double euro = rupeeToEuro(amount);
            System.out.println("€" + df.format(euro) + " EUR");
        } else {
            System.out.println("Invalid choice. Please select 1, 2, 3 or 4.");
        }

        scanner.close();
    }

    public static double usdToRupee(double usd) {
        return usd * USD_TO_INR_RATE;
    }

    public static double rupeeToUsd(double inr) {
        return inr / USD_TO_INR_RATE;
    }

    public static double euroToRupee(double eur) {
        return eur * EUR_TO_INR_RATE;
    }

    public static double rupeeToEuro(double inr) {
        return inr / EUR_TO_INR_RATE;
    }
}
