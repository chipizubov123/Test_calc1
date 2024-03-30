import java.util.Arrays;
import java.util.Scanner;
import java.lang.Exception.*;

public class Testhui {
    static Scanner s = new Scanner(System.in);
    static int value1;
    static int value2;
    static char charOperation;
    static String[] r = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    static String StringToArab() {
        System.out.println("введите выражение");
        String s1 = String.valueOf(s.nextLine()).replace(" ", "");
        char[] c1 = s1.toCharArray();
        int charOperation = 2;
        for (int i = 0; i < c1.length; i++) {
            char target = c1[i];
            if (target == '+' || target == '/' || target == '*' || target == '-') {
                charOperation = i;
            }
        }
        String Rom;
        for (String string : r) {
            Rom = string;
            if (Rom.equals(s1.substring(0, charOperation)) || Rom.equals(s1.substring(charOperation + 1, c1.length))) {
                value1 = StringToRome(s1.substring(0, charOperation));
                value2 = StringToRome(s1.substring(charOperation + 1, c1.length));
                if (c1[charOperation] == ('*')) {
                    //return ((Integer)(value1 * value2)).toString();
                    return Roman(value1 * value2);
                } else if (c1[charOperation] == ('/')) {
                    return Roman(value1 / value2);
                } else if (c1[charOperation] == ('+')) {
                    return Roman(value1 + value2);
                } else if (c1[charOperation] == ('-')) {
                    return Roman(value1 - value2);
                }
            }
        }
        value1 = (Integer.parseInt(s1.trim().substring(0, charOperation)));
        value2 = (Integer.parseInt(s1.trim().substring(charOperation + 1, c1.length)));
        if (c1[charOperation] == ('*')) {
            //return ((Integer)(value1 * value2)).toString();
            return ((Integer) (value1 * value2)).toString();
        } else if (c1[charOperation] == ('/')) {
            return ((Integer) (value1 / value2)).toString();
        } else if (c1[charOperation] == ('+')) {
            return ((Integer) (value1 + value2)).toString();
        } else if (c1[charOperation] == ('-')) {
            return ((Integer) (value1 - value2)).toString();
        }
        return s1;
    }

    static String Roman(int Num) {
        return r[Num];
    }

    static int StringToRome(String Rome) {
        try {
            switch (Rome) {
                case "I" -> {
                    return 1;
                }
                case "II" -> {
                    return 2;
                }
                case "III" -> {
                    return 3;
                }
                case "IV" -> {
                    return 4;
                }
                case "V" -> {
                    return 5;
                }
                case "VI" -> {
                    return 6;
                }
                case "VII" -> {
                    return 7;
                }
                case "VIII" -> {
                    return 8;
                }
                case "IX" -> {
                    return 9;
                }
                case "X" -> {
                    return 10;
                }

                default -> throw new IllegalStateException("Unexpected value: " + Rome);
            }

        } catch (Exception e) {
            System.out.println("Введено неверное выражение, попробуйте еще раз");
            StringToArab();
        }
        return 0;
    }


    public static void main(String[] args) {

        System.out.println("Результат выражения: " + StringToArab());
    }
}