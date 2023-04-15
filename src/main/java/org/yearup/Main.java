package org.yearup;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double principle = 0, interestRate = 0, totalInterest = 0; // declaring principle ((loan amount/deposit/payout))
                                                                  // interest rate (expected/paid), totalInterest

        short loanLength = 0, options = 0; // declaring loanLenght (number of years), options

        System.out.printf("\n=======================================\n" +
                "WELCOME TO FINANCIAL CALCULATOR INC\n" +
                "=======================================\n");

        System.out.printf("Which service would you like to use (press a number)?\n" +
                "1 - Mortgage Calculator \t 2 - Future Value Calculator \t 3- Present Value Calculator\n");

        options = scan.nextShort(); // registering the user's option

        if (options < 1 || options > 3) {

            System.out.println("INVALID! PLEASE TRY AGAIN.");

        }
        else {

            System.out.printf("Please enter the principle (loan amount/deposit/payout): ");
            principle = scan.nextDouble();

            System.out.printf("Please enter the interest rate (in percentages): ");
            interestRate = scan.nextDouble();
            interestRate /= 100;

            System.out.printf("Please enter the length of the loan (in years): ");
            loanLength = scan.nextShort();
        }

        // checking options selected so that the interestRate and loanLength can be readjusted for later calculations
        if ((options == 1) || (options == 3)) {
            interestRate /= 12;
            loanLength *= (short) 12;
        }

        //checking which options satisfies the conditions
        if (options == 1) {
            mortgageCalculator(principle, interestRate, totalInterest, loanLength);
        } else if (options == 2) {
            futureValueCalculator(principle, interestRate, totalInterest, loanLength);
        } else if (options == 3) {
            presentValueCalculator(principle, interestRate, loanLength);
        }

        //closing message
        System.out.println("\nThank you for using our services");


    }

    public static void mortgageCalculator(double principle, double interestRate, double totalInterest, short loanLength) {

        /* This function accepts the principle, interest rate, total interest, and number of loan years inorder to
         * compute and display the monthly payments and interest paid*/

        double monthlyPrinciplePay = 0;

        //calculating the monthly principle (loan) payment and total interest
        monthlyPrinciplePay = (principle * interestRate) / (1 - Math.pow((1 + interestRate), (-loanLength)));
        totalInterest = monthlyPrinciplePay * 12 * 15 - principle;

        System.out.printf("\nThe monthly principle payment is $ %.2f \n" +
                "The total interest payment is $ %.2f \n", monthlyPrinciplePay, totalInterest);
    }


    public static void futureValueCalculator(double principle, double interestRate, double totalInterest, short loanLength) {

        /* This function accepts the deposits, interest rate, total interest, and number of years inorder to
         * compute and display the future value and total interest earned*/

        final short N = 365;

        //calculating the future value and total interest
        double futureValue = principle * Math.pow((1 + (interestRate / N)), (N * loanLength));
        totalInterest = futureValue - principle;

        System.out.printf("\nThe future value is $ %.2f\n" +
                "The total interest payment is $ %.2f\n", futureValue, totalInterest);
    }

    public static void presentValueCalculator(double principle, double interestRate, short loanLength) {

        /* This function accepts the monthly payout, expected interest rate, and number of years to payout for
         * computing and displaying the present value of annuity*/

        //calculating the present value annuity
        double presentValueAnnuity = principle * ((1 - Math.pow((1 + interestRate), -loanLength)) / (interestRate));

        System.out.printf("\nThe monthly principle payment is $ %.2f \n", presentValueAnnuity);
    }
}