package Thread_Learning;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Concurrent_Hash_Map {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer>mp1 = new ConcurrentHashMap<>();
        HashMap<Integer,Integer>mp2 = new HashMap<>();
        for(int i=0;i<5;i++){
            mp1.put(i,i);
            mp2.put(i,i);
        }
        Logger log = Logger.getLogger(String.valueOf(ConcurrentHashMap.class));
        Semaphore lock = new Semaphore(3);
        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 60;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor poolexecutor = new ThreadPoolExecutor(
                corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue,Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        Future<?>obj = poolexecutor.submit(()->{
            try{
                Thread.sleep(7000);
                System.out.println("This is the task , which main thread will execute");
            }
            catch (Exception e){

            }
        });
        System.out.println("Is the thread gets exausted"+ obj.isDone());
        try{
            obj.get(2,TimeUnit.SECONDS);
            System.out.println("");

        }
        catch(Exception e){
            System.out.println("Time Out Exception occured");
        }
        try{
            obj.get();
        }
        catch(Exception e){
            System.out.println("Exception occure");
        }
        CompletableFuture fut = new CompletableFuture<>();
        System.out.println("Is child thread of main thread completed or not "+ obj.isDone());
        System.out.println("Is Child thread gets cancelled or not "+ obj.isCancelled());
        //Pattern pat = Pattern.compile()
    }

}
