package Dsa.Arrays;
import java.util.*;
public class RemoveDuplicates {

    static int[] removeDuplicates(int[] arr){
        int[] temp = new int[arr.length];
        int index = 0;
        temp[0] = arr[0];

        for(int i = 1; i < arr.length ; i++){
            if(temp[index] != arr[i]){
                index++;
                temp[index] = arr[i];
            }
        }

        return temp;
    }

    static ArrayList<Integer> removeDuplicatesGFG(int[] arr) {
        // code here
        int removed_duplicated_count = 0;
        ArrayList<Integer> removedArray = new ArrayList<>();
        removedArray.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(removedArray.get(removed_duplicated_count) != arr[i]){
                removed_duplicated_count++;
                removedArray.add(removed_duplicated_count,arr[i]);
            }
        }

        return removedArray;


    }

    static int[] removeDuplicatesOpt(int[] arr){

        int index = 0;

        for(int i = 1; i < arr.length ; i++){
            if(arr[index] != arr[i]){
                index++;
                arr[index] = arr[i];
            }
        }



        return arr;
    }


    public static void main(String[] args) {
        int[] arr = { 1,3,3,5,5,6,7};

        System.out.println(removeDuplicatesGFG(arr));
    }
}
