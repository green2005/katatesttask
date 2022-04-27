package com.kata.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum RomanNumbers {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);

    private int mValue;

    RomanNumbers(int i) {
        mValue = i;
    }

    public int getIntValue() {
        return mValue;
    }

    public static List<RomanNumbers> getNumbers() {
        List<RomanNumbers> numbers = new ArrayList<>();
        for (RomanNumbers n : values()) {
            numbers.add(n);
        }
        Comparator<RomanNumbers> comparator = Comparator.comparing(
                RomanNumbers::getIntValue);
        return numbers.stream().sorted(comparator.reversed()).collect(Collectors.toList());
    }

    public String getRomanValue() {
        return switch (this) {
            case I -> "I";
            case IV -> "IV";
            case V -> "V";
            case IX -> "IX";
            case X -> "X";
            case XL -> "XL";
            case C -> "C";
            case L -> "L";
            case XC -> "XC";
        };
    }
}
