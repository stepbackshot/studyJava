package mapUtil;
/*
    Copyright (c) 2021 Ariba, Inc.
    All rights reserved. Patents pending.

    $Id$

    Responsible: c5289030
*/

import java.util.Iterator;
import java.util.Map;

/**
 * HashMap 4 大类（迭代器、for、lambda、stream）遍历方式，以及具体的 7 种遍历方法，除了 Stream 的并行循环，
 * 其他几种遍历方法的性能差别不大，但从简洁性和优雅性上来看，Lambda 和 Stream 无疑是最适合的遍历方式。
 * 除此之外我们还从「安全性」方面测试了 4 大类遍历结果，从安全性来讲，我们应该使用迭代器提供的 iterator.remove()
 * 方法来进行删除，这种方式是安全的在遍历中删除集合的方式，或者使用 Stream 中的 filter 过滤掉要删除的数据再进行循环，
 * 也是安全的操作方式。
 */
public class HashMapUtil
{

    public static void traverseByEntrySetIterator (Map map)
    {
        Iterator<Map.Entry> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            System.out.println("Key:" + entry.getKey() + "  Value:" + entry.getValue());
        }
    }

    public static void traverseByEntrySet (Map map)
    {
        for (Object entry : map.entrySet()) {
            System.out.println(
                            "Key:" + ((Map.Entry)entry).getKey() + "  Value:" + ((Map.Entry)entry)
                                            .getValue());
        }
    }

    public static void traverseByKeySet (Map map)
    {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("Key:" + key + "  Value:" + map.get(key));

        }
    }

    public static void traverseByLambda (Map map)
    {
        map.forEach((key, value) -> {
            System.out.println("Key:" + key + "  Value:" + value);
        });
    }

    public static void traverseBySingleStreams (Map map)
    {
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(
                            "Key:" + ((Map.Entry)entry).getKey() + "  Value:" + ((Map.Entry)entry)
                                            .getValue());
        });
    }

    public static void traverseByMultiStreams (Map map)
    {
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(
                            "Key:" + ((Map.Entry)entry).getKey() + "  Value:" + ((Map.Entry)entry)
                                            .getValue());
        });
    }
}
