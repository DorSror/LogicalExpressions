import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Dor Sror - 207271875
 * The Var class, implements the Expression interface.
 * Contains a String of the expression.
 */
public class Var implements Expression {
    private final String str;

    /**
     * The Val constructor.
     * @param str the given String.
     */
    public Var(String str) {
        this.str = str;
    }

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     * In this case, if the assignment doesn't contain this.str, then
     * throw an exception.
     * @param assignment A map of Boolean values assigned to variables
     * @return Boolean value (True/False) of the expression (according to
     * assignment). Will always be this.value.
     * @throws Exception When a variable in the expression is not assigned
     * a Boolean value. Will be thrown if this.str isn't contained in assignment.
     */
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (!assignment.containsKey(this.str)) {
            throw new Exception();
        }
        return assignment.get(this.str);
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return Boolean value (True/False) of the expression.
     * In this case, a Boolean value will never be returned
     * @throws Exception When a variable is in the expression.
     * Since this is a variable and there's no assignment map, an exception
     * will always be thrown.
     */
    public Boolean evaluate() throws Exception {
        throw new Exception();
    }

    /**
     * Returns a list of the variables in the expression.
     * Since Var contains exactly one var (itself), the list will have this.str.
     * @return List of strings that contains the variables in the expression,
     * without duplicates.
     */
    public List<String> getVariables() {
        List<String> var = new ArrayList<>();
        var.add(this.str);
        return var;
    }

    /**
     * Returns a nice string representation of the expression.
     * Since this is a variable, it will simply return its string value.
     * @return this.str.
     */
    public String toString() {
        return this.str;
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression). Since Var contains only itself, it will either
     * return the provided expression (when this.str equals var) or itself.
     * @param var The variable we want to replace.
     * @param expression The provided expression.
     * @return A new expression containing the provided expression in all
     * instances of var.
     */
    public Expression assign(String var, Expression expression) {
        if (this.str.equals(var)) {
            return expression;
        }
        return this;
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nand operation.
     * In this case, no conversion in needed, and Var will be returned.
     * @return new expression that has only Nand operations in it.
     */
    public Expression nandify() {
        return this;
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nor operation.
     * In this case, no conversion in needed, and Var will be returned.
     * @return new expression that has only Nor operations in it.
     */
    public Expression norify() {
        return this;
    }

    /**
     * Returned a simplified version of the current expression.
     * Since Var is always simplified, then it will be returned.
     * @return a simplified version of the current expression, according
     * to assignment 4's requirements. In this case, this Var.
     */
    public Expression simplify() {
        return this;
    }
}
