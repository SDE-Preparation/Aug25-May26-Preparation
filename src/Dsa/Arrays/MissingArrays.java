package Dsa.Arrays;
import java.util.*;
public class MissingArrays {

    static int missingValue(int[] arr){
        Arrays.sort(arr);
        if(arr.length == 1){
            return arr[0] + 1;
        }
        int result = 0;
        for(int i = 1 ; i < arr.length; i++){

                if(arr[i-1] + 1 != arr[i]){
                    result = arr[i-1] + 1;
                }
                if(arr.length - 1 == i){
                    result = arr[i] + 1;
                }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] arr = {
                2,6,5,1,3
        };

        System.out.println(missingValue(arr));
    }
}
