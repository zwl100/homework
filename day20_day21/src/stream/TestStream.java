package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) throws IOException {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        //得到list的流stream1
        Stream<Integer> stream1=list1.stream();
        //调用stream的filter()方法，实现的是Predicate接口
        Stream<Integer> stream2=stream1.filter((Integer i) -> {return i%2==0;});
        //要想输出结果，必须使用collect收集器收集.一旦收集，stream1流不可再使用(stream2也是)
        List<Integer> list2=stream2.collect(Collectors.toList());
        System.out.println(list2); //输出[2,4,6]
        //调用stream的map(映射)方法，map方法实现的是Function接口
        //下面代码会有异常：java.lang.IllegalStateException: stream has already been operated upon or closed
        /*Stream<Integer> stream3 = stream2.map(x -> {
            return x * 2;
        });*/
        //所以从list1进行操作
        Stream<Integer>stream4=list1.stream().filter( x -> {return x%2==0;}).map(x -> {return x*2;});
        //查看结果
        List<Integer> list4=stream4.collect(Collectors.toList());
        System.out.println(list4);


        /* **************************************
         * lambda在遇到终结方法前是懒惰的,不会执行
         * 下面的代码不会输出任何东西
         */
        List<Integer> list5=Arrays.asList(2,3,5,6,8,7);
        list5.stream().filter(x -> {
            System.out.println("filter执行了");
            return x%2==0;
        }).map(x -> {
            System.out.println("map被执行了");
            return x+3;
        });
        //若遇到collect方法,则会执行
        List<Integer> list6=Arrays.asList(2,3,5);
        list6.stream().filter(x -> {
            System.out.println("filter执行了"+x);
            return x%2==0;
        }).map(x -> {
            System.out.println("map被执行了"+x);
            return x+3;
        }).collect(Collectors.toList());

        //生成流的几种方法
        //数字生成流
        IntStream intStream = IntStream.of(5, 6, 7, 8, 9);
        OptionalInt max = intStream.max();
        System.out.println(max);//输出为OptionalInt[9]
        //数组生成流
        int[] a={1,2,3,4,5};
        IntStream stream = Arrays.stream(a);



        /* ********************************************************
          常用方法,max,min
         */
        List<Integer> list7 = Arrays.asList(1,5,7,3);
        Optional<Integer> maxInteger = list7.stream().max((x1, x2) -> {
            return x1.compareTo(x2);
        });
        System.out.println(maxInteger); //输出Optional[7]

        Optional<Integer>  minInteger = list7.stream().min((x1, x2) -> {
            return x1.compareTo(x2);
        });
        System.out.println(minInteger);//输出Optional[1]

        //遍历集合
        List<Integer> list8=new ArrayList<>();
        list8.add(8);
        list8.add(8);
        list8.add(6);
        list8.add(4);
        list8.forEach( x -> {
            System.out.println(x);
        });
        //遍历流
        Stream<String> stream8 = Files.lines(Paths.get("D:\\IdeaProjects\\homework_zwl\\day20_day21\\src\\1.txt"));
        stream8.forEach(x -> {
            System.out.println(x);
        });

        /* *************************************************
            方法引用：是对lambda表达式的扩展
         */
        //Stream中的generate()方法要实现的是Supplier接口，没有参数列表，有返回值
//        Random r = new Random();
//        Stream<Integer> integerStream = Stream.generate(() -> {
//            return r.nextInt(100); //生成100以内的随机数
//        });
//        Stream<Integer> limit = integerStream.limit(5); //生成数量为5个
//        limit.forEach(x -> System.out.println(x));
        Random r = new Random();
        Stream.generate( () -> r.nextInt(100) ).limit(5).forEach( x->System.out.println(x) );
        //下面的与上面等价 对象::方法名
        Stream.generate( () -> r.nextInt(100) ).limit(5).forEach( System.out::println );

        //类名::方法名
        List<Integer> list = Arrays.asList(7,6,5);
        list.stream().filter(x -> x%2==0);
        //下面的和上面的等价
        //在外面定义一个test静态方法
        list.stream().filter(TestStream::test);
    }
    public static boolean test(Integer i){
        return i%2==0;
    }

}
