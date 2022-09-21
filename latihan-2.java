import java.util.Scanner;

public class latihan2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan n : ");

        int n = scan.nextInt();

        for (int i = 1; i <= 2 * n; i++) {
            System.out.printf("%d ", i);
        }

        System.out.println();
    }

}
