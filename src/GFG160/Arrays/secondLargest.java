package GFG160.Arrays;

class secondLargest {
    public static int getSecondLargest(int[] arr) {
        // code here

        if(arr.length < 2){
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length ; i++){
            if(largest < arr[i]){
                secLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secLargest && secLargest < largest){

                secLargest = arr[i];

            }
        }

        if(secLargest == largest){
            return -1;
        }

        return secLargest;
    }

    public static void main(String[] args) {
        int[] arr = {
                20769,19913,16575
        };

        System.out.println(getSecondLargest(arr));
    }
}