package Dsa.Arrays.Sorting;

import java.util.Arrays;

public class SelectionSort {


    static void selectionSort(int[] arr){

        int temp = 0;
        for(int i = 0; i < arr.length; i++){

            temp = i;

            for(int j = i + 1; j < arr.length; j++){

                if(arr[temp] > arr[j]){
                    temp = j;
                }
            }

            if( temp > i){
                swap(i,temp,arr);
            }


        }

        System.out.println(Arrays.toString(arr));

    }

    static void swap(int high, int low, int[] arr){

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

    }
    public static void main(String[] args) {

        int[] arr = {
                4, 2, 5, 1, 6
        };

        selectionSort(arr);
    }
}
