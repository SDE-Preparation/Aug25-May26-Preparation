package Dsa.Arrays.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {
                2,4,4,7,1,5
        };

        System.out.println(Arrays.toString(sortBubble(arr)));
    }

    static int[] sortBubble(int[] arr){




        for(int i = 0; i < arr.length; i++){
            int first = 0;
            int sec = 1;
            for(int j = 0; j < arr.length - 1; j++){

                if( arr[first] > arr[sec]){
                    int temp = arr[first];
                    arr[first] = arr[sec];
                    arr[sec] = temp;

                }
                first++;
                sec++;
            }
        }


        return arr;
    }


}
