import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan nama anda : ");
        String name = scan.nextLine();

        System.out.print("Masukkan nilai anda : ");
        int grade = scan.nextInt();

        System.out.printf("Nama anda adalah %s dan nilai anda adalah %d, anda %slulus \n", name, grade,
                grade >= 60 ? "" : "tidak ");

    }

}
