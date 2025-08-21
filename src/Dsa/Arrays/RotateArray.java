package Dsa.Arrays;
import java.util.Arrays;
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4};

        int rotateCount = 10;
        int rotateOptimize;
        if(rotateCount < 0){
            rotateOptimize = rotateCount + arr.length;
        }else{
            rotateOptimize = rotateCount % arr.length;
        }

//        rotateLeft(arr,rotateOptimize);

        rotateRight(arr,rotateOptimize);

    }

    public static void rotateLeft(int[] arr, int rotateOptimize){
        for(int i=0;i < rotateOptimize; i++){
            System.out.println("i :" + i);
            int temp = arr[0];

            for(int j= 1; j< arr.length; j++){
                arr[j-1] = arr[j];
            }

            arr[arr.length - 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void rotateRight(int[] arr, int rotateOptimize){
        int temp = arr[arr.length - 1];

        for(int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i-1];
        }

        arr[0] = temp;
        for(int each : arr){
            System.out.printf(each + " ");
        }

    }
}
