package com.kata.training;

import java.util.List;

class Converter {

    public int convertRomanToArabic(String input) {
        List<RomanNumbers> numbers = RomanNumbers.getNumbers();
        int result = 0;
        while (input.length() > 0) {
            for (RomanNumbers n : numbers) {
                if (input.startsWith(n.getRomanValue())) {
                    result += n.getIntValue();
                    input = input.substring(n.getRomanValue().length());
                }
            }
        }
        return result;
    }

    public String convertArabicToRoman(int value) {
        int decimals = value / 10;
        int ones = value % 10;
        StringBuilder sb = new StringBuilder();
        switch (decimals) {
            case 10 -> sb.append(RomanNumbers.C.getRomanValue());
            case 9 -> sb.append(RomanNumbers.XC.getRomanValue());
            case 8 -> sb.append(String.format("%s%s%s%s", RomanNumbers.L.getRomanValue(),
                    RomanNumbers.X.getRomanValue(),
                    RomanNumbers.X.getRomanValue(),
                    RomanNumbers.X.getRomanValue()));
            case 7 -> sb.append(String.format("%s%s%s", RomanNumbers.L.getRomanValue(),
                    RomanNumbers.X.getRomanValue(),
                    RomanNumbers.X.getRomanValue()));
            case 6 -> sb.append(String.format("%s%s", RomanNumbers.L.getRomanValue(),
                    RomanNumbers.X.getRomanValue()));
            case 5 -> sb.append(RomanNumbers.L.getRomanValue());
            case 4 -> sb.append(String.format("%s%s", RomanNumbers.X.getRomanValue(),
                    RomanNumbers.L.getRomanValue()));
            case 3 -> sb.append(String.format("%s%s%s",
                    RomanNumbers.X.getRomanValue(),
                    RomanNumbers.X.getRomanValue(),
                    RomanNumbers.X.getRomanValue()));
            case 2 -> sb.append(String.format("%s%s",
                    RomanNumbers.X.getRomanValue(),
                    RomanNumbers.X.getRomanValue()));
            case 1 -> sb.append(RomanNumbers.X.getRomanValue());
        }
        switch (ones) {
            case 1 -> sb.append(RomanNumbers.I.getRomanValue());
            case 2 -> sb.append(String.format("%s%s", RomanNumbers.I.getRomanValue(),
                    RomanNumbers.I.getRomanValue()));
            case 3 -> sb.append(String.format("%s%s%s",
                    RomanNumbers.I.getRomanValue(),
                    RomanNumbers.I.getRomanValue(),
                    RomanNumbers.I.getRomanValue()));

            case 4 -> sb.append(RomanNumbers.IV.getRomanValue());
            case 5 -> sb.append(RomanNumbers.V.getRomanValue());
            case 6 -> sb.append(String.format("%s%s",
                    RomanNumbers.V.getRomanValue(),
                    RomanNumbers.I.getRomanValue()
            ));
            case 7 -> sb.append(String.format("%s%s%s",
                    RomanNumbers.V.getRomanValue(),
                    RomanNumbers.I.getRomanValue(),
                    RomanNumbers.I.getRomanValue()
            ));
            case 8 -> sb.append(String.format("%s%s%s%s",
                    RomanNumbers.V.getRomanValue(),
                    RomanNumbers.I.getRomanValue(),
                    RomanNumbers.I.getRomanValue(),
                    RomanNumbers.I.getRomanValue()
            ));
            case 9 -> sb.append(RomanNumbers.IX.getRomanValue());
        }
        return sb.toString();
    }
}
