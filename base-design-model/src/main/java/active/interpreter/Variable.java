package active.interpreter;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-01-25 10:45
 */

public class Variable implements Expression {
    @Override
    public void interpret(String context) {
        System.out.println("interpret ... Variable");
    }
}
