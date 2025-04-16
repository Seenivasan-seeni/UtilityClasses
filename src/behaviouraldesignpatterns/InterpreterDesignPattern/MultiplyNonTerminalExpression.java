package behaviouraldesignpatterns.InterpreterDesignPattern;

public class MultiplyNonTerminalExpression implements Expression {

	Expression leftExpression = null;
	Expression rightExpression = null;

	public MultiplyNonTerminalExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public int interpret(Context context) {
		// TODO Auto-generated method stub
		return leftExpression.interpret(context) * rightExpression.interpret(context);
	}

}
