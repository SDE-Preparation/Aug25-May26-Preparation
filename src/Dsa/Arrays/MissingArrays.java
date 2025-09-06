package Dsa.Arrays;
import java.util.*;
public class MissingArrays {

    static int missingValue(int[] arr){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        if(arr.length == 1){
            return arr[0] + 1;
        }
        int result = -1;
        for(int i = 1 ; i < arr.length; i++){

                if(arr[i-1] + 1 != arr[i]){
                    result = arr[i-1] + 1;
                    break;
                }else if(arr.length - 1 == i){
                    result = arr[i] + 1;
                    break;
                }

        }


        return result;
    }

    public static void main(String[] args) {
        int[] arr = {
                1, 2, 3, 5
        };

        System.out.println(missingValue(arr));
    }
}
