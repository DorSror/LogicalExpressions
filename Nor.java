import java.util.Map;

/**
 * @author Dor Sror - 207271875
 * The Nor class, extends the BinaryExpression class.
 * Represents a logical Nor operation.
 */
public class Nor extends BinaryExpression {
    /**
     * The Nor constructor.
     * Uses the constructor for BinaryExpression, sending the given expressions.
     * @param expression1 the first given expression.
     * @param expression2 the second given expression.
     */
    public Nor(Expression expression1, Expression expression2) {
        super(expression1, expression2);
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
        return !(new Or(this.getExpressions()[0], this.getExpressions()[1]).evaluate(assignment));
    }

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * @return Boolean value (True/False) of the expression.
     * @throws Exception When a variable is in the expression.
     */
    public Boolean evaluate() throws Exception {
        return !(new Or(this.getExpressions()[0], this.getExpressions()[1]).evaluate());
    }

    /**
     * Returns a nice string representation of the expression.
     * @return String of the expression.
     */
    public String toString() {
        return "(" + this.getExpressions()[0].toString() + " V " + this.getExpressions()[1].toString() + ")";
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
        return new Nor(this.getExpressions()[0].assign(var, expression),
                this.getExpressions()[1].assign(var, expression));
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nand operation.
     * @return new expression that has only Nand operations in it.
     */
    public Expression nandify() {
        Or temporary = new Or(this.getExpressions()[0].nandify(), this.getExpressions()[1].nandify());
        return new Nand(temporary.nandify(), temporary.nandify());
    }

    /**
     * Returns the expression tree resulting from converting all the
     * operations to the logical Nor operation.
     * @return new expression that has only Nor operations in it.
     */
    public Expression norify() {
        return new Nor(this.getExpressions()[0].norify(), this.getExpressions()[1].norify());
    }

    /**
     * Returned a simplified version of the current expression.
     * @return a simplified version of the current expression, according
     * to assignment 4's requirements.
     */
    public Expression simplify() {
        Expression simplified1 = this.getExpressions()[0].simplify();
        Expression simplified2 = this.getExpressions()[1].simplify();
        if (simplified1.toString().equals("T") || simplified2.toString().equals("T")) {
            return new Val(false);
        }
        if (simplified1.toString().equals("F") && simplified2.toString().equals("F")) {
            return new Val(true);
        }
        if (simplified1.toString().equals("F") || simplified1.toString().equals(simplified2.toString())) {
            return new Not(simplified2);
        }
        if (simplified2.toString().equals("F")) {
            return new Not(simplified1);
        }
        return new Nor(simplified1, simplified2);
    }
}
