package behaviouraldesignpatterns.InterpreterDesignPattern;

public class TerminalExpression implements Expression {

	private String key;

	public TerminalExpression(String key) {
		this.key = key;
	}

	@Override
	public int interpret(Context context) {
		return context.get(key);
	}

}
