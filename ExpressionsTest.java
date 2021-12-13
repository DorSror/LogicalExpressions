import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dor Sror - 207271875
 * The ExpressionsText class.
 * This class is used to test expressions and print the following:
 * - The string representation.
 * - Evaluation of the expression, using an assignment map.
 * - The string representation of the nandified version.
 * - The string representation of the norified version.
 * - The string representation of the simplified version.
 */
public class ExpressionsTest {
    /**
     * The main method of the class, this is where the tests run.
     * @param args Not used in this assignment.
     */
    public static void main(String[] args) {
        Expression expression = new Not(new Xor(new Nand(new And(new Val(false), new Var("x")),
            new Or(new Var("y"), new Var("y"))), new Xnor(new Var("z"), new Nor(new Var("t"),
            new Var("t")))));
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", false);
        assignment.put("y", false);
        assignment.put("z", true);
        assignment.put("t", false);
        System.out.println(expression.toString());
        try {
            System.out.println(expression.evaluate(assignment));
        } catch (Exception exception) {
            System.out.println("Exception: Cannot evaluate expression.");
        }
        System.out.println(expression.nandify().toString());
        System.out.println(expression.norify().toString());
        System.out.println(expression.simplify().toString());
    }
}
