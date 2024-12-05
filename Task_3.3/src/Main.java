public class Main {
    public static void main(String[] args) {
        // Лямбда-выражение для вычисления дискриминанта
        DiscriminantCalculator discriminantCalculator = (a, b, c) -> (b * b) - (4 * a * c);

        // Примеры использования
        double a = 1.0;
        double b = -3.0;
        double c = 2.0;

        double discriminant = discriminantCalculator.calculate(a, b, c);
        System.out.println("Дискриминант: " + discriminant); // Ожидается: 1.0
    }
}