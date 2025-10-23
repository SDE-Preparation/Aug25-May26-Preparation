package Dsa.Arrays.Subarrays;

import java.util.*;

public class LongestSubArray {
    public static int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            // If (sum - k) was seen before, subarray between (oldIndex+1 → i) = k
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.min(maxLen, len);
            }

            // Store first occurrence only (for longest)
            map.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1, 1};
        int k = 3;
        System.out.println("Longest subarray length = " + longestSubarray(arr, k));
    }
}
