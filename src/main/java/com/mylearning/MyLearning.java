package com.mylearning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyLearning {

    /**
     * trying https://www.ibm.com/developerworks/library/j-java8idioms11/index.html
     * @param args
     */
    public static void main (String[] args) {
        /**listPreJava8();
        listJava8();
        //should take ~10 sec to run
        stream();
        //runs paralleling and takes lesser time
         parallelstream();*/
        //impure function
        impureFunction();
    }

    private static void impureFunction() {
        System.out.println("Impure function started...");
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        int[] factor = new int[] { 2 };
        Stream<Integer> stream = numbers.stream()
                .map(e -> e * factor[0]);
        stream.forEach(System.out::println);
        factor[0] = 0;

        stream.forEach(System.out::println);
    }

    private static void listJava8() {

        List<Integer> numbers = Arrays.asList(2, 5, 8, 15, 12, 19, 50, 23);
        
        String s =
                numbers.stream()
                        .peek(e-> print2(e))
                        .filter(e -> e > 10)
                        .filter(e -> e % 2 == 0)
                        .peek(e-> print2(e))
                        .map(e -> e * 2)
                        .findFirst()
                        .map(e -> "The value is " + e)
                        .orElse("No value found");
        System.out.println(s);
    }

    private static void print2(int i) {
        System.out.println(i);
    }

    private static void listPreJava8() {
        List<Integer> numbers = Arrays.asList(2, 5, 8, 15, 12, 19, 50, 23);
        Integer result = null;
        for(int e : numbers) {
            if(e > 10 && e % 2 == 0) {
                result = e * 2;
                break;
            }
        }

        if(result != null)
            System.out.println("The value is " + result);
        else
            System.out.println("No value found");
    }


    static int simulateTimeConsumingComputation(int number) {
        try { 
            Thread.sleep(1000); 
        } catch(Exception ex) {
            //do nothing
        }
        return number * 2;
    }

    static void stream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .map(MyLearning::simulateTimeConsumingComputation)
                .forEachOrdered(System.out::println);
    }

    static void parallelstream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .parallel()
                .map(MyLearning::simulateTimeConsumingComputation)
                .forEachOrdered(System.out::println);
    }
}
