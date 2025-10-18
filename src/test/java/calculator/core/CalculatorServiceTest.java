package calculator.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void 요청_인자가_없을_경우_0을_반환한다() {
        //When
        int result = calculatorService.add("");

        //Then
        assertEquals(0, result);
    }
}