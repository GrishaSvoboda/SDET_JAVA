public class Main {
    public static void main(String[] args) {
        // Лямбда-выражение для проверки делимости на 13
        DivisibleByThirteen isDivisibleBy13 = number -> number % 13 == 0;

        // Примеры использования
        int number1 = 26;
        int number2 = 15;

        System.out.println(number1 + " делится на 13? " + isDivisibleBy13.test(number1)); // true
        System.out.println(number2 + " делится на 13? " + isDivisibleBy13.test(number2)); // false
    }
}