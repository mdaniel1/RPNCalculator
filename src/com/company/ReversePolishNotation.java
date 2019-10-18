package com.company;

import com.exceptions.NoValueException;

import java.util.Stack;

public class ReversePolishNotation {

    public static Double getResult(String input) throws NoValueException {
        Stack<Double> numbers = new Stack<Double>();
        String[] inputArray = checkInput(input);
        for (String value : inputArray) {
            if(isSymbol(value)){
                processMath(numbers, value);
            }
            else{
                numbers.push(Double.parseDouble(value));
            }
        }

        if(numbers.size() == 0)
        {
            throw new NoValueException("There are no value to calculate");
        }
        else{
            return numbers.pop();
        }
    }

    private static String[] checkInput(String input) {
        if(input.contains(" "))
            input = input.replace(" ", "");

        if(input.contains("sqrt"))
            input = input.replace("sqrt", "@");
        //I arbitrarily decided that @ would be the symbol for the square root.

        return input.split("");
    }

    private static void processMath(Stack<Double> values, String symbol){
        if(symbol.equals("@"))
        {
            values.push(Symbol.SQRT.apply(values.pop(), null));
        }
        else{
            try {
                values.push(Symbol.getSymbolFromValue(symbol).apply(values.pop(), values.pop()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isSymbol(String symbol){
        if( symbol.equals("+")
        ||  symbol.equals("-")
        ||  symbol.equals("*")
        ||  symbol.equals("/")
        || symbol.equals("@")){
            return true;
        }
        return false;
    }

}
