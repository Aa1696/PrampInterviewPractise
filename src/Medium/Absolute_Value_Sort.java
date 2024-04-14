package Medium;
import java.util.*;
public class Absolute_Value_Sort {
    static int[] absSort(int[] arr) {
        // your code goes here
        Integer[] arr1= new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            arr1[i] = arr[i];
        }
        Arrays.sort(arr1, (a,b)->Integer.compare(Math.abs(a),Math.abs(b))==0?a<b?-1:1:Integer.compare(Math.abs(a),Math.abs(b)));

        for(int i=0;i<arr.length;i++){
            arr[i] = arr1[i];
        }
        return arr;
    }

}
