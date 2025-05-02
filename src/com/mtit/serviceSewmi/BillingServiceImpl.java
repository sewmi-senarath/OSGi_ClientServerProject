package com.mtit.serviceSewmi;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;


public class BillingServiceImpl implements BillingService {

    private static final int EXIT = 99; // Constant for exit code
    private static final int BACK = 0; //constant for going back to main menu
    private Scanner input;

    public BillingServiceImpl() {
        input = new Scanner(System.in); // Initialize scanner
    }

    @Override
    public void ViewPaymentMethods() {
        ArrayList<String> paymentMethods = new ArrayList<>();
        paymentMethods.add("Card Payment");
        paymentMethods.add("Cash Payment");
        paymentMethods.add("Bank Deposit");
        paymentMethods.add("PayPal");

        System.out.println("******* Available Payment Methods *******");
        for (int i = 0; i < paymentMethods.size(); i++ ) {
            System.out.println(paymentMethods.get(i));
        }

        System.out.println("\nEnter " + EXIT + " to exit....");
        System.out.println("\nEnter " + BACK + " to go back to the Payement Menu....");
        System.out.println();
        System.out.print("Your Choice: ");
        System.out.println();

        try {
            int choice = input.nextInt();
            if (choice == EXIT) {
                Exit();
            } else if (choice == BACK){
            	System.out.println("############# Going back to Payement Menu!!! ###############");
            	return;
            }else {
                System.out.println("Invalid choice! Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            input.nextLine(); 
        }
    }

    @Override
    public void PaymentDetails() {
        ArrayList<String> paymentDetails = new ArrayList<>();

        while (true) {
            System.out.println("\n====== Payment Details Menu ======");
            System.out.println("1. Add Payment Details");
            System.out.println("2. Update Payment Details");
            System.out.println("3. Delete Payment Details");
            System.out.println("4. Show Payment Details");
            System.out.println(EXIT + ". Exit");
            System.out.println("\n");
            System.out.println("Choose an option: ");

            try {
                int choice = input.nextInt();
                input.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter payment details ");
                        //add the username here
                        System.out.println("Please follow the format ('Payment Type' - 'Amount') ");
                        String details = input.nextLine();
                        paymentDetails.add(details);
                        System.out.println("Payment details added successfully!");
                        break;
                    case 2:
                        updatePaymentDetails(paymentDetails);
                        break;
                    case 3:
                        deletePaymentDetails(paymentDetails);
                        break;
                    case 4:
                        showPaymentDetails(paymentDetails);
                        break;
                    case EXIT:
                        return; 
                    default:
                        System.out.println("################ Invalid option. Please try again ###################");
                }
            } catch (InputMismatchException e) {
                System.out.println("########### Please enter a valid number ################");
                input.nextLine(); 
            }
        }
    }

    @Override
    public void Exit() {
        System.out.println("----- GOOD BYE -----!!!");
        if (input != null) {
            input.close(); // Close the scanner
        }
    }

    @Override
    public void CalcTotal() {
        ArrayList<Double> amounts = new ArrayList<>();
        double total = 0.0;

        System.out.println("=================== CALCULATE TOTAL PAYMENT ===================");
        System.out.println("Enter the amounts of individual payments below");

        while (true) {
            System.out.print("Enter amount (or -1 to finish): ");
            try {
                double amount = input.nextDouble();

                if (amount == -1) {
                    break; 
                } else if (amount < 0) {
                    System.out.println("Invalid amount! Amount cannot be negative.");
                } else {
                    amounts.add(amount);
                    total = total+amount;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                input.nextLine(); 
            }
        }

        // Display the results
        System.out.println("\n=================== PAYMENT SUMMARY ===============");
        for (int i = 0; i < amounts.size(); i++) {
            System.out.println("Payment " + (i + 1) + ": " + amounts.get(i));
        }
        System.out.print("\n");
        System.out.println("^^^^^^ Total Amount: " +total+" ^^^^^^^^^^");
        System.out.print("\n");
    }

    //update payment details
    private void updatePaymentDetails(ArrayList<String> paymentDetails) {
    	
        if (paymentDetails.isEmpty()) {
            System.out.println("No payment details to update.");
            return;
        }

        showPaymentDetails(paymentDetails);
        System.out.print("Enter the number of the payment you need to update: ");
        int index = input.nextInt() - 1;
        input.nextLine(); //ensure that the next time you call it, it will wait for user input rather than consuming the previously entered newline.

        if (index >= 0 && index < paymentDetails.size()) {
            System.out.print("Enter new payment details: ");
            String newDetails = input.nextLine();
            paymentDetails.set(index, newDetails);
            System.out.println("Payment details updated successfully!");
        } else {
            System.out.println("Invalid!!!");
        }
    }

    // delete payment details
    private void deletePaymentDetails(ArrayList<String> paymentDetails) {
    	
        if (paymentDetails.isEmpty()) {
            System.out.println("No payment details to delete.");
            return;
        }

        showPaymentDetails(paymentDetails);
        System.out.print("Enter the number of the payment to delete: ");
        int index = input.nextInt() - 1;
        input.nextLine(); 

        if (index >= 0 && index < paymentDetails.size()) {
            paymentDetails.remove(index);
            System.out.println("Payment details deleted successfully!");
        } else {
            System.out.println("Invalid!!!");
        }
    }

    // show payment details
    private void showPaymentDetails(ArrayList<String> paymentDetails) {
        if (paymentDetails.isEmpty()) {
            System.out.println("No payment details available.");
            return;
        }

        System.out.println("================ Showing Payment Details ===============");
        for (int i = 0; i < paymentDetails.size(); i++) {
            System.out.println((i + 1) + ". " + paymentDetails.get(i));
        }
    }
}
