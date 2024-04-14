package Medium;

public class H_Tree_Construction {
    static public void drawHtree(int x, int y, int length, int depth){
        if(depth==0)
            return;

        int x1=x-length/2;
        int x2=x+length/2;
        int y1=y-length/2;
        int y2=y+length/2;

        draw(x1,y1, x1,y2);
        draw(x2,y1, x2,y2);
        draw(x1,y,  x2,y);

        int new_length = length/(int)Math.sqrt(2);

        drawHtree(x1,y1,new_length,depth-1);
        drawHtree(x1,y2,new_length,depth-1);
        drawHtree(x2,y2,new_length,depth-1);
        drawHtree(x2,y1,new_length,depth-1);
    }
    public static void draw(int x0, int y0 , int x1, int y1){
        int dist1 = Math.abs(x1-x0);
        int dist2 = Math.abs(y1-y0);
        int dist=(int)Math.sqrt(dist1* dist1 + dist2*dist2);
    }
}
