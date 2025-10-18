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
        // When
        String result = calculatorService.add("");

        // Then
        assertEquals("결과 : 0", result);
    }

    @Test
    void 쉼표로_구분된_숫자의_합을_반환한다() {
        // When
        String result = calculatorService.add("1,2");

        // Then
        assertEquals("결과 : 3", result);
    }

    @Test
    void 콜론으로_구분된_숫자의_합을_반환한다() {
        // When
        String result = calculatorService.add("1:2");

        // Then
        assertEquals("결과 : 3", result);
    }

    @Test
    void 쉼표와_콜론이_섞여있는_숫자의_합을_반환한다() {
        // When
        String result = calculatorService.add("1,2:3");

        // Then
        assertEquals("결과 : 6", result);
    }

    @Test
    void 커스텀_구분자로_문자열을_분리하고_합을_반환한다() {
        // When
        String result = calculatorService.add("//;\\n1;2;3");
        String result1 = calculatorService.add("1//;\\n2:3;4");

        // Then
        assertEquals("결과 : 6", result);
        assertEquals("결과 : 10", result1);
    }

    @Test
    void 구분자로_입력된_문자열이_아닐_경우_잘못된_값으로_예외를_던진다() {
        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> calculatorService.add("1;2"));
        assertThrows(IllegalArgumentException.class,
                () -> calculatorService.add("a:2:b"));
    }

    @Test
    void 음수가_포함되면_예외를_던진다() {
        //When & Then
        assertThrows(IllegalArgumentException.class,
                () -> calculatorService.add("-1,2"));
    }
}