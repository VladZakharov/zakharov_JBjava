package serverCalculator;

/**
 * Created by vlad on 08.10.15.
 */
public class Calculator {

    public static String solve(String exp) {
        System.out.println("solver");
        if (exp == null) return "";
        Double result = CalculatorCore.Solve(exp);
        if (result != null) return result.toString();
        return new String("Wrong_expression!");
    }

}