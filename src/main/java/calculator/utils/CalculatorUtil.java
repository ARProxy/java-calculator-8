package calculator.utils;

import java.util.Arrays;

public class CalculatorUtil {
    private CalculatorUtil() { }

    public static int sumDelimitedNumbers(String input) {
        var numbers = input.split("[,:]");
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
