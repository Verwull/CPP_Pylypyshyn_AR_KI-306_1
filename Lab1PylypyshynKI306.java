import java.io.FileWriter;
import java.util.Scanner;

/**
 * Lab1PylypyshynKI306
 * Програма створює зубчатий масив, який зберігає заштриховану область
 * квадратної матриці (заштриховане кільце між двома порожніми зонами).
 *
 * Функціонал:
 * - Користувач вводить розмір квадратної матриці n та символ-заповнювач.
 * - Програма перевіряє коректність введеного символу.
 * - Формує зубчатий масив із заштрихованими елементами.
 * - Виводить масив на екран і зберігає його у файл.
 *
 * @author Pylypyshyn
 * @version 1.0
 */
public class Lab1PylypyshynKI306 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Ввід розміру матриці
            System.out.print("Введіть розмір квадратної матриці n: ");
            int n = sc.nextInt();
            sc.nextLine(); // очищення буфера після числа

            // Ввід символу-заповнювача
            System.out.print("Введіть символ-заповнювач: ");
            String input = sc.nextLine();

            // Перевірка коректності
            if (input.length() != 1) {
                System.out.println("Помилка: потрібно ввести рівно один символ!");
                return;
            }
            char fill = input.charAt(0);

            // Формування зубчатого масиву (середнє кільце заповнене)
            char[][] jaggedArray = new char[n][];

            int outerStart = n / 4; // початок заповненого кільця
            int outerEnd = n - outerStart - 1;// кінець заповненого кільця

            int innerStart = n / 2 - n / 8; // внутрішній пустий квадрат
            int innerEnd = n / 2 + n / 8;

            for (int i = 0; i < n; i++) {
                jaggedArray[i] = new char[n];
                for (int j = 0; j < n; j++) {
                    // Заштрихована область тільки між outer та inner
                    if ((i >= outerStart && i <= outerEnd) &&
                            (j >= outerStart && j <= outerEnd) &&
                            !(i >= innerStart && i <= innerEnd &&
                                    j >= innerStart && j <= innerEnd)) {
                        jaggedArray[i][j] = fill;
                    } else {
                        jaggedArray[i][j] = ' ';
                    }
                }
            }

            // Виведення на екран
            System.out.println("Сформований зубчатий масив:");
            for (char[] row : jaggedArray) {
                for (char c : row) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }

            // Запис у файл
            try (FileWriter writer = new FileWriter("output.txt")) {
                for (char[] row : jaggedArray) {
                    for (char c : row) {
                        writer.write(c + " ");
                    }
                    writer.write("\n");
                }
            }

            System.out.println("Масив збережено у файл output.txt");

        } catch (Exception e) {
            System.out.println("Помилка вводу: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
