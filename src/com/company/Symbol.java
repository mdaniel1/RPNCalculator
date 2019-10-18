package com.company;

import java.util.HashMap;

public enum Symbol {
    ADD("+"){
        @Override
        public Double apply(Double number1, Double number2) {
            return number2 + number1;
        }
    },
    SUBSTRACT("-"){
        @Override
        public Double apply(Double number1, Double number2) {
            return number2 - number1;
        }
    },
    DIVIDE("/"){
        @Override
        public Double apply(Double number1, Double number2) {
            return number2 / number1;
        }
    },
    MULTIPLY("*"){
        @Override
        public Double apply(Double number1, Double number2) {
            return number2 * number1;
        }
    },
    SQRT("@"){
        @Override
        public Double apply(Double number1, Double number2) {
            return Math.sqrt(number1);
        }
    };


    private final String symbol;

    Symbol(String s){
        symbol = s;
    }

    public String getSymbol(){
        return symbol;
    }

    public static Symbol getSymbolFromValue(String value) throws Exception {
        Symbol[] listSymbol = Symbol.values();
        for(Symbol s : listSymbol){
            if(s.getSymbol().equals(value))
                return s;
        }

        throw new Exception("No such symbol");
    }

    public abstract Double apply(Double number1, Double number2);


}
