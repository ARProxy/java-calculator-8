package calculator.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private CalculatorService calculatorService;
    private String[] inputs;
    private String[] customInputs;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
        inputs = new String[]{
                "1,2",
                "1,2,3",
                "1,2:3"
        };
        customInputs = new String[]{
                "//;\\n1;2;3",
                "1//;\\n2:3;4"
        };
    }

    @Test
    void 요청_인자가_없을_경우_0을_반환한다() {
        //When
        int result = calculatorService.add("");

        //Then
        assertEquals(0, result);
    }

    @Test
    void 쉼표_또는_클론_구분자로_문자열을_분리하고_합을_반환한다() {
        //When
        int result0 = calculatorService.add(inputs[0]);
        int result1 = calculatorService.add(inputs[1]);
        int result2 = calculatorService.add(inputs[2]);

        //Then
        assertEquals(3, result0);
        assertEquals(6, result1);
        assertEquals(6, result2);
    }

    @Test
    void 커스텀_구분자로_문자열을_분리하고_합을_반환한다() {
        //When
        int result0 = calculatorService.add(customInputs[0]);
        int result1 = calculatorService.add(customInputs[1]);

        //Then
        assertEquals(6, result0);
        assertEquals(10, result1);
    }
}