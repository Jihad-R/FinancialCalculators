package org.yearup;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double principle = 0, interestRate = 0 , totalInterest , monthlyPrinciplePay = 0;
        short loanLength = 0;

        System.out.printf("Please enter the loan amount: ");
        principle = scan.nextDouble();
        System.out.printf("Please enter the interest rate (in percentages): ");
        interestRate = scan.nextDouble();
        interestRate /= 100;
        interestRate /=12;
        System.out.printf("Please enter the length of the loan (in years): ");
        loanLength = scan.nextShort();
        loanLength *= (short) 12;

        monthlyPrinciplePay = (principle  * interestRate) / (1 - Math.pow((1 + interestRate),(-loanLength)));
        totalInterest = monthlyPrinciplePay * 12 * 15 - principle;

        System.out.printf("The monthly principle payment is: $ %.2f \n" +
                          "The total interest payment is: $ %.2f \n",monthlyPrinciplePay,totalInterest);
        System.out.println("Thank you for using our services");



    }
}