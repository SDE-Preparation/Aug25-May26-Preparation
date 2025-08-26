package Dsa.Arrays;

public class MissingArrays {

    static int missingValue(int[] arr){
        for(int i = 1 ; i < arr.length; i++){

                if(arr[i-1] + 1 != arr[i]){
                    return arr[i-1] + 1;
                }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {
                1, 2, 3,4, 5, 7
        };

        System.out.println(missingValue(arr));
    }
}
