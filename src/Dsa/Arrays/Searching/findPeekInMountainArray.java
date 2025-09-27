package Dsa.Arrays.Searching;

public class findPeekInMountainArray {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 8,9, 3, 2};


        System.out.println(searchInMountain(arr,3));
    }

    // This is used to getting peak value from an mountain sorted array
    static int searchInMountain(int[] arr, int target){

        int peak = findPeak(arr);

        int ascCheck = binarySearch(arr,0, peak,target);

        if(ascCheck == -1){
            int descCheck = binarySearch(arr,peak + 1, arr.length - 1,target);


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

    static int binarySearch(int[] arr,int start, int end ,int target){

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


}


/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {


        int peak = findPeak(mountainArr);

        int ascCheck = binarySearch(mountainArr,0, peak,target);

        if(ascCheck == -1){
            int descCheck = binarySearch(mountainArr,peak + 1, mountainArr.length() - 1,target);


            return descCheck;

        }

        return ascCheck;
    }

    static int findPeak(MountainArray mountainArr){

        int start = 0;
        int end = mountainArr.length() - 1;

        while(start < end){

            int mid = start + (end - start)/ 2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1)) {
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }



        return start;
    }

    static int binarySearch(MountainArray mountainArr,int start, int end ,int target){

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) > target){
                end = mid - 1;
            }else if(mountainArr.get(mid) < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }

        return -1;
    }
}