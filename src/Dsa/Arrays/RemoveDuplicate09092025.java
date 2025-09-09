package Dsa.Arrays;
import java.util.*;
public class RemoveDuplicate09092025 {

    public static void main(String[] args) {
        int[] arr = {
                2, 4, 5, 3, 2 , 3
        };

        System.out.println(showDup(arr));
    }

    static ArrayList<Integer> showDup(int[] arr){

        if(arr.length == 0){
            return new ArrayList<>();
        }
        ArrayList<Integer> newArr = new ArrayList<>();
//        for(int i = 0; i < arr.length; i++){
//
//            for(int j = i + 1; j < arr.length; j++){
//
//                if(arr[i] == arr[j]){
//                    newArr.add(arr[j]);
//                }
//            }
//        }

        HashSet<Integer> dup = new HashSet<>();
        dup.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(dup.contains(arr[i])){
                newArr.add(arr[i]);
            }else{
                dup.add(arr[i]);
            }
        }


        return newArr;
    }

    HashSet<Integer> seen = new HashSet<>();
    for(int num : arr) {
        if(!seen.add(num)) {  // add() returns false if already present
            newArr.add(num);
        }
    }


}
