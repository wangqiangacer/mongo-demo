package com.jacken.springbootdemo.utils;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
// 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            System.out.println(price);
//        }
//        costBeforeTax.stream().map((cost)->cost+.12*cost).forEach(s->{
//            System.out.println(s);
//        });

//        Double aDouble = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
//        System.out.println(aDouble);
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        //map  是对原始中的值做映射操作
//        String collect = G7.stream().map(x -> x.toUpperCase()).map(x->x.toLowerCase()).collect(Collectors.joining("-"));
//        List<String> list = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
//        List<String> list = G7.stream().map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println(list);

        // 用所有不同的数字创建一个正方形列表,我们可以使用lambda的distinct对生成后的值去重
//        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
//        List<Integer> list = numbers.stream().map(x -> x * x).distinct().collect(Collectors.toList());
//        System.out.println(list);

        //获取数字的个数、最小值、最大值、总和以及平均值
       // List<Integer> primes = Arrays.asList(2, 3, 9, 7, 11, 13, 17, 19, 23, 29);
        //统计返回对象
//        IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
//        System.out.println("Highest prime number in List : " + stats.getMax());
//        System.out.println("Lowest prime number in List : " + stats.getMin());
//        System.out.println(stats.getSum());
//        System.out.println(stats.getAverage());




    }
}
