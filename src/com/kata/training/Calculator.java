package com.kata.training;

class Calculator {


    public String calc(String input) {
        Expression e = getParsedExpression(input);
        int res = doCalc(e.getOperand1Value(), e.getOperand2Value(), e.getOperator());
        if (e.getOperand1Type() == Expression.NumericType.ARABIC) {
            return Integer.toString(res);
        } else {
            if (res <= 0) {
                throw new IllegalArgumentException("Romanian numbers should be above zero");
            }
            Converter cnv = new Converter();
            return cnv.convertArabicToRoman(res);
        }
    }

    private int doCalc(int operand1, int operand2, Operator operator) {
        switch (operator) {
            case DIV -> {
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return operand1 / operand2;
            }
            case MULT -> {
                return operand1 * operand2;
            }
            case PLUS -> {
                return operand1 + operand2;
            }
            case MINUS -> {
                return operand1 - operand2;
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
