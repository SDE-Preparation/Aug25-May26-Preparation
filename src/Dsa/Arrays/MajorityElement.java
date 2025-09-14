package Dsa.Arrays;

import java.util.*;
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {
                1, 1, 2, 1, 3, 5, 1
        };

        System.out.println(showMajority(arr));
    }

    static int showMajority(int[] arr){

        if(arr.length == 1){
            return arr[0];
        }

        HashMap<Integer,Integer> newarr = new HashMap<>();
        int len = arr.length / 2;

        for(int i = 0; i < arr.length; i++){

            if(!newarr.containsKey(arr[i])){
                newarr.put(arr[i],1);
            }else{
                newarr.replace(arr[i], newarr.getOrDefault(arr[i], 0) + 1);
            }
        }

        System.out.print(len);


        for(Integer eachElement : newarr.keySet()){

            if(newarr.get(eachElement) > len){
                return eachElement;
            }
        }

        return -1;
    }

}
