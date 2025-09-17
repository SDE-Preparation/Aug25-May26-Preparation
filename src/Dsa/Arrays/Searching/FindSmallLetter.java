package Dsa.Arrays.Searching;

public class FindSmallLetter {


    public static void main(String[] args) {
        char[] arr = {
                'a' , 'c', 'e', 'f'
        };

        System.out.println(findSmall(arr));
    }

    static char findSmall(char[] arr){


        int start = 0;
        int end = arr.length - 1;
        char target = 'c';
        while(start <= end ){

            int mid = start + (end - start) / 2;

            if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return arr[start % arr.length];
    }
}
