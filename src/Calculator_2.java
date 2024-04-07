import java.util.Scanner;

public class Calculator_2 {
    static Scanner s = new Scanner(System.in);
    static String s1;
    static int Operation;
    static char[] CharArray;

    static int Result(int i1, int i2) {

        if (CharArray[Operation] == '+') {
            return i1 + i2;
        } else if (CharArray[Operation] == '/') {
            return i1 / i2;
        } else if (CharArray[Operation] == '*') {
            return i1 * i2;
        } else if (CharArray[Operation] == '-') {
            return i1 - i2;
        } else {
            return 0;
        }
    }

    static String StringToNumber() {
        System.out.println("Введите ваше выражение");
        s1 = s.nextLine().trim().replace(" ", "");
        CharArray = s1.toCharArray();
        try {
            for (int i = 0; i < CharArray.length; i++) {
                char target = CharArray[i];
                if (target == '+' || target == '/' || target == '*' || target == '-') {
                    Operation = i;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Некорректно введено выражение. Выражение должно содержать только арабские или только римские цифры от 1 до 10 и обязательно один знак: 1 + 1 или I + V");
        }
        return Calculated();
    }

    static int Value(String s) {
        return switch (s) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
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
            default ->
                    throw new RuntimeException("Некорректно введено выражение. Выражение должно содержать только арабские или только римские цифры от 1 до 10 и обязательно один знак: 1 + 1 или I + V");
        };
    }

    static String Roman(int i) {
        String[] r = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return r[i];
    }

    static String Calculated() {
        String[] ArabicNumber = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] RomanNumber = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int value1 = Value(s1.trim().replace(" ", "").substring(0, Operation));
        int value2 = Value(s1.trim().replace(" ", "").substring(Operation + 1, CharArray.length));

        if (s1.trim().replace(" ", "").substring(0, Operation).equals(RomanNumber[value1]) && s1.trim().replace(" ", "").substring(Operation + 1, CharArray.length).equals(RomanNumber[value2])) {
            return Roman(Result(value1, value2));
        } else if (s1.trim().replace(" ", "").substring(0, Operation).equals(ArabicNumber[value1]) && s1.trim().replace(" ", "").substring(Operation + 1, CharArray.length).equals(ArabicNumber[value2])) {
            return Integer.toString(Result(value1, value2));
        } else {
            throw new RuntimeException("Некорректно введено выражение. Выражение должно содержать только арабские или только римские цифры от 1 до 10 и обязательно один знак: 1 + 1 или I + V");
        }


    }

    public static void main(String[] args) {
            try {
                System.out.println(StringToNumber());
            } catch (Exception e) {
                System.out.println("Некорректно введено выражение. Выражение должно содержать только арабские или только римские цифры от 1 до 10 и обязательно один знак: 1 + 1 или I + V");
            }
    }
}
