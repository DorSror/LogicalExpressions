import java.util.ArrayList;
import java.util.List;

/**
 * @author Dor Sror - 207271875
 * The BaseExpression abstract class, implements the Expression interface.
 * Here goes all the shared code from UnaryExpression, BinaryExpression
 * and so forth. (this is so that is we want a TrinaryExpression for example,
 * then we can use this code for this abstract class too).
 */
public abstract class BaseExpression implements Expression {
    private final Expression[] expressionsArray;

    /**
     * The constructor for BaseExpression.
     * Note that this constructor uses an array of expressions.
     * @param expressionsArray the array of expressions.
     */
    public BaseExpression(Expression[] expressionsArray) {
        this.expressionsArray = expressionsArray;
    }

    /**
     * Returns the array of expressions of the expression.
     * This is used for classes who extend this class and need to know what
     * are the expressions contained in this expression.
     * @return the array of expressions.
     */
    protected Expression[] getExpressions() {
        return this.expressionsArray;
    }

    /**
     * Returns a list of the variables in the expression.
     * Note that a var is being added to the list iff it isn't in the list
     * when checked.
     * @return List of strings that contains the variables in the expression,
     * without duplicates.
     */
    public List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        for (Expression expression : this.expressionsArray) {
            for (String var : expression.getVariables()) {
                if (!variables.contains(var)) {
                    variables.add(var);
                }
            }
        }
        return variables;
    }
}
