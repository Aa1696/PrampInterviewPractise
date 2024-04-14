package Hard;
import java.util.*;
public class Shortest_Cell_Path {
    static class Pair{
        int x,y,d;
        Pair(int x, int y , int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }

    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here
        int n = grid.length;
        int m= grid[0].length;
        //distance matrix will calcuate the distance from the source
        int[][]dist = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        int[][]dir = {{1,0},{-1,0},{0,-1},{0,1}};
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.d-b.d);
        pq.add(new Pair(sr,sc,0));
        dist[sr][sc]=0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int i=0;i<dir.length;i++){
                int x = dir[i][0] + p.x;
                int y= dir[i][1] +p.y;
                if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1 && dist[x][y]>1+dist[p.x][p.y]){
                    dist[x][y] = 1+ dist[p.x][p.y];
                    pq.add(new Pair(x,y,dist[x][y]));
                }
            }
        }
        return dist[tr][tc]==Integer.MAX_VALUE?-1:dist[tr][tc];
    }
}
