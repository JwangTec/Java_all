package Stream_demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: Stream流
 * @USER: jwang
 * @DATE: 2021/2/1 下午2:31
 */
public class Stream_main {
    /**
     *
     * 流式思想：--流不鞥重复使用
     *      搭建好函数模型，并且函数模型中一定有终结的方法
     *          终结方法：返回值类型为Stream的方法,不支持StringBuilder那样的链式调用
     *              --count 统计个数
     *              --forEach(Consumer<? super T> action) 逐一处理
     *                  ---Consumer类型：是一个函数式接口，该接口中的抽象方法为accept(T t) --消费接口
     *          延迟方法：返回值类型不是Stream的方法仍然是Stream接口自身类型的方法，支持链式调用
     *               --filter：过滤
     *                      ---函数式接口：predicate --抽象方法：test ：判断/比较接口
     *               --limit：取前几个  流的元素个数大于参数则进行截取，否则不进行操作，还是上一次流
     *               --skip：跳过前几个 流的元素个数大于参数则进行跳过，否则是一个空流
     *               --map：映射 --将流中的元素从T类型转为R类型，两者可一致也可以不一致
     *                      ---函数式接口：Function --抽象方法：R apply(T t)
     *               --concat：组合--静态方法
     *      Stream流不能重复利用和不会存储数据以及修改数据源
     *
     * collection/map/数组获取流
     *      collection接口：
     *          默认方法：Stream
     *      map:
     *          根据键获取
     *          根据值获取
     *          键值对 对象
     *      数组：
     *              Stream<T> 接口，表示流，T为流中元素的类型
     *                  --方法：of
     *
     * 搜集stream流结果：
     *    Stream接口中方法
     *      搜集到集合中：
     *             <R, A> collect(Collector<? super T,A,B> collector)
     *                  --R:最终流中的数据收集到的单列集合类型，即单列集合的类型
     *                  --Collector<? super T,A,B> collector：决定把流中的元素收集到哪个集合中
     *                          ---Collectors工具类的静态方法：得到接口中的?类型
     *                              toList 转换为list集合
     *                              toSet 转换为set集合
     *       搜集到数组:
     *              toArray()
     *
     */

    public static void main(String[] args) {
//        demo1();
//        demo2_Stream();
//        do_stream();

        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("acd");
        list1.add("ad");
        list1.add("ee");

        final Stream<String> n1 = list1.stream();
        final List<String> collect = n1.collect(Collectors.toList());
        final Set<String> collect1 = list1.stream().collect(Collectors.toSet());
        final Object[] objects = list1.stream().toArray();

    }

    private static void do_stream() {
        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("acd");
        list1.add("ad");
        list1.add("ee");

        list1.stream().forEach((String name)->{
            System.out.println(name);
        });

        //省略格式
        list1.stream().forEach((name)->System.out.println(name));

        final long count = list1.stream().count();

        list1.stream().filter((String name)->{
            System.out.println("test方法");
            return name.startsWith("a");
        }).limit(1).forEach((name)->{
            System.out.println(name);
        });

        final Stream<String> s1 = Stream.of("12", "13");
        s1.map((String str)->str+"aa").forEach(n-> System.out.println(n));
        s1.map((String str)->Integer.valueOf(str)).forEach(n-> System.out.println(n));
    }

    private static void demo2_Stream() {
        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("acd");
        list1.add("ad");
        list1.add("ee");

        //list集合获取流
        final Stream<String> s1 = list1.stream();

        HashMap<Integer, String> h1 = new HashMap<>();
        h1.put(1, "aa");

        Stream<Integer> stream2 = h1.keySet().stream();
        final Stream<String> stream3 = h1.values().stream();
        final Stream<Map.Entry<Integer, String>> stream4 = h1.entrySet().stream();

        int[] arr = {1,2,3,4,5,6};
        final Stream<int[]> arr1 = Stream.of(arr);
        final Stream<Integer> integerStream = Stream.of(1, 2);
    }

    private static void demo1() {
        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("acd");
        list1.add("ad");
        list1.add("ee");

        ArrayList<String> aa = new ArrayList<>();

        for (String name : list1) {
            if(name.startsWith("a")){
                aa.add(name);
            }
        }
        ArrayList<String> ac = new ArrayList<>();
        for (String name : aa) {
            if(name.length() == 3){
                ac.add(name);
            }
        }

        for (String s : ac) {
            System.out.println(s);
        }

        //解决：获得流再过滤打印
        list1.stream().filter(name->name.startsWith("a")).filter(name->name.length() == 3).forEach(name-> System.out.println(name));
    }
}
