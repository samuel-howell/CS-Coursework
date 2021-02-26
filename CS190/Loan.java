package com.company;

//Samuel Howell 2-17-20

/*(IllegalArgumentException) Modify the Loan class in Listing 10.2 to
throw IllegalArgumentException if the loan amount, interest rate, or
number of years is less than or equal to zero. */
public class Loan {

    public static void main(String[] args) {
        try {
            new nLoan(8.5, 22, 100500);
            nLoan newLoan = new nLoan(-1, 3, 3000);
            new nLoan(8.5, 22, 63000);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("The program has been ended.");
    }
}


class nLoan{
            private double annualInterestRate;
            private int numberOfYears;
            private double loanAmount;
            private java.util.Date loanDate;

            //default
            public nLoan(){
                this(8.5, 22,100500);
            }
            public nLoan(double annualInterestRate, int numberOfYears,
                        double loanAmount) {
                setAnnualInterestRate(annualInterestRate);
                setNumberOfYears(numberOfYears);
                setLoanAmount(loanAmount);
                loanDate = new java.util.Date();
            }


            public double getAnnualInterestRate() {
                return annualInterestRate;
            }

            /**
             * Set a new annualInterestRate
             */
            public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException{
                if (annualInterestRate >= 0)
                    this.annualInterestRate = annualInterestRate;
                else
                    throw new IllegalArgumentException("Annual Interest Rate cannot be a negative value.");
            }

            /**
             * Return numberOfYears
             */
            public int getNumberOfYears() {
                return numberOfYears;
            }

            /**
             * Set a new numberOfYears
             */
            public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException {
                if (numberOfYears >= 0)
                    this.numberOfYears = numberOfYears;
                else
                    throw new IllegalArgumentException("Number of years cannot be a negative value");

            }

            /**
             * Return loanAmount
             */
            public double getLoanAmount() {
                return loanAmount;
            }

            /**
             * Set a new loanAmount
             */
            public void setLoanAmount(double loanAmount) throws IllegalArgumentException {
                if (loanAmount >=0) this.loanAmount = loanAmount;
                else
                    throw new IllegalArgumentException("Loan amount cannot be a negative value.");
            }

            /**
             * Find monthly payment
             */
            public double getMonthlyPayment() {
                double monthlyInterestRate = annualInterestRate / 1200;
                double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
                return monthlyPayment;
            }

            /**
             * Find total payment
             */
            public double getTotalPayment() {
                double totalPayment = getMonthlyPayment() * numberOfYears * 12;
                return totalPayment;
            }

            /**
             * Return loan date
             */
            public java.util.Date getLoanDate() {
                return loanDate;
            }
        }
