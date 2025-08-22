package Dsa.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1,4, 4, 5, 7, 8};
        int target = 4;

        System.out.println(findTargetPos(arr,target));
    }

    public static int findTargetPos(int[] arr, int k){
        if(arr.length == 1 && arr[0] == k){
            return 0;
        }
        // Code Here
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > k){
                end = mid - 1;
            }else if(arr[mid] < k){
                start = mid + 1;
            }else{

                return mid;
            }
        }

        return -1;
    }
}
