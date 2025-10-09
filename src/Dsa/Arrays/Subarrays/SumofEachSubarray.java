package Dsa.Arrays.Subarrays;

public class SumofEachSubarray {

    public static void main(String[] args) {

        int[] arr = { 1,4,4};

        sumOfEach(arr);
    }

    public static void sumOfEach(int[] arr){


        int len = 0;
        for(int start = 0; start < arr.length; start++){
            int sum = 0;
            for(int end = start; end < arr.length; end++){

                sum += arr[end];

                if(sum >= 4){

                    if(len == 0){
                        len = (end - start) + 1;
                    }else{
                        len = Math.min(len,(end - start) + 1 );
                    }
                }


            }
        }

        System.out.println("minimum length " + len);
    }
}
