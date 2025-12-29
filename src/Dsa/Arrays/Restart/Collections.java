package Dsa.Arrays.Restart;
import java.util.*;
public class Collections {
    public static void main(String[] args) {

        int[] a;
        /*
        * List is like same arrays with dynmaic size
        * add for adding element and we can able to insert between two element eg. add(5) for adding the element and add(4,5) inserting the 5 in 4th index
        * set
        * */

        ArrayList<Integer> orderedArray = new ArrayList<>(5);

        orderedArray.add(4);
        orderedArray.add(2);
        orderedArray.add(6);
        orderedArray.add(8);

        orderedArray.set(2, 10);
        orderedArray.add(5);
        orderedArray.add(3);

        System.out.println(orderedArray.size());
    }
}
