package calculator2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.spi.DirStateFactory.Result;

class Calculator {



	protected List<String> findOperations(String text) {
		Pattern patternForOperations = Pattern.compile("[+/*-]");
		Matcher matcherForOperations = patternForOperations.matcher(text);
		List<String> operations = new ArrayList<>();

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
		
		for (int i = 0; i < arguments.size(); i++) {
			if(i==0){
				result += computeWithOperation(operations.get(i), arguments.get(i),arguments.get(i+i));
			}
			else{
				result = computeWithOperation(operations.get(i),result,arguments.get(i));
			}

		}
		return result;
	}

	private double computeWithOperation(String operation,double argument1, double argument2){
		if (operation.equals("+")) {
			return  argument1 + argument2;
		} else if (operation.equals("*")) {
			return  argument1 * argument2;
		} else if (operation.equals("/")) {
			return  argument1 / argument2;
		} else if (operation.equals("-")) {
			return  argument1 - argument2;
		}
		return 0;

	}

	
}
















