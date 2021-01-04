package com.mashibing.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    //1.通过数组来生成
    static void gen1(){
        String[] strs = {"a","b","c","d"};
        Stream<String> str1 = Stream.of(strs);
        str1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

    }
    //1.1
    static void gen2(){
        String[] strs = {"a","b","c","d"};
        Stream<String> str1 = Stream.of(strs);
        str1.forEach(System.out::println);

        //2.通过集合方式生成
        List<String> list = Arrays.asList("1","2","3");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    //3.generate
    static void gen3(){
       /* Stream<Integer> generate = Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        });*/
        Stream<Integer> generate = Stream.generate(() -> {
            int i=1;
            i++;
            return i;
        });
        generate.limit(10).forEach(System.out::println);
    }
    //4.iterator
    static void gen4(){
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }
    //5、其他方式
    static void gen5(){
        String str = "abcdefg";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }
    public static void main(String[] args) {
        //gen1();
        //gen2();
        //gen3();
        //gen4();
        //gen5();
        System.out.println("================================================================");

        //中间操作:如果调用方法之后返回的结果是stream对象，就意味着是一个中间操作
        Arrays.asList(1,2,3,4,5).stream().filter((x)->x%2==0).forEach(System.out::println);
        List<Integer> list = Arrays.asList(1, 5, 3, 413, 5, 6, 7, 8, 9);
        //求偶数和
        int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);

        //求集合中的最大值
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println("集合中的最大值："+max.get());
        System.out.println("集合中的最小值:"+list.stream().min((a, b) -> a - b).get());

        //
        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());

        Optional<Integer> first = list.stream().filter(x -> x % 10 == 6).findFirst();
        System.out.println(first.get());

        //只有执行终止操作的时候，中间操作才会执行。也就是说，执行get()方法了，操作会执行filter中的操作
        Stream<Integer> integerStream = list.stream().filter(i ->{
            System.out.println("运行代码");
            return i%2==0;
        });
        System.out.println(integerStream.findFirst().get());
        System.out.println("==========================================");
        //获取最大值和最小值但是不使用min和max方法
        Optional<Integer> min = list.stream().sorted().findFirst();
        System.out.println(min.get());
        System.out.println(list.stream().sorted((a,b)->b-a).findFirst().get());
        //sorted() 自然排序，按照字母顺序
        Arrays.asList("oj-c","C#","c","python","scala","java","abcdre").stream().sorted().forEach(System.out::println);
        Arrays.asList("oj-c","C#","c","python","scala","java").stream().sorted((a,b)->a.length()-b.length()).forEach(System.out::println);

        System.out.println("==========================================");
        //将集合中的元素进行过滤同时返回一个集合对象
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("=================1========================");
        //去重操作
        Arrays.asList(1,2,3,3,3,7,7,8,9).stream().distinct().forEach(System.out::println);
        System.out.println("=================2========================");
        Arrays.asList(1,2,3,3,3,7,7,8,9).stream().collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("=========================================");
        //打印20-30这样的集合数据
        Stream.iterate(1,x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);
        Stream.iterate(1,x->x+1).skip(20).limit(10).forEach(System.out::println);

        System.out.println("=========================================");
        //字符串切割求和
        String str = "11,22,33,44,55";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x->x).sum());



        int[] ints = Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).toArray();
        /*for (int anInt : ints) {
            System.out.print(anInt+" ");
        }*/
        List<Integer> collect1 = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("==============================================");
        String str2 = "java,scala,python";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        System.out.println("-------------------");
        Stream.of(str2.split(",")).map(x->Person.build(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        //将str中的每一个数值都打印处理，祖红算出最终的求和结果
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).allMatch(x -> x%2 == 0));
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).allMatch(x -> x>0));
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).allMatch(x -> x%2 == 0));
        System.out.println(list.stream().allMatch(x -> x > 0));



    }
}
