package Easy;

public class Toe_Plitz_Matrix {
    static boolean isToeplitz(int[][] arr) {
        // your code goes here
        int row = arr.length;
        int col = arr[0].length;
        for(int i=0;i<row-1;i++){
            for(int j=0;j<col-1;j++){
                if(arr[i][j] != arr[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
