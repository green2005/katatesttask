package com.kata.training;

class Expression {

    public String getOperand1() {
        return operand1;
    }

    public NumericType getOperand1Type() {
        return operand1Type;
    }

    public NumericType getOperand2Type() {
        return operand2Type;
    }

    public String getOperand2() {
        return operand2;
    }

    public Operator getOperator() {
        return operator;
    }

    private String operand1;
    private String operand2;
    private NumericType operand1Type = NumericType.UNKNOWN;
    private NumericType operand2Type = NumericType.UNKNOWN;
    private int operand1Value;
    private int operand2Value;
    private Operator operator;

    public int getOperand1Value() {
        return operand1Value;
    }

    public int getOperand2Value() {
        return operand2Value;
    }


    enum NumericType {
        ROMAN, ARABIC, UNKNOWN;

        @Override
        public String toString() {
            return switch (this) {
                case UNKNOWN -> "UNKNOWN";
                case ROMAN -> "ROMAN";
                case ARABIC -> "ARABIC";
            };
        }
    }

    Expression(String input) {
        Operator[] operators = Operator.values();
        for (Operator value : operators) {
            int ix = input.indexOf(value.getOperator());
            if (ix > 0) {
                operand1 = input.substring(0, ix).trim();
                operand1Type = getOperandNumericType(operand1);
                operand2 = input.substring(ix + 1).trim();
                operand2Type = getOperandNumericType(operand2);
                operator = value;
                break;
            }
        }

        if (!(((operand2Type == NumericType.ARABIC) && (operand1Type == NumericType.ARABIC)) ||
                (operand1Type == NumericType.ROMAN) && (operand2Type == NumericType.ROMAN))) {
            throw new IllegalArgumentException("Incorrect input");
        }

        if (operand1Type == NumericType.ARABIC) {
            try {
                operand1Value = Integer.parseUnsignedInt(operand1);
                operand2Value = Integer.parseUnsignedInt(operand2);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Numbers are not valid");
            }
        } else {
            Converter converter = new Converter();
            operand1Value = converter.convertRomanToArabic(operand1);
            operand2Value = converter.convertRomanToArabic(operand2);
        }

        if ((operand1Value<1)||(operand1Value>10)||(operand2Value<1)||(operand2Value>10)){
            throw new IllegalArgumentException("Operands should be greater than 0 and less than 11");
        }
    }

    private NumericType getOperandNumericType(String operand) {
        if ((operand == null) || (operand.isEmpty())) {
            throw new IllegalArgumentException("Empty operand");
        }
        if ((operand.equals("10")) || ((operand.compareTo("0") >= 0) && (operand.compareTo("9") <= 0))) {
            return NumericType.ARABIC;
        } else {
            for (int i = 0; i < operand.length(); i++) {
                boolean isRoman = false;
                for (RomanNumbers n : RomanNumbers.values()) {
                    if (n.getRomanValue().equals("" + operand.charAt(i))) {
                        isRoman = true;
                        break;
                    }
                }
                if (!isRoman) return NumericType.UNKNOWN;
            }
            return NumericType.ROMAN;
        }
    }
}
