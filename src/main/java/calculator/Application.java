package calculator;

import calculator.core.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var service = new CalculatorService();
        int result = service.add(Console.readLine());
        System.out.println(result);
    }
}
