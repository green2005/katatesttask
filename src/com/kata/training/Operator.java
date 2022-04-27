package com.kata.training;

public enum Operator {
    PLUS("+"), MINUS("-"), DIV("/"), MULT("*");

    private String mOperator;

    Operator(String s) {
        mOperator = s;
    }

    public String getOperator() {
        return mOperator;
    }
}
