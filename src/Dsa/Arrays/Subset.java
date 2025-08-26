package Dsa.Arrays;

import java.util.HashMap;

public class Subset {

    public static Boolean isSubset(int[] main, int[] sub){
        if(sub.length > main.length){
            return false;
        }
        Boolean isThere = false;

        for(int eachSub : sub){
            isThere = false;
            for(int eachMain : main){
                if(eachMain == eachSub){
                    isThere = true;

                    break;
                }
            }

            if(!isThere){
                return false;
            }
        }

        return true;
    }

    public static Boolean isSubset2(int[] main, int[] sub){
        HashMap<Integer,Integer> mainCount = new HashMap<>();
        HashMap<Integer,Integer> subCount = new HashMap<>();
        int count = 0;
        for(int i = 0; i< main.length; i++){
            count = 0;
            for(int j = 0; j< main.length; j++){
                if(main[i] == main[j]){
                    count++;
                }
            }
            mainCount.put(main[i],count);
        }
        for(int i = 0; i< sub.length; i++){
            count = 0;
            for(int j = 0; j< sub.length; j++){
                if(sub[i] == sub[j]){
                    count++;
                }
            }
            subCount.put(sub[i],count);
        }
        Boolean keyExist = false;
        for(Integer subKey : subCount.keySet()){
            keyExist = false;
            for (Integer key : mainCount.keySet()) {
                if(subKey.equals(key)){
                    keyExist = true;
                    if(mainCount.get(key) < subCount.get(subKey)){
                        return false;
                    }
                }
            }
            if(!keyExist){
                return false;
            }
        }
        return true;

    }

    public static boolean isSubsetOpt(int[] main, int[] sub) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequencies of main array
        for (int num : main) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            // number , count
            // number , if exist add extra 1, if nothing means set 0
        }

//        System.out.println(freq);

        // Check sub elements against main frequencies
        for (int num : sub) {
            if (!freq.containsKey(num) || freq.get(num) == 0) {
                return false; // not enough or missing
            }
            freq.put(num, freq.get(num) - 1); // consume one occurrence
        }

        return true;
    }

    public static void main(String[] args) {
        int[] main = { 1, 2, 2, 3, 3, 3};
        int[] sub = { 3, 2, 3};

        System.out.println(isSubsetOpt(main,sub));
    }
}

