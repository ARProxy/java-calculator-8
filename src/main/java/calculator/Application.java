package calculator;

import calculator.core.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        var service = new CalculatorService();
        while(true) {
            try {
                String result = service.add(Console.readLine());
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                break;
            }
        }
    }
}
