package Dsa.Arrays;

import java.util.Arrays;

public class EvenOrOdd {
    public static int[] countOddEven(int[] arr) {
        // Code here
        int even = 0;
        int odd = 0;

        for(int specificNum : arr){
            if(specificNum % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }

        return new int[]{odd, even};
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3 , 5,2};

        System.out.println(Arrays.toString(countOddEven(arr)));
    }
}
