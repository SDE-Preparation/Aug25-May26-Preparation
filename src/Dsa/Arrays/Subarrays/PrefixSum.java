package Dsa.Arrays.Subarrays;

import java.util.Arrays;

public class PrefixSum {


    public static void main(String[] args) {
//        int[] arr = { 1, 3, 5, 66, 88, 333};
        int[] arr = { 1, 3, 5, 6, 7};
        int[] prefix = makePrifix(arr);

        System.out.println(sum(prefix,3,4));
    }

    static int[] makePrifix(int[] arr){
        int[] sum = new int[arr.length];

        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            sum[i] = sum[i - 1] + arr[i];
        }

        return sum;
    }

    static int sum(int[] sum, int left, int right){
        if(left == 0){
            return sum[right];
        }else{
            return sum[right] - sum[left - 1];
        }
    }
}
