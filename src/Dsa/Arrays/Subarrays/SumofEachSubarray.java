package Dsa.Arrays.Subarrays;

public class SumofEachSubarray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5};

        sumOfEach(arr);
    }

    public static void sumOfEach(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        int count = 0;
        for(int start = 0; start < arr.length; start++){

            for(int end = start; end < arr.length; end++){
                int sum = 0;

                for(int k = start; k <= end; k++){
                    sum += arr[k];


                }

                if(sum == 3){
                    count++;
                }


            }
        }

        System.out.println("count value " + count);
    }
}
