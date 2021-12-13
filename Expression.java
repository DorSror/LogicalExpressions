import java.util.List;
import java.util.Map;

/**
 * @author Dor Sror - 207271875
 * The Expression interface.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * @param assignment A map of Boolean values assigned to variables
     * @return Boolean value (True/False) of the expression (according to
     * assignment).
     * @throws Exception When a variable in the expression is not assigned
     * a Boolean value.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return Boolean value (True/False) of the expression.
     * @throws Exception When a variable is in the expression.
     */
    Boolean evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     * @return List of strings that contains the variables in the expression,
     * without duplicates.
     */
    List<String> getVariables();

    /**
     * Returns a nice string representation of the expression.
     * @return String of the expression.
     */
    String toString();

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     * @param var The variable we want to replace.
     * @param expression The provided expression.
     * @return A new expression containing the provided expression in all
     * instances of var.
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nand operation.
     * @return new expression that has only Nand operations in it.
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nor operation.
     * @return new expression that has only Nor operations in it.
     */
    Expression norify();

    /**
     * Returned a simplified version of the current expression.
     * @return a simplified version of the current expression, according
     * to assignment 4's requirements.
     */
    Expression simplify();
}