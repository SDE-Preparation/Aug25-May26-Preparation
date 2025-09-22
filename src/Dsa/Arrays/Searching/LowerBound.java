package Dsa.Arrays.Searching;

public class LowerBound {


    public static void main(String[] args) {

        int[] arr = { 2, 5, 7, 8, 99};

        int start = 0;

        int target =  100;

        int end = arr.length - 1;
        int lb = arr.length;
        while(start <= end){

            int mid = start + (end - start) / 2;

            if(arr[mid] >= target){
                lb = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(lb);
    }
}
