package calculator.core;

import calculator.utils.CalculatorUtil;

public class CalculatorService {
    public int add(String input) {
        if (input.isBlank()) {
            return 0;
        }

        return CalculatorUtil.sumDelimitedNumbers(input);
    }
}
