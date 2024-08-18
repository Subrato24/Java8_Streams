package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        List<List<String>> listoflist = Arrays.asList(
                Arrays.asList("apple", "mango", "banana"),
                Arrays.asList("pen", "paper", "stone"),
                Arrays.asList("java", "stone", "sql")
        );
        List<String> result = listoflist.stream()
                .flatMap(l -> l.stream())
                .filter(l -> l.startsWith("s"))
                .map(l -> l.toUpperCase())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
        System.out.println("-------------------------------------");
        result.forEach(elements -> System.out.println(elements));
        System.out.println("-------------------------------------");
        result.stream().forEach(d -> System.out.println(d));
        System.out.println("-------------------------------------");
        long count = result.stream().count();
        System.out.println("No of data in stream = " + count);
        System.out.println("-------------------------------------");
        String firstElement = result.stream().findFirst().orElseThrow(() -> new NoSuchElementException("No element in stream"));   //return optional
        System.out.println(firstElement);
        System.out.println("-------------------------------------");
        boolean match = result.stream().allMatch(data -> data.startsWith("S"));
        System.out.println(match);
    }
}
