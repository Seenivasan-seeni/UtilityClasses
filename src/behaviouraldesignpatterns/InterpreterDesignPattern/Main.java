package behaviouraldesignpatterns.InterpreterDesignPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Context context = new Context();
		context.put("a", 4);
		context.put("b", 8);
		context.put("c", 5);
		context.put("d", 10);

		Expression expression = new AddNonTerminalExpression(
				new MultiplyNonTerminalExpression(new TerminalExpression("a"), new TerminalExpression("b")),
				new MultiplyNonTerminalExpression(new TerminalExpression("c"), new TerminalExpression("d")));
		System.out.println(expression.interpret(context));

//		Pattern pattern = Pattern.compile("ab*");
//		Matcher matcher = pattern.matcher("abb");
//		System.out.println(matcher.matches()); // return true

	}

}
