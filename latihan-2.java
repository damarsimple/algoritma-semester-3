import java.util.Scanner;

public class latihan2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan n : ");

        int n = scan.nextInt();

        // draw x star

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                boolean render = i == j || i + j == n - 1;

                if (render) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}
