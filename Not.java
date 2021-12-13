import java.util.Map;

/**
 * @author Dor Sror - 207271875
 * The Not class, extends the UnaryExpression class.
 * Represents a logical Not operation.
 */
public class Not extends UnaryExpression {
    /**
     * The Not constructor.
     * Uses the constructor for UnaryExpression, sending the given expression.
     * @param expression the given expression.
     */
    public Not(Expression expression) {
        super(expression);
    }

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
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !super.getExpression()[0].evaluate(assignment);
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return Boolean value (True/False) of the expression.
     * @throws Exception When a variable is in the expression.
     */
    public Boolean evaluate() throws Exception {
        return !super.getExpression()[0].evaluate();
    }

    /**
     * Returns a nice string representation of the expression.
     * @return String of the expression.
     */
    public String toString() {
        return "~(" + this.getExpression()[0].toString() + ")";
    }

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     * @param var The variable we want to replace.
     * @param expression The provided expression.
     * @return A new expression containing the provided expression in all
     * instances of var.
     */
    public Expression assign(String var, Expression expression) {
        return new Not(super.getExpression()[0].assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nand operation.
     * @return new expression that has only Nand operations in it.
     */
    public Expression nandify() {
        return new Nand(this.getExpression()[0].nandify(), this.getExpression()[0].nandify());
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nor operation.
     * @return new expression that has only Nor operations in it.
     */
    public Expression norify() {
        return new Nor(this.getExpression()[0].norify(), this.getExpression()[0].norify());
    }

    /**
     * Returned a simplified version of the current expression.
     * @return a simplified version of the current expression, according
     * to assignment 4's requirements.
     */
    public Expression simplify() {
        Expression simplified = this.getExpression()[0].simplify();
        if (simplified.toString().equals("T")) {
            return new Val(false);
        }
        if (simplified.toString().equals("F")) {
            return new Val(true);
        }
        return new Not(simplified);
    }
}
