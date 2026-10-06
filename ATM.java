/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atm;
import java.util.Scanner;

/**
 *
 * @author MARKKLIN JEYA SINGH
 */
public class ATM {
    
    static double balance = 10000;
    static final int CORRECT_PIN = 1234;
    static final double WITHDRAWAL_LIMIT = 5000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();

            if (pin != CORRECT_PIN) {
                throw new InvalidPINException("Invalid PIN!");
            }

            System.out.println("\nPIN verified successfully.");
            int choice;

            do {
                System.out.println("\n----- ATM TRANSACTION SYSTEM -----");
                System.out.println("1. Balance Enquiry");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Current Balance: Rs." + balance);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw <= 0) {
                            throw new InvalidAmountException(
                                    "Invalid transaction amount!");
                        }

                        if (withdraw > WITHDRAWAL_LIMIT) {
                            throw new WithdrawalLimitException(
                                    "Withdrawal limit exceeded! Maximum limit is Rs."
                                            + WITHDRAWAL_LIMIT);
                        }

                        if (withdraw > balance) {
                            throw new InsufficientBalanceException(
                                    "Insufficient balance!");
                        }

                        balance = balance - withdraw;
                        System.out.println("Withdrawal successful.");
                        System.out.println("Remaining Balance: Rs." + balance);
                        break;

                    case 3:
                        System.out.print("Enter deposit amount: ");
                        double deposit = sc.nextDouble();

                        if (deposit <= 0) {
                            throw new InvalidAmountException(
                                    "Invalid transaction amount!");
                        }

                        balance = balance + deposit;
                        System.out.println("Deposit successful.");
                        System.out.println("Updated Balance: Rs." + balance);
                        break;

                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 4);

        } catch (InvalidPINException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (WithdrawalLimitException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
        // TODO code application logic here
    
    

