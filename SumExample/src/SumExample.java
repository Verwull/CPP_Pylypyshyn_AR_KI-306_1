import java.util.Scanner;

public class SumExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int a = in.nextInt();

        System.out.print("Введіть друге число: ");
        int b = in.nextInt();

        int sum = a + b;

        System.out.println("Сума = " + sum);

        in.close();
    }
}
