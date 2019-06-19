package calculator2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.spi.DirStateFactory.Result;

public class Calculator {



	protected List<String> findOperations(String text) {
		Pattern patternForOperations = Pattern.compile("[+/*-]");
		Matcher matcherForOperations = patternForOperations.matcher(text);
		List<String> operations = new ArrayList<String>();

		while (matcherForOperations.find()) {
			String operation = matcherForOperations.group();
			operations.add(operation);
		}
		
		return operations;
	}

	protected List<Double> findArguments(String text) {

		Pattern patternForNumbers = Pattern.compile("\\d+");
		Matcher matcherForNumbers = patternForNumbers.matcher(text);
		List<Double> listForArguments = new ArrayList<Double>();

		while (matcherForNumbers.find()) {
			listForArguments.add(Double.parseDouble(matcherForNumbers.group()));
		}

		return listForArguments;
	}

	protected double compute(List<String> operations, List<Double> arguments) {
		double result = 0;
		int i = 0;
		if (operations.get(i).equals("+")) {
			result = arguments.get(i) + arguments.get(i + 1);
		} else if (operations.get(i).equals("*")) {
			result = arguments.get(i) * arguments.get(i + 1);
		} else if (operations.get(i).equals("/")) {
			result = arguments.get(i) / arguments.get(i + 1);
		} else if (operations.get(i).equals("-")) {
			result = arguments.get(i) - arguments.get(i + 1);
		}
		for (int j = 2; j < arguments.size(); j++) {
			if(operations.get(j-1).equals("+")) {
				result+= arguments.get(j);
			}
			else if(operations.get(j-1).equals("*")) {
				result*= arguments.get(j);
			}
			else if(operations.get(j-1).equals("/")) {
				result/= arguments.get(j);
			}
			else if(operations.get(j-1).equals("-")) {
				result-= arguments.get(j);
			}
		}
		
		return result;
	}
	
	
	
}
















