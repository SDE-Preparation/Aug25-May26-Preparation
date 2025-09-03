package Dsa.Arrays;
import java.util.*;
public class NextImmidiateElement {


    static List<Integer> find(int[] arr){

        List<Integer> newarr = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){

            if(i != arr.length - 1 && arr[i] > arr[i + 1]){
                newarr.add(arr[i + 1]);
            }else{
                newarr.add(-1);
            }
        }

        return newarr;
    }
    public static void main(String[] args) {
        int[] arr = {
                1, 5, 4, 2, 6
        };

        System.out.println(find(arr));
    }
}
