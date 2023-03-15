import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] infoMeasures = new String[] {
                "B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"
        }; // массив с единицами измерения

        Scanner scan = new Scanner(System.in);
        double size = scan.nextDouble();

        int index = 0; // индекс элемента массива с единицами измерения
        while (size >= 1024 && index < 8) {
            index++;
            size /= 1024;
        }

        size = roundDouble(size, 1); // округление числа
        String measure = infoMeasures[index]; // взятие единицы измерения по индексу

        String result = String.format("%s %s", size, measure);
        System.out.println(result);
    }

    // метод округяющий число до n количества знаков после запятой
    private static double roundDouble(double number, int n) {
        double order = Math.pow(10, n);
        double roundNumber = Math.round(number * order) / order;

        return roundNumber;
    }
}
