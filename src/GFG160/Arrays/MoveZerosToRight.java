package GFG160.Arrays;
import java.util.*;
public class MoveZerosToRight {
    public static void main(String[] args) {
        int[] arr = {
                1, 2, 0, 4, 3, 0, 5, 0
        };

        System.out.println(Arrays.toString(moveZeroToRight(arr)));
    }

//    static int[] moveZeroToRight(int[] arr){
//
//        int temp;
//        for(int i = 0; i< arr.length;i++){
//            if(i != arr.length -  1){
//                if(arr[i] == 0 && arr[i+1] != 0){
//                    temp = arr[i+1];
//                    arr[i+1] = arr[i];
//                    arr[i] = temp;
//
//                }else if(arr[i] == 0 && arr[i+1] == 0){
//                    i = i+2;
//                }
//            }
//
//        }
//
//        return arr;
//
//    }

    static int[] moveZeroToRight(int[] arr){

        int temp = 0;
        int[] newArr = new int[arr.length];

        for(int i = 0; i< arr.length;i++){


            if(arr[i] != 0){
                newArr[temp] = arr[i];
                temp++;
            }



        }

        arr = newArr;
        return arr;

    }
}
