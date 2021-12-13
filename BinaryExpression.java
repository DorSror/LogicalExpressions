import java.util.List;

/**
 * @author Dor Sror - 207271875
 * The BinaryExpression abstract class, extends the BaseExpression abstract
 * class.
 * Here goes all the shared code of binary expressions (all expressions that
 * contain exactly two expressions).
 */
public abstract class BinaryExpression extends BaseExpression {
    /**
     * The constructor for BinaryExpression.
     * Uses the constructor for BaseExpression, sending an array created with
     * expression1 and expression2.
     * @param expression1 The first expression that constructs the expression.
     * @param expression2 The second expression that constructs the expression.
     */
    public BinaryExpression(Expression expression1, Expression expression2) {
        super(new Expression[] {expression1, expression2});
    }

    /**
     * Returns the array of expressions of the expression.
     * Uses the extension of BaseExpression.
     * @return Array of expressions.
     */
    public Expression[] getExpressions() {
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
