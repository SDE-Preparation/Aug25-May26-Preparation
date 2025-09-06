package Dsa.Arrays;

public class CeilOfNumber {


    static int ceilOfNumber(int[] arr, int target){

        int start = 0;

        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(arr[mid] == target)
                return mid;

            if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4, 4, 5, 6, 7};

        System.out.println(ceilOfNumber(arr, 5));
    }
}
