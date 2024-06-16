package ru.rosbank.paymenthub;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Начните работу с калькулятором");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String arabicMethod = arabicCalc(input);
            System.out.print(arabicMethod);
        } catch (Exception e){
            System.out.println();
        }

        String romanMethod = romanCalc(input);
        System.out.println(romanMethod);
    }

    public static String arabicCalc(String input) {
        String[] arabicParts = input.split(" ");

        if (arabicParts.length != 3) {
            throw new RuntimeException("введите операнд№1, оператор и операнд№2");
        }

        int arabicOperand1 = Integer.parseInt(arabicParts[0]);
        int arabicOperand2 = Integer.parseInt(arabicParts[2]);
        String arabicOperator = arabicParts[1];

        if (arabicOperand1 < 1 || arabicOperand1 > 10 || arabicOperand2 < 1 || arabicOperand2 > 10) {
            throw new RuntimeException("число должно быть больше 1 и меньше 10");
        }

        int arabicResult = 0;
        if (arabicOperator.equals("+")) {
            arabicResult = arabicOperand1 + arabicOperand2;
        } else if (arabicOperator.equals("-")) {
            arabicResult = arabicOperand1 - arabicOperand2;
        } else if (arabicOperator.equals("*")) {
            arabicResult = arabicOperand1 * arabicOperand2;
        } else if (arabicOperator.equals("/")) {
            arabicResult = arabicOperand1 / arabicOperand2;
        } else {
            throw new RuntimeException("неверный оператор");
        }
        return Integer.toString(arabicResult);
    }

    public static String romanCalc(String input) {
        String[] romanParts = input.split(" ");

        if (romanParts.length != 3) {
            throw new RuntimeException("введите операнд№1, оператор и операнд№2");
        }

        int romanOperand1 = Integer.parseInt(romanParts[0]);
        int romanOperand2 = Integer.parseInt(romanParts[2]);
        String romanOperator = romanParts[1];

        if (romanOperand1 < 1 || romanOperand1 > 10 || romanOperand2 < 1 || romanOperand2 > 10) {
            throw new RuntimeException("число должно быть больше 1 и меньше 10");
        }

        int romanResult = 0;
        if (romanOperator.equals("+")) {
            romanResult = romanOperand1 + romanOperand2;
        } else if (romanOperator.equals("-")) {
            romanResult = romanOperand1 - romanOperand2;
        } else if (romanOperator.equals("*")) {
            romanResult = romanOperand1 * romanOperand2;
        } else if (romanOperator.equals("/")) {
            romanResult = romanOperand1 / romanOperand2;
        } else {
            throw new RuntimeException("неверный оператор");
        }
        // return Integer.toString(romanResult);

        /* В методе romanCalc нельзя вернуть значение в integer в отличие от метода arabicCalc, поскольку там мы
        можем легко преобразовать строчные арабские цифры в int (числовые), здесь же пользователь будет вводить
        римские значения X,V.. и так далее, компилятор не сможет их преобразовать в int
        Метод `arabicCalc` работает с арабскими цифрами, которые легко преобразуются из строк в целые числа с помощью метода
        `Integer.parseInt()`. Однако метод `romanCalc` работает с римскими цифрами, которые не могут быть преобразованы напрямую
        в целые числа, поскольку нет стандартного способа преобразования римских цифр в числовые значения.
            Для работы с римскими цифрами вам нужно будет создать отдельные методы для преобразования римских цифр в
            арабские (например, метод `romanToArabic`), а также для преобразования арабских цифр в римские (например,
             метод `arabicToRoman`). Эти методы будут выполнять соответствующие преобразования строковых значений.*/

        return arabicToRoman(romanResult);//пока что ставим заглушку, так как на данном этапе мы ещё не создали мето с
        // арабского на
        // римские
        // числа

    }

    public static int romanToArabic(String roman) {//создаем новый метод типа int, так как наша задача перевести
        // Римские числа в арабские, арабские это уже int по умолчанию. Данный метод работает с цифрами от 1 до 10
        // (условия задачи)
        switch (roman) { //используем условный оператор switch-case, чтобы компилятор присвоил строчным символам
            // значения типа int
            case "I":
                return 1; //буквально говорим, присвой для случая "I" верни ему значение типа int 1, иначе эту
            // команду ещё можно было записать так, case "I" -> 1
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new RuntimeException("нужно ввести римское число от 1 до 10");
                /**
                 * данный метод привел римские цифры от 1 до 10 к арабским, то есть к типу int. Но нам ещё нужен метод,
                 * который будет приводить Арабские в Римские и там нам надо будет посчитать преобразования до 100 через
                 * массивы строк, поскольку результат может быть до 100.
                 */

                /*

Цель метода romanToArabic и его роль в калькуляторе:
Цель: Превратить римское число (например, "VIII") в арабское число (обычное числовое значение, например, 8).
Логика: Метод принимает строку с римским числом и анализирует каждый символ. Каждая римская цифра имеет своё числовое значение (например, "V" - 5, "I" - 1). Метод складывает значения этих цифр вместе и возвращает обычное числовое значение.
                 */
        }
    }

    public static String arabicToRoman(int number) { //Создаем метод, который принимает целое число (int) и преобразует
        // его в строку римского числа
        if (number < 1 || number > 100) { //результат не может быть больше 100, поскольку два операнда от 1 до 10
            throw new RuntimeException("Число должно быть от 1 до 100");
        }
        String [] romanNumerals = {
        "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return romanNumerals [number - 1]; //мы берём массив строк от 0 до 100, помещаем туда 100 Римских чисел,
        // поскольку там от 1 до 100 чисел, то они выходят за пределы массива, поэтому длина массива равна 101, в
        // связи с этим мы говорим присвой значение переменной romanNumerals значение и вычти от туда единицу,
        // получим правильное число.
    }
}