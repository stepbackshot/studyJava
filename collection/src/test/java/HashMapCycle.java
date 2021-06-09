import mapUtil.HashMapUtil;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Harden
 * @title: HashMapCycle
 * @date 2021年02月26日 18:17
 * <p>
 * 所有被添加了 @Benchmark 注解的方法都会被测试
 */
@BenchmarkMode(Mode.Throughput) // 测试类型：吞吐量
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2,
        time = 1,
        timeUnit = TimeUnit.SECONDS) // 预热 2 轮，每次 1s
@Measurement(iterations = 5,
             time = 3,
             timeUnit = TimeUnit.SECONDS) // 测试 5 轮，每次 3s
@Fork(1) // fork 1 个线程
@State(Scope.Thread) // 每个测试线程一个实例
public class HashMapCycle
{
    static String PATH = "/Users/c5289030/SAPDevelop/studyJava/collection/src/test/java";
    static Map<Integer, String> map = new HashMap()
    {{
        // 添加数据
        for (int i = 0; i < 10; i++) {
            put(i,
                "val:" + i);
        }
    }};

    public static void main (String[] args) throws RunnerException
    {
        // 启动基准测试
        Options opt = new OptionsBuilder().include(HashMapCycle.class.getSimpleName()) // 要导入的测试类
                        .output(PATH + "/jmh-mapUtil.log") // 输出测试结果的文件
                        .build();
        new Runner(opt).run(); // 执行测试
//        entrySet();
//        forEachKeySet();
//        keySet();
//        streamApi();
//        parallelStreamApi();
    }

    @Benchmark
//    @Test
    public static void entrySet ()
    {
        HashMapUtil.traverseByEntrySetIterator(map);
    }

    @Benchmark
//    @Test
    public static void keySet ()
    {
        HashMapUtil.traverseByKeySet(map);
    }

    @Benchmark
//    @Test
    public static void forEachKeySet ()
    {
        HashMapUtil.traverseByEntrySet(map);
    }

    @Benchmark
//    @Test
    public static void lambda ()
    {
        HashMapUtil.traverseByLambda(map);
    }

    @Benchmark
//    @Test
    public static void streamApi ()
    {
        HashMapUtil.traverseBySingleStreams(map);
    }

    @Benchmark
//    @Test
    public static void parallelStreamApi ()
    {
        HashMapUtil.traverseByMultiStreams(map);
    }
}
