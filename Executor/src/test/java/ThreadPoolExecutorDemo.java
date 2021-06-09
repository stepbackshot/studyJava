import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo
{
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main (String[] args)
    {
//        normalTestCase();
        normalTestCaseForQueue();
    }

    /**
     *
     */
    public static void normalTestCase(){
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                                                             MAX_POOL_SIZE,
                                                             KEEP_ALIVE_TIME,
                                                             TimeUnit.SECONDS,
                                                             new ArrayBlockingQueue(QUEUE_CAPACITY),
                                                             new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

    public static void normalTestCaseForQueue(){
        /**
         * ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                                                             MAX_POOL_SIZE,
                                                             KEEP_ALIVE_TIME,
                                                             TimeUnit.SECONDS,
                                                             new ArrayBlockingQueue(QUEUE_CAPACITY));

        for (int i = 0; i < 100; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
