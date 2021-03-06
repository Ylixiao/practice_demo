package com.sys.tryxx.practiceJava8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8新特性补充
 */
public class Fangbuxiala {
    public static void main(String[] args) {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String merge = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining("-"));
        System.out.println("合并字符串: " + merge);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        //IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        IntSummaryStatistics stats = numbers.stream().mapToInt((x)->x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

}
