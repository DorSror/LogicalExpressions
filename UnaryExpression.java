import java.util.List;

/**
 * @author Dor Sror - 207271875
 * The UnaryExpression abstract class, extends the BaseExpression abstract
 * class.
 * Here goes all the shared code of unary expressions (all expressions that
 * contain exactly one expression).
 */
public abstract class UnaryExpression extends BaseExpression {
    /**
     * The constructor for BinaryExpression.
     * Uses the constructor for BaseExpression, sending an array created with
     * expression.
     * @param expression The expression that constructs the expression.
     */
    public UnaryExpression(Expression expression) {
        super(new Expression[] {expression});
    }

    /**
     * Returns the array of expressions of the expression.
     * Uses the extension of BaseExpression.
     * @return Array of expressions.
     */
    protected Expression[] getExpression() {
        return super.getExpressions();
    }

    /**
     * Returns a list of the variables in the expression.
     * Uses the extension of BaseExpression.
     * @return List of variables contained in the expression.
     */
    public List<String> getVariables() {
        return super.getVariables();
    }
}
