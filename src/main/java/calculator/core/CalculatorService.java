package calculator.core;

import calculator.utils.CalculatorUtil;

public class CalculatorService {
    public String add(String input) {
        if (input.isBlank()) {
            return "결과 : 0";
        }

        try {
            return CalculatorUtil.sumDelimitedNumbers(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
