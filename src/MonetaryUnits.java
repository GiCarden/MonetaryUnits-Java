import java.util.Scanner;

/**
 * A program that converts a sum of currency into smaller monetary units
 * (Hundred, Fifty, Twenty, Ten, Five, One dollar bills, Quarters, Dimes, Nickels, and Pennies).
 */
class MonetaryUnits {

//Variable(s)-
    private final static int HUNDRED_DOLLAR_BILL = 10000; // $100.00 * 100 = 10000
    private final static int FIFTY_DOLLAR_BILL = 5000; // $50.00 * 100 = 5000
    private final static int TWENTY_DOLLAR_BILL = 2000; // $20.00 * 100 = 2000
    private final static int TEN_DOLLAR_BILL = 1000; // $10.00 * 100 = 1000
    private final static int FIVE_DOLLAR_BILL = 500; // $5.00 * 100 = 500
    private final static int ONE_DOLLAR_BILL = 100; // $1.00 * 100 = 100
    private final static int QUARTERS = 25; // $0.25 * 100 = 25
    private final static int DIMES = 10; // $0.10 * 100 = 10
    private final static int NICKELS = 5; // $0.05 * 100 = 5
    private final static int PENNIES = 1; // $0.01 * 100 = 1


//Private Method(s)-
    /**
     * Currency breakdown that results in the minimum number of bills and coins.
     *
     * @param currency to breakdown into smaller monetary units
     */
    private static void computeMonetaryUnits(int currency) {

        // extract the number of hundred dollar bills.
        int hundredDollars = currency / HUNDRED_DOLLAR_BILL;
        int pocketChange = currency % HUNDRED_DOLLAR_BILL;

        // extract the number of fifty dollar bills.
        int fiftyDollars = pocketChange / FIFTY_DOLLAR_BILL;
        pocketChange %= FIFTY_DOLLAR_BILL;

        // extract the number of twenty dollar bills.
        int twentyDollars = pocketChange / TWENTY_DOLLAR_BILL;
        pocketChange %= TWENTY_DOLLAR_BILL;

        // extract the number of ten dollar bills.
        int tenDollars = pocketChange / TEN_DOLLAR_BILL;
        pocketChange %= TEN_DOLLAR_BILL;

        // extract the number of five dollar bills.
        int fiveDollars = pocketChange / FIVE_DOLLAR_BILL;
        pocketChange %= FIVE_DOLLAR_BILL;

        // extract the number of one dollar bills.
        int oneDollars = pocketChange / ONE_DOLLAR_BILL;
        pocketChange %= ONE_DOLLAR_BILL;

        // extract the number of quarters.
        int quarters = pocketChange / QUARTERS;
        pocketChange %= QUARTERS;

        // extract the number of dimes.
        int dimes = pocketChange / DIMES;
        pocketChange %= DIMES;

        // extract the number of nickels.
        int nickels = pocketChange / NICKELS;
        pocketChange %= NICKELS;

        // extract the number of pennies.
        int pennies = pocketChange / PENNIES;

        print(currency / ONE_DOLLAR_BILL, currency % ONE_DOLLAR_BILL,
                hundredDollars, fiftyDollars, twentyDollars, tenDollars, fiveDollars, oneDollars,
                quarters, dimes, nickels, pennies);
    }

    /**
     * Helper print method.
     *
     * Outputs the maximum number of Hundred Dollars, Fifty Dollars, Twenty Dollars, Ten Dollars, One Dollars,
     * quarters, dimes, nickels, and pennies.
     */
    private static void print(int totalBillSum, int totalCoinSum,
                              int hundredDollars, int fiftyDollars, int twentyDollars, int tenDollars, int fiveDollars,
                              int oneDollars, int quarters, int dimes, int nickels, int pennies) {

        if (totalCoinSum < 10) {

            System.out.printf("\n$%d.0%d Consists of:\n", totalBillSum, totalCoinSum);
        } else {

            System.out.printf("\n$%d.%d Consists of:\n", totalBillSum, totalCoinSum);
        }

        System.out.printf("\t\t\t\t\t%d Hundred Dollar Bill(s)\n",hundredDollars);
        System.out.printf("\t\t\t\t\t%d Fifty Dollar Bill(s)\n",fiftyDollars);
        System.out.printf("\t\t\t\t\t%d Twenty Dollar Bill(s)\n",twentyDollars);
        System.out.printf("\t\t\t\t\t%d Ten Dollar Bill(s)\n",tenDollars);
        System.out.printf("\t\t\t\t\t%d Five Dollar Bill(s)\n", fiveDollars);
        System.out.printf("\t\t\t\t\t%d One Dollar Bill(s)\n", oneDollars);
        System.out.printf("\t\t\t\t\t%d Quarter(s)\n", quarters);
        System.out.printf("\t\t\t\t\t%d Dime(s)\n", dimes);
        System.out.printf("\t\t\t\t\t%d Nickel(s)\n", nickels);
        System.out.printf("\t\t\t\t\t%d Pennie(s)\n", pennies);
    }


//Package Private Method(s)-
    /**
     * Test's user input.
     */
    static void inputProcessor() {

        Scanner cin = new Scanner(System.in);
        boolean isDouble = false;
        double temp = -1;

        System.out.print("Enter Currency: ");

        do {
            try {

                temp = Double.parseDouble(cin.next().trim());
                isDouble = true;
            } catch (NumberFormatException | NullPointerException e) {

                System.out.print("Invalid currency format, try again: ");
            }
        } while (!isDouble);

        computeMonetaryUnits((int) (temp * 100));
    }

}//End of Class.
