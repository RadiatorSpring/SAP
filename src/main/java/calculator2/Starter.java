package calculator2;

import java.util.List;
import java.util.Scanner;

public class Starter {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Calculator calculator = new Calculator();
        List<String> operations = calculator.findOperations(text);
        List<Double> arguments = calculator.findArguments(text);
        double result = calculator.compute(operations, arguments);
        System.out.println(result);
        scanner.close();

        // TODO put in github
    }
}
