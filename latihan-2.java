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

// Here's what the above main function is doing:
// 1. First it will ask the user to enter a number.
// 2. Then it will draw an x star with the width and height of the entered
// number.
// 3. For each row and column, it will draw a star if the row equals the column
// or the sum of the row and column equals the width minus one.
// 4. If not, it will draw a space.