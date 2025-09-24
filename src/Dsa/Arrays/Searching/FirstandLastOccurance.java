package Dsa.Arrays.Searching;

public class FirstandLastOccurance {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 3,3 , 5, 5, 8};
        int target = 5;

        System.out.println(firstOcc(arr,target));
        System.out.println(lastOcc(arr,target));

    }

    static int firstOcc(int[] arr, int target){

        int start = -1;

        int end = arr.length - 1;
        boolean exists = false;
        while(start <= end){

            int mid = start + (end - start) / 2;

            if(arr[mid] > target ){
                end = mid - 1;
            }else if(arr[mid] == target){
                exists = true;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        if(!exists){
            return -1;
        }
        return start;
    }

    static int lastOcc(int[] arr, int target){

        int start = -1;

        int end = arr.length - 1;
        boolean exists = false;
        while(start <= end){

            int mid = start + (end - start) / 2;

            if(arr[mid] > target ){
                end = mid - 1;
            }else if(arr[mid] == target){
                exists = true;
                start = mid + 1;
            }else{
                start = mid + 1;
            }
        }

        if(!exists){
            return -1;
        }
        return end;
    }


}
