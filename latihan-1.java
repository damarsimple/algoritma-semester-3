import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x, y;

        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan nilai x : ");
        x = scan.nextInt();
        System.out.print("Masukkan nilai y : ");
        y = scan.nextInt();

        int hasil = x + y;

        System.out.printf("Hasil x + y = %d \n", hasil);
    }
}
