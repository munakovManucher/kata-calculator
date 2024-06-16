package ru.rosbank.paymenthub;

import java.util.Scanner;

public class FinalCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("начните работу с калькулятором");
        String input = scanner.nextLine();

        if (isRoman(input.split(" ")[0]) && isRoman(input.split(" ")[2])) {
            String romanMethod = romanCalc(input);
            System.out.println(romanMethod);
        } else {
            String arabicMethod = arabicCalc(input);
            System.out.println(arabicMethod);
        }
    }

    public static boolean isRoman(String standartJavaLang) {
        return standartJavaLang.matches("[IVXL]+");
    }

    public static String arabicCalc(String input) {
        String[] arabicArray = input.split(" ");

        if (arabicArray.length != 3) {
            throw new RuntimeException("введи 2 операнда и 1 оператор");
        }

        int arabicOperand1 = Integer.parseInt(arabicArray[0]);
        int arabicOperand2 = Integer.parseInt(arabicArray[2]);
        String operator = arabicArray[1];

        if (arabicOperand1 < 1 || arabicOperand1 > 10 || arabicOperand2 < 1 || arabicOperand2 > 10) {
            throw new RuntimeException("операнды должны быть от 1 до 10");
        }

        int arabicResult = 0;
        if (operator.equals("+")) {
            arabicResult = arabicOperand1 + arabicOperand2;
        } else if (operator.equals("-")) {
            arabicResult = arabicOperand1 - arabicOperand2;
        } else if (operator.equals("*")) {
            arabicResult = arabicOperand1 * arabicOperand2;
        } else if (operator.equals("/")) {
            arabicResult = arabicOperand1 / arabicOperand2;
        } else {
            throw new RuntimeException("неверный оператор");
        }

        return Integer.toString(arabicResult);
    }

    public static String romanCalc(String input) {
        String[] romanArray = input.split(" ");
        if (romanArray.length != 3) {
            throw new RuntimeException("введите 2 операнда и 1 оператор");
        }
        int romanOperand1 = romanToArabic(romanArray[0]);
        int romanOperand2 = romanToArabic(romanArray[2]);
        String romanOperator = romanArray[1];

        if (romanOperand1 < 1 || romanOperand1 > 10 || romanOperand2 < 1 || romanOperand2 > 10) {
            throw new RuntimeException("операнды должны быть от 1 до 10");
        }

        int arabicResult = 0;
        if (romanOperator.equals("+")) {
            arabicResult = romanOperand1 + romanOperand2;
        } else if (romanOperator.equals("-")) {
            arabicResult = romanOperand1 - romanOperand2;
        } else if (romanOperator.equals("*")) {
            arabicResult = romanOperand1 * romanOperand2;
        } else if (romanOperator.equals("/")) {
            arabicResult = romanOperand1 / romanOperand2;
        } else {
            throw new RuntimeException("неверный оператор");
        }

        return arabicToRoman(arabicResult);
    }

    public static int romanToArabic(String input) {
        return switch (input) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new RuntimeException("число должно быть от 1 до 10");
        };
    }

    public static String arabicToRoman(int arabicResult) {
        String[] romanNumerals =
            {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI",
             "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
             "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI",
             "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
             "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
             "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
             "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI",
             "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        return romanNumerals[arabicResult - 1];
    }
}


