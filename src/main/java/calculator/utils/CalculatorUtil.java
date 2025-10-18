package calculator.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorUtil {
    private CalculatorUtil() { }

    public static String sumDelimitedNumbers(String input) {
        String[] numbers;
        if (input.contains("//") && input.contains("\\n")) {
            numbers = customSplit(input);
        } else {
            numbers = defaultSplit(input);
        }
        return "결과 : " + sum(numbers);
    }

    private static String[] defaultSplit(String input) {
        return input.split("[,:]");
    }

    private static String[] customSplit(String input) {
        var temp = input.split("//");
        String delimiter = temp[1].charAt(0) + "";
        return input.split(
                "[,://"
                + delimiter
                + Pattern.quote("\\n")
                + "]"
        );
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(num -> !num.isEmpty())
                .peek(num -> {
                    if(Integer.parseInt(num) < 0) throw new IllegalArgumentException();
                })
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
