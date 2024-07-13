package Thread_Learning;

import java.io.Serializable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer> {
    private static int THRESH_HOLD = 5;
    private int[]arr;
    private int start;
    private int end;

    SumTask(int[]arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        if(end - start < THRESH_HOLD){
            System.out.println("Current thread if "+ Thread.currentThread().getName());
            for(int i = start; i <= end; i++){
                sum += arr[i];
            }
        }
        else{
            System.out.println("Current thread else "+ Thread.currentThread().getName());
            int mid = (start + end)/2;
            SumTask lefttask = new SumTask(arr,start,mid);
            SumTask righttask = new SumTask(arr,mid+1,end);
            lefttask.fork();
            righttask.fork();
            sum = lefttask.join() + righttask.join();
        }
        return sum;
    }
}

public class ForkJoin_Pool implements Serializable {

    public static void main(String[] args) {
        int[]arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = i+1;
        }
        System.out.println("Current Thread Name "+ Thread.currentThread().getName());
        ForkJoinPool pool = ForkJoinPool.commonPool();
        //task is to add the number of the arr
        SumTask task = new SumTask(arr,0,arr.length-1);
        int result = pool.invoke(task);
        System.out.println("Sum of the computed task :"+ result);
    }
}
