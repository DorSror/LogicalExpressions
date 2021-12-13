import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Dor Sror - 207271875
 * The Val class, implements the Expression interface.
 * Contains a boolean value.
 */
public class Val implements Expression {
    private final Boolean value;

    /**
     * The Val constructor.
     * @param value the given Boolean value.
     */
    public Val(Boolean value) {
        this.value = value;
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * Note that Val is always Boolean, therefore no exception will be thrown.
     * @param assignment A map of Boolean values assigned to variables
     * @return Boolean value (True/False) of the expression (according to
     * assignment). Will always be this.value.
     * @throws Exception When a variable in the expression is not assigned
     * a Boolean value. Will never be thrown.
     */
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.value;
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * Note that Val is always Boolean, therefore no exception will be thrown.
     * @return Boolean value (True/False) of the expression. Will always be
     * this.value.
     * @throws Exception When a variable is in the expression. Will never be
     * thrown.
     */
    public Boolean evaluate() throws Exception {
        return this.value;
    }

    /**
     * Returns a list of the variables in the expression.
     * Since Val contains no variables, it will return an empty list.
     * @return List of strings that contains the variables in the expression,
     * without duplicates. In this case, an empty list.
     */
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    /**
     * Returns a nice string representation of the expression.
     * @return "T" if this.value is true, otherwise returns "F".
     */
    public String toString() {
        if (this.value) {
            return "T";
        }
        return "F";
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression). Since Val contains no variables, Val will be
     * returned.
     * @param var The variable we want to replace.
     * @param expression The provided expression.
     * @return A new expression containing the provided expression in all
     * instances of var. In this case, this Val.
     */
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nand operation.
     * In this case, no conversion in needed, and Val will be returned.
     * @return new expression that has only Nand operations in it.
     */
    public Expression nandify() {
        return this;
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nor operation.
     * In this case, no conversion in needed, and Val will be returned.
     * @return new expression that has only Nor operations in it.
     */
    public Expression norify() {
        return this;
    }

    /**
     * Returned a simplified version of the current expression.
     * Since Val is always simplified, then it will be returned.
     * @return a simplified version of the current expression, according
     * to assignment 4's requirements. In this case, this Val.
     */
    public Expression simplify() {
        return this;
    }
}
