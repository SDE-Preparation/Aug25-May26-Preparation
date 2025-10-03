package Dsa.Arrays.Subarrays;

public class PrintAllSubarray {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 6};

        printAllSubarraySums(arr);

//        for(int start = 0; start < arr.length; start++){
//
//            for(int end = start; end < arr.length; end++){
//                System.out.print("[");
//                for(int k = start; k <= end; k++){
//
//                    System.out.print(arr[k]);
//                }
//                System.out.println("]");
//            }
//        }


    }

    public static void printAllSubarraySums(int[] arr) {
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end]; // extend window and update sum in O(1)
                System.out.printf("subarray (%d,%d) sum=%d%n", start, end, sum);
            }
        }
    }

}
