package GFG160.Arrays;

class secondLargest {
    public static int getSecondLargest(int[] arr) {
        // code here

        if(arr.length <= 1){
            return -1;
        }
        int largest = arr[0];
        int secLargest = largest;

        for(int i = 1; i < arr.length ; i++){

            if(largest < arr[i]){

                if(largest != secLargest){
                    secLargest = largest;
                }
                largest = arr[i];
            }


        }

        if(secLargest == largest){
            return -1;
        }

        return secLargest;
    }

    public static void main(String[] args) {
        int[] arr = {
                12, 35, 1, 10, 34, 1
        };

        System.out.println(getSecondLargest(arr));
    }
}