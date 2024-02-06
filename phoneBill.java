
import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;
class HelloWorld {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        DecimalFormat moneyFmt = new DecimalFormat("$,###.##");
       //Ask the user for their package type
        System.out.println("Which package do you have? ");
        String pack = in.nextLine().strip().toLowerCase();

        //Ask the user for how data they used
        System.out.println("How much data did you use? ");
        int data_used = in.nextInt();
        in.nextLine();

        //initialize the variables valid, price, data_limit, price_extra, and hasCoupon
        boolean valid = true;
        double price = 0;
        int data_limit = 0;
        int price_extra = 0 ;
        boolean hasCoupon = false;

    //Details if package is purple
        if (pack.equals("purple")) {
             price = 99.95;
             data_limit = 0;
             price_extra = 0;

        //Details if package is blue
        }else if (pack.equals("blue")) {
             price = 70;
             data_limit = 4;
             price_extra = 10;

            //Details if package is green
        }else if (pack.equals("green")) {
            System.out.println("Do you have a coupon? ");
            String coupon = in.nextLine().strip().toLowerCase();
            if (coupon.equals("yes")) {
                hasCoupon = true;
            }else if (coupon.equals("no")) {
                hasCoupon = false;
            }
             price = 49.99;
             data_limit = 2;
             price_extra = 15;
        }

    else {
            System.out.println("Invalid package name");
            valid = false;
        }

        if (valid) {
            if (data_used > data_limit){
                price += (data_used - data_limit) * price_extra;
                if (pack.equals("green") && hasCoupon && price >=75){
                    price -= 20;
                }
        }
        System.out.println("You owe, "+moneyFmt.format(price));
    }
}
}
