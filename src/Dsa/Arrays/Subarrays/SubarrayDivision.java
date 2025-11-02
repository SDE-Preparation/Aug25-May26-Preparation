package Dsa.Arrays.Subarrays;

public class SubarrayDivision {

    public static void main(String[] args) {
        int[] arr = {
                1, 2, 1, 3, 2, 1
        };

        int target = 3;
        int div = 2;

        System.out.println(slidingWindow(arr,target,div));
    }

    static int subDiv(int[] arr, int target, int div){

        int count = 0;

        for(int start = 0; start < arr.length; start++){

            int sum = 0;

            for(int end = start; end < start + div; end++){

                sum += arr[end];

            }

            if(sum == target){
                count++;
            }
        }

        return count;
    }

    static int slidingWindow(int[] arr, int target, int div){

        if(arr.length < 2){
            return -1;
        }
        int sum = arr[0] + arr[1];
        int count = 0;
        if(sum == target){
            count = 1;
        }
        for(int i = 2; i < arr.length; i++){

            sum += arr[i];
            sum -= arr[i - div];

            if(sum == target){
                count++;
            }

        }

        return count;
    }
}
