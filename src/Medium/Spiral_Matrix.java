package Medium;
import java.util.*;
public class Spiral_Matrix {
    static int[] spiralCopy(int[][] inputMatrix) {
        // your code goes here
        int r=inputMatrix.length;
        int c=inputMatrix[0].length;
        int row=0;
        int col=0;
        ArrayList<Integer>arr=new ArrayList<>();
        while(row<r && c>col){
            //adding the elements of row
            for(int i=col;i<c;i++){
                arr.add(inputMatrix[row][i]);
            }
            row=row+1;
            //adding the elements of cuurent coumn
            for(int i=row;i<r;i++){
                arr.add(inputMatrix[i][c-1]);
            }
            c=c-1;
            if(r>row){
                for(int i=c-1;i>=col;i--){
                    arr.add(inputMatrix[r-1][i]);
                }
                r -=1;
            }
            if(c>col){
                for(int i=r-1;i>=row;i--){
                    arr.add(inputMatrix[i][col]);
                }
                col +=1;
            }
        }
        int[]ans=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }

}
