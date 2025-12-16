package Dsa.Arrays;

import static java.lang.Math.*;

public class ReverseAString {

    public static void main(String[] args) {

        int number = 523;

        double digits = log10(number);

        System.out.println(floor(digits));

        String reverse = "";

        for(int i = 0; i < number; i++){

            int lastDigit = number % 10;

            number = number / 10;

            reverse += "" + lastDigit;
        }

        System.out.println(reverse);
    }
}
