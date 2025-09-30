package Dsa.Arrays.Searching;

public class searchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = { 5, 6 , 7, 1, 2, 3};

        System.out.println(search(arr,5));
    }

    static int search(int[] arr, int target){

    }

    static int pivotFind(int[] arr){

        int start = 0;
        int end = arr.length - 1;

        while(start < end){

            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]){
                return mid;
            }else if(arr[mid] < arr[mid + 1]){
                start = mid
            }
        }
    }

}
