
import java.util.Locale;
//import Scanner and decimal format
import java.util.Scanner;
import java.text.DecimalFormat;
class HelloWorld {
    public static void main(String[] args) {

        //make a new scanner called in
        Scanner in = new Scanner(System.in);
        //makes a new decimal format for displaying cost
        DecimalFormat moneyFmt = new DecimalFormat("$,###.##");
       //Ask the user for their package type
        System.out.println("Which package do you have? ");
        //store the input in pack and set it to lowercase and strip
        String pack = in.nextLine().strip().toLowerCase();

        //Ask the user for how data they used
        System.out.println("How much data did you use? ");
        int data_used = in.nextInt();
        //helps stop the program from skipping over asking if they have a coupon
        in.nextLine();

        //initialize the variables valid, price, data_limit, price_extra, and hasCoupon
        boolean valid = true;
        double price = 0;
        int data_limit = 0;
        int price_extra = 0 ;
        boolean hasCoupon = false;

        //Details if package is purple
        if (pack.equals("purple")) {
            //sets price, data_limit, and price_extra to the values for the package
             price = 99.95;
             data_limit = 0;
             price_extra = 0;

        //Details if package is blue
        }else if (pack.equals("blue")) {
            //sets price, data_limit, and price_extra to the values for the package
            price = 70;
             data_limit = 4;
             price_extra = 10;

            //Details if package is green
        }else if (pack.equals("green")) {
            //gets input for if they have a coupon
            System.out.println("Do you have a coupon? ");
            //sets the string inputted to lowercase and removes whitespace
            String coupon = in.nextLine().strip().toLowerCase();
            //if the input is yes
            if (coupon.equals("yes")) {
                //set hasCoupon to true
                hasCoupon = true;
            //if the input is no
            }else if (coupon.equals("no")) {
                //set hasCoupon to false
                hasCoupon = false;
            }
            //sets price, data_limit, and price_extra to the values for the package
            price = 49.99;
            data_limit = 2;
            price_extra = 15;
        }
    //if the input does not match any of the package names
    else {
            //output invalid package and set valid to false
            System.out.println("Invalid package name");
            valid = false;
        }
        // if the package is valid
        if (valid) {
            //if the data used is greater than the data limit
            if (data_used > data_limit){
                //subtract the used data from the data limit to find how much extra data they used then multiply it by the price of extra data
                price += (data_used - data_limit) * price_extra;
                // if their package is "green" and they have a coupon, and the price is over 75
                if (pack.equals("green") && hasCoupon && price >=75){
                    //subtract 20 from the price
                    price -= 20;
                }
        }
            //output for the amount the customer owes
        System.out.println("You owe, "+moneyFmt.format(price));
    }
}
}
