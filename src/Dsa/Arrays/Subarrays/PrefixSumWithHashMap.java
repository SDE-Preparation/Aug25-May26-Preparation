package Dsa.Arrays.Subarrays;
import java.util.*;
public class PrefixSumWithHashMap {

    public static void main(String[] args) {
        int[] arr = {
                1, 3, 5, 6, 8
        };

        int target = 6;

        System.out.println(subarraySum(arr, target));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // base case

        for (int num : nums) {
            sum += num;

            // if prefix[r] - k exists, we found valid subarray(s)
            if (prefixMap.containsKey(sum - k)) {
                count += prefixMap.get(sum - k);
            }

            // store prefix sum occurrence
            prefixMap.put(sum, prefixMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
