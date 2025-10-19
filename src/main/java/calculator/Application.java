package calculator;

import calculator.core.CalculatorService;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        var service = new CalculatorService();
        String result = service.add(Console.readLine());
        System.out.println(result);

        Console.close();
    }
}
