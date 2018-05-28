package com.mylearning;

/**
 * Difference between equals to and ==.
 */
public class EqualsAndEqualEqual {
    static String str1 = "one";
    static String first = "one"; 

    public static void main(String[] args) {
        System.out.println("using == operator " + (str1 == first));  //== is operator. Will return false
        System.out.println("using equals method " + str1.equals(first)); //equals is a method that could be overridden 

    }
}
