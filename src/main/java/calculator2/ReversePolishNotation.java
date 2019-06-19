package calculator2;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class ReversePolishNotation {
	static boolean isNumber(String str) {
		try {
			Double.valueOf(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	Queue<String> convertInfixToRPN(List<String> infixNotation) {
		Map<String, Integer> prededence = new HashMap<>();
		prededence.put("/", 5);
		prededence.put("*", 5);
		prededence.put("+", 4);
		prededence.put("-", 4);
		prededence.put("(", 0);

		Queue<String> Q = new LinkedList<>();
		Stack<String> S = new Stack<>();

		for (String token : infixNotation) {
			if ("(".equals(token)) {
				S.push(token);
				continue;
			}

			if (")".equals(token)) {
				while (!"(".equals(S.peek())) {
					Q.add(S.pop());
				}
				S.pop();
				continue;
			}

			if (prededence.containsKey(token)) {
				while (!S.empty() && prededence.get(token) <= prededence.get(S.peek())) {
					Q.add(S.pop());
				}
				S.push(token);
				continue;
			}

			if (isNumber(token)) {
				Q.add(token);
				continue;
			}

			throw new IllegalArgumentException("Invalid input");
		}

		while (!S.isEmpty()) {
			Q.add(S.pop());
		}

		return Q;
	}

	public List<String> textToInfix(String text) {
		
		StringBuilder newToken = new StringBuilder();
		List<String> tokens = new ArrayList<String>();
		
		for (char c : text.toCharArray()) {
			if (c == ' ') {
				
				
				if (newToken.length() > 0) {

					tokens.add(newToken.toString());

					newToken = new StringBuilder();
				}
			} else {
				newToken.append(c);
				
			}
			if (newToken.length() > 0) {

				tokens.add(newToken.toString());
			}
		}

		
		return tokens;
	}

	public double compute(Queue<String> expr) throws ArithmeticException, EmptyStackException {
		Stack<Double> stack = new Stack<>();

		System.out.println(expr);
		System.out.println("Input\tOperation\tStack after");

		for (String token : expr) {
			System.out.print(token + "\t");
			switch (token) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				stack.push(-stack.pop() + stack.pop());
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				double divisor = stack.pop();
				stack.push(stack.pop() / divisor);
				break;
			case "^":

				double exponent = stack.pop();
				stack.push(Math.pow(stack.pop(), exponent));
				break;
			default:

				stack.push(Double.parseDouble(token));
				break;
			}

			
		}

		return stack.pop();
	}

	public static void main(String[] args) {
	
	}
}
