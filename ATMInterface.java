import java.util.Scanner;

public class ATMInterface {

    static double balance = 10000.00;
    static final int PIN = 1234;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("        ATM INTERFACE");
        System.out.println("==============================");

        // PIN verification
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != PIN) {
            System.out.println("Incorrect PIN!");
            System.out.println("Transaction cancelled.");
            sc.close();
            return;
        }

        System.out.println("Login successful!");

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("          ATM MENU");
            System.out.println("==============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("==============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.printf("Current Balance: %.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();

                    if (deposit > 0) {
                        balance = balance + deposit;

                        System.out.printf(
                            "%.2f deposited successfully.%n",
                            deposit
                        );

                        System.out.printf(
                            "New Balance: %.2f%n",
                            balance
                        );
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= 0) {
                        System.out.println("Invalid withdrawal amount!");

                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance!");

                    } else {
                        balance = balance - withdraw;

                        System.out.printf(
                            "%.2f withdrawn successfully.%n",
                            withdraw
                        );

                        System.out.printf(
                            "Remaining Balance: %.2f%n",
                            balance
                        );
                    }
                    break;

                case 4:
                    System.out.println("\nThank you for using the ATM!");
                    System.out.println("Please collect your card.");
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please enter 1-4."
                    );
            }

        } while (choice != 4);

        sc.close();
    }
}