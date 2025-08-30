package Dsa.Arrays;
import java.util.*;
public class RemoveDuplicateUnsorted {
    static int[] removeDuplicate(int[] arr){
        int index = 0;
        for(int i = 0; i < arr.length; i++){

            for(int j = 0; j < i; j++ ){

                if(arr[j] != arr[i]){
                    arr[index] = arr[i];
                    index++;
                }
            }
        }
        return arr;
    }


    static ArrayList<Integer> removeDup(int[] arr){

        ArrayList<Integer> storeUnique = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){

            if(!storeUnique.contains(arr[i])){
                storeUnique.add(arr[i]);
            }
        }

        return storeUnique;
    }

    public static void main(String[] args) {
        int[] arr =  { 1, 4 ,4 , 6, 3, 4};
        System.out.println(removeDup(arr));
    }
}
