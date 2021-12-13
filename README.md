# Background
In mathematics, a logical expression is a statement that can be either True or False. These expression can be composed of operators such as Not, Or, And, Xor etc.
This is a Java program made to express complex logical expressions as a project in the Introduction to Object Oriented Programming course (89111) at Bar-Ilan University.
Each expression can be evaluated if all variables are assigned True or False, simplified, be returned in a string form, assigned new inner expressions and have all
of its inner expressions changed to Nand or Nor (part of the project).

# Unary and Binary expressions
There are a few expressions that are implemented in the code - each simple expression is a class:
Not - This is the only unary expression in the code that is noted with ~(InnerExpression), it takes the evaluation of the inner expression inside the Not expression
and switches it; if the variable evaluates to be True, it will return False and vice versa.
Or - This is a binary expression noted with (InnerExpression1 | InnerExpression2) that evaluates to be True if at least one of its inner expressions evaluates to be True.
And - This is a binary experssion noted with (InnerExpression1 & InnerExpression2) that evaluates to be True if both of its inner expressions evaluate to be True.
Xor - This is a binary expression noted with (InnerExpression1 ^ InnerExpression2) that evaluates to be True if exactly one of its inner expressions evaluates to be True.
Nor - This is an expression that can be also noted as Not(Or()). It is a binary expression noted with (InnerExpression1 V InnerExpression2) that evaluates to be True if
none of its inner expressions evaluate to be True.
Nand - This is an expression that can be also noted as Not(And()). It is a binary expression noted with (InnerExpression1 A InnerExpression2) that evaluates to be True if
at most one of its inner expressions evaluate to be True.
Xnor - This is an expression that can be also noted as Not(Xor()). It is a binary expression noted with (InnerExpression1 # InnerExpression2) that evaluates to be True if
either none of its inner expressions or both of them evaluateto be True.
