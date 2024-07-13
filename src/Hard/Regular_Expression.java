package Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class Regular_Expression {
    static boolean isMatch(String text, String pattern) {
        // your code goes here
        //ArrayList<Integer>arr = new ArrayList<>(new int[]{1, 2, 3, 4, 5, 6});
        //arr.stream().max(Integer::compareTo);
        return helper(text,pattern,0,0);
        //int[]arr = {2,1,4,5};
        //Arrays.stream(arr).max();
    }


    static boolean helper(String text, String pattern, int tindx, int pindx){
        if (tindx>=text.length()) {
            if(pindx>=pattern.length()) return true;
            else{
                if(pindx+1<pattern.length() && pattern.charAt(pindx+1)=='*'){
                    return helper(text,pattern,tindx,pindx+2);
                }
                else{
                    return false;
                }
            }
        }
        else if(pindx>=pattern.length() && tindx<text.length()){
            return false;
        }
        else if(pindx+1<pattern.length() && pattern.charAt(pindx+1)=='*'){
            if(pattern.charAt(pindx)=='.' || pattern.charAt(pindx)==text.charAt(tindx)){
                return helper(text,pattern, tindx+1,pindx) || helper(text,pattern,tindx,pindx+2);
            }
            else{
                return helper(text,pattern,tindx,pindx+2);
            }
        }
        else if(pattern.charAt(pindx)=='.' || pattern.charAt(pindx)==text.charAt(tindx)){
            return helper(text,pattern,tindx+1,pindx+1);
        }
        else{
            return false;
        }
    }
}
