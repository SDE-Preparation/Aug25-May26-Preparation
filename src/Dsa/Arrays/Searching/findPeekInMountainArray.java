package Dsa.Arrays.Searching;

public class findPeekInMountainArray {

    public static void main(String[] args) {
        int[] arr = { 0,5,3,1 };


        System.out.println(searchInMountain(arr,1));
    }

    // This is used to getting peak value from an m
    // ountain sorted array
    static int searchInMountain(int[] arr, int target){

        int peak = findPeak(arr);


        int ascCheck = binarySearchAsc(arr,0, peak,target);

        if(ascCheck == -1){
            int descCheck = binarySearchDesc(arr,peak + 1, arr.length - 1,target);


            return descCheck;

        }

        return ascCheck;

    }
    static int findPeak(int[] arr){

        int start = 0;
        int end = arr.length - 1;

        while(start < end){

            int mid = start + (end - start)/ 2;

            if(arr[mid] > arr[mid+1]) {
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }



        return start;
    }

    static int binarySearchAsc(int[] arr,int start, int end ,int target){

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    static int binarySearchDesc(int[] arr,int start, int end ,int target){

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target){

                start = mid + 1;
            }else if(arr[mid] < target){
                end = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;
    }


}

