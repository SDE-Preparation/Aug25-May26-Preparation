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

    public static void main(String[] args) {
        int[] arr =  { 1, 4 ,4 , 6, 3, 4};
        System.out.println(Arrays.toString(removeDuplicate(arr)));
    }
}
