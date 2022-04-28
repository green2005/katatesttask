package com.kata.training;

class Calculator {


    public String calc(String input) {
        Expression e = getParsedExpression(input);
        int res = doCalc(e);
        if (e.getOperand1Type() == Expression.NumericType.ARABIC) {
            if (res < 0) {
                throw new IllegalArgumentException("Result of expression with Arabic numbers should be equal or above zero");
            }
            return Integer.toString(res);
        } else {
            if (res <= 0) {
                throw new IllegalArgumentException("Result of expression with Romanian numbers should be above zero");
            }
            Converter cnv = new Converter();
            return cnv.convertArabicToRoman(res);
        }
    }

    private int doCalc(Expression e) {
        switch (e.getOperator()) {
            case DIV -> {
                if (e.getOperand2Value() == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return e.getOperand1Value() / e.getOperand2Value();
            }
            case MULT -> {
                return e.getOperand1Value() * e.getOperand2Value();
            }
            case PLUS -> {
                return e.getOperand1Value() + e.getOperand2Value();
            }
            case MINUS -> {
                return e.getOperand1Value() - e.getOperand2Value();
            }
            default -> {
                return 0;
            }
        }
    }

    private Expression getParsedExpression(String input) {
        Expression expression = new Expression(input);
        return expression;
    }

}
