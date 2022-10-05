package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class App {

    public static List<Mahasiswa> mahasiswas = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilih : ");

            int pilihan = scanner.nextInt();

            if (pilihan == 1) {

                addMahasiswa();

            } else if (pilihan == 2) {
                showMahasiswa();
            } else if (pilihan == 3) {
                break;
            }

        }

        scanner.close();

    }

    public static void addMahasiswa() {

        System.out.println("Silahkan masukkan data mahasiswa");

        System.out.print("Nama : ");
        String nama = System.console().readLine();
        System.out.print("NIM : ");
        String nim = System.console().readLine();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim);
        mahasiswas.add(mahasiswa);
    }

    public static void showMahasiswa() {
        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.printf("\nData mahasiswa ke - %d \n", mahasiswas.indexOf(mahasiswa));
            System.out.println("Nama : " + mahasiswa.getNama());
            System.out.println("NIM : " + mahasiswa.getNim());
            System.out.println();
        }
    }
}
