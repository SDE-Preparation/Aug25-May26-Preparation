package Dsa.Arrays;

public class PracticeArrays {
    public static void main(String[] args) {

        // Find the largest element in the array

        int[] arr = {
                2,7,8,8,8,8,8
        };

        int secValue = -1;

        if(arr.length > 1){
            int largestValue = arr[0];
            secValue = arr[0];

            for(int i = 1;i < arr.length ; i++){
                if(largestValue < arr[i] ){
                    if (largestValue != arr[i]) {
                        secValue = largestValue;
                    }
                    largestValue = arr[i];
                }
            }
        }




        System.out.println("Largest value : " + secValue);
    }
}
