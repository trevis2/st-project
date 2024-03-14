package it.trevisan.simone;

import static org.assertj.core.api.Assertions.*;

public class Main {
    public static void main(String[] args) {
        assertThat(fizzBuzz(3)).isEqualTo("1,2,Fizz");
        assertThat(fizzBuzz(5)).isEqualTo("1,2,Fizz,4,Buzz");
        assertThat(fizzBuzz(10)).isEqualTo("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz");
        assertThat(fizzBuzz(15)).isEqualTo("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz");
        assertThat(fizzBuzz(20))
                .isEqualTo("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz");
        assertThat(fizzBuzz(30)).isEqualTo(
                "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz,Fizz,22,23,Fizz,Buzz,26,Fizz,28,29,FizzBuzz");
        assertThat(fizzBuzz(100)).isEqualTo(
                "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16,17,Fizz,19,Buzz,Fizz,22,23,Fizz,Buzz,26,Fizz,28,29,FizzBuzz,31,32,Fizz,34,Buzz,Fizz,37,38,Fizz,Buzz,41,Fizz,43,44,FizzBuzz,46,47,Fizz,49,Buzz,Fizz,52,53,Fizz,Buzz,56,Fizz,58,59,FizzBuzz,61,62,Fizz,64,Buzz,Fizz,67,68,Fizz,Buzz,71,Fizz,73,74,FizzBuzz,76,77,Fizz,79,Buzz,Fizz,82,83,Fizz,Buzz,86,Fizz,88,89,FizzBuzz,91,92,Fizz,94,Buzz,Fizz,97,98,Fizz,Buzz");
    }

    public static String fizzBuzz(int n) {
        String compositeString = "";
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                compositeString += "FizzBuzz";
            } else if (i % 3 == 0) {
                compositeString += "Fizz";
            } else if (i % 5 == 0) {
                compositeString += "Buzz";

            } else {
                compositeString += i;
            }
            if (i != n) {
                compositeString += ",";
            }
        }
        return compositeString;
    }
}