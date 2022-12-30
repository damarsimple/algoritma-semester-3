package com.siakad.app;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
public class Siakad {

    public static  Collator collator = Collator.getInstance();

    public static String getString(String pesan, Scanner scanner) {
        System.out.print(pesan);
        String v = scanner.next();
        return v;
    }

    public static void main(String[] args) {

        // Tambah data mahasiswa

        List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();


        // populate mahasiswa

        for (int i = 100; i > 0; i--) {
            Mahasiswa m = new Mahasiswa(
                "NIM" + i,
                "Nama" + i,
                "Alamat" + i,
                "Jurusan" + i,
                "Fakultas" + i
            );

            mahasiswa.add(m);
        }

        // 1. Tambah data
        // 2. Lihat data
        // 3. Urutkan data
        // 4. Pencaharian data
        // 5. Edit data
        // 6. Hapus data

        Scanner input = new Scanner(System.in);

        int pilih, pilihAlgoritma, pilihUrut;
        long startTime, endTime, duration;
        MahasiswaKey key = null;

        String nim, nama, alamat, jurusan, fakultas;
        while (true) {


            System.out.println("Menu");
            System.out.println("1. Tambah data");
            System.out.println("2. Lihat data");
            System.out.println("3. Urutkan data");
            System.out.println("4. Pencaharian data");
            System.out.println("5. Edit data");
            System.out.println("6. Hapus data");
            System.out.print("Pilih menu: ");

            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("Tambah data");

                    nim = getString("NIM: ", input);
                    nama = getString("Nama: ", input);
                    alamat = getString("Alamat: ", input);
                    jurusan = getString("Jurusan: ", input);
                    fakultas = getString("Fakultas: ", input);

                    Mahasiswa mhs = new Mahasiswa(nim, nama, alamat, jurusan, fakultas);

                    mahasiswa.add(mhs);

                    System.out.printf("Data mahasiswa %s berhasil ditambahkan", nama);

                    break;

                case 2:
                    System.out.println("Lihat data");

                    for (int i = 0; i < mahasiswa.size(); i++) {
                        Mahasiswa m = mahasiswa.get(i);
                        System.out.println("NIM: " + m.nim);
                        System.out.println("Nama: " + m.nama);
                        System.out.println("Alamat: " + m.alamat);
                        System.out.println("Jurusan: " + m.jurusan);
                        System.out.println("Fakultas: " + m.fakultas);
                        System.out.println("==================================");
                    }

                    break;

                case 3:
                    System.out.println("Urutkan data berdasarkan: ");

                    System.out.println("1. NIM");
                    System.out.println("2. Nama");
                    System.out.println("3. Alamat");
                    System.out.println("4. Jurusan");
                    System.out.println("5. Fakultas");
                    System.out.print("Pilih menu: ");

                    pilihUrut = input.nextInt();

                    key = null;

                    switch (pilihUrut) {
                        case 1:
                            key = MahasiswaKey.NIM;
                            break;
                        case 2:
                            key = MahasiswaKey.NAMA;
                            break;
                        case 3:
                            key = MahasiswaKey.ALAMAT;
                            break;
                        case 4:
                            key = MahasiswaKey.JURUSAN;
                            break;
                        case 5:
                            key = MahasiswaKey.FAKULTAS;
                            break;
                        default:
                            break;
                    }

                    Mahasiswa[] data = new Mahasiswa[mahasiswa.size()];

                    for (int i = 0; i < mahasiswa.size(); i++) {
                        data[i] = mahasiswa.get(i);
                    }

                    System.out.println("Urutkan data berdasarkan algoritma: ");

                    System.out.println("1. Exchange");
                    System.out.println("2. Selection");
                    System.out.println("3. Quick");
                    System.out.println("4. Insertion");
                    System.out.println("5. Bubble");
                    System.out.println("6. Shell");
                    System.out.print("Pilih menu: ");

                    pilihAlgoritma = input.nextInt();
                    startTime = System.nanoTime();
                    switch (pilihAlgoritma) {
                        case 1:
                            exchangeSort(data, key);
                            break;
                        case 2:
                            selectionSort(data, key);
                            break;
                        case 3:
                            quickSort(data, key, 0, data.length - 1);
                            break;
                        case 4:
                            insertionSort(data, key);
                            break;
                        case 5:
                            bubbleSort(data, key);
                            break;
                        case 6:
                            shellSort(data, key);
                            break;
                        default:
                            break;
                    }

                    endTime = System.nanoTime();

                    duration = (endTime - startTime);

                    System.out.println("Waktu eksekusi: " + duration + " nano detik");

                    for (int i = 0; i < data.length; i++) {
                        Mahasiswa m = data[i];
                        System.out.printf("%d/%d==============================\n", i + 1, data.length);
                        System.out.println("NIM: " + m.nim);
                        System.out.println("Nama: " + m.nama);
                        System.out.println("Alamat: " + m.alamat);
                        System.out.println("Jurusan: " + m.jurusan);
                        System.out.println("Fakultas: " + m.fakultas);
                        System.out.printf("%d/%d==============================\n", i + 1, data.length);

                    }

                    System.out.println("Waktu eksekusi: " + duration + " nano detik");

                    break;

                case 4:

                    System.out.println("Cari data berdasarkan: ");

                    System.out.println("1. NIM");
                    System.out.println("2. Nama");
                    System.out.println("3. Alamat");
                    System.out.println("4. Jurusan");
                    System.out.println("5. Fakultas");
                    System.out.print("Pilih menu: ");

                    pilihUrut = input.nextInt();

                    key = null;

                    switch (pilihUrut) {
                        case 1:
                            key = MahasiswaKey.NIM;
                            break;
                        case 2:
                            key = MahasiswaKey.NAMA;
                            break;
                        case 3:
                            key = MahasiswaKey.ALAMAT;
                            break;
                        case 4:
                            key = MahasiswaKey.JURUSAN;
                            break;
                        case 5:
                            key = MahasiswaKey.FAKULTAS;
                            break;
                        default:
                            break;
                    }

                    System.out.print("Masukkan kata kunci: ");

                    String kataKunci = input.next();

                    System.out.println("Masukkan algoritma pencarian: ");

                    System.out.println("1. Linear");
                    System.out.println("2. Binary");

                    System.out.print("Pilih menu: ");

                    pilihAlgoritma = input.nextInt();

                    startTime = System.nanoTime();

                    int index = -1;

                    switch (pilihAlgoritma) {
                        case 1:
                            index = linearSearch(mahasiswa, key, kataKunci);
                            break;
                        case 2:
                            index = binarySearch(mahasiswa, key, kataKunci);
                            break;
                        default:
                            index = -1;
                            break;
                    }

                    endTime = System.nanoTime();

                    duration = (endTime - startTime);
                    System.out.println("Waktu eksekusi: "+ duration + " nano detik");

                    if (index != -1) {
                        Mahasiswa m = mahasiswa.get(index);

                        System.out.println("NIM: " + m.nim);
                        System.out.println("Nama: " + m.nama);
                        System.out.println("Alamat: " + m.alamat);
                        System.out.println("Jurusan: " + m.jurusan);
                        System.out.println("Fakultas: " + m.fakultas);
                        System.out.println("==================================");
                    } else {
                        System.out.println("Data tidak ditemukan");
                    }

                    break;

                case 5:
                    System.out.println("Edit data");
                    System.out.println("Masukkan Data ke berapa yang akan di edit: ");
                    index = input.nextInt();
                    System.out.println("Masukkan NIM: ");
                    nim = input.next();
                    System.out.println("Masukkan Nama: ");
                    nama = input.next();
                    System.out.println("Masukkan Alamat: ");
                    alamat = input.next();
                    System.out.println("Masukkan Jurusan: ");
                    jurusan = input.next();
                    System.out.println("Masukkan Fakultas: ");
                    fakultas = input.next();

                    System.out.println("Data yang akan di edit: ");

                    System.out.println("NIM: " + mahasiswa.get(index).nim);
                    System.out.println("Nama: " + mahasiswa.get(index).nama);
                    System.out.println("Alamat: " + mahasiswa.get(index).alamat);
                    System.out.println("Jurusan: " + mahasiswa.get(index).jurusan);
                    System.out.println("Fakultas: " + mahasiswa.get(index).fakultas);
                    System.out.println("==================================");

                    System.out.println("Data yang baru: ");
                    System.out.println("NIM: " + nim);
                    System.out.println("Nama: " + nama);
                    System.out.println("Alamat: " + alamat);
                    System.out.println("Jurusan: " + jurusan);
                    System.out.println("Fakultas: " + fakultas);
                    System.out.println("==================================");

                    System.out.println("Apakah anda yakin ingin mengedit data tersebut? (y/n)");

                    String pilihEdit = input.next();

                    if (pilihEdit.equals("y")) {

                        Mahasiswa mStaging = new Mahasiswa(
                                nim,
                                nama,
                                alamat,
                                jurusan,
                                fakultas);

                        mahasiswa.set(index, mStaging);

                        System.out.println("Data berhasil di edit");
                    } else {
                        System.out.println("Data tidak jadi di edit");
                    }

                    break;

                case 6:
                    System.out.println("Hapus data");
                    System.out.println("Masukkan Data ke berapa yang akan di hapus: ");
                    int indexHapus = input.nextInt();

                    System.out.println("Data yang akan di hapus: ");

                    System.out.println("NIM: " + mahasiswa.get(indexHapus).nim);
                    System.out.println("Nama: " + mahasiswa.get(indexHapus).nama);
                    System.out.println("Alamat: " + mahasiswa.get(indexHapus).alamat);
                    System.out.println("Jurusan: " + mahasiswa.get(indexHapus).jurusan);
                    System.out.println("Fakultas: " + mahasiswa.get(indexHapus).fakultas);
                    System.out.println("==================================");

                    System.out.println("Apakah anda yakin ingin menghapus data tersebut? (y/n)");

                    String pilihHapus = input.next();

                    if (pilihHapus.equals("y")) {
                        mahasiswa.remove(indexHapus);
                        System.out.println("Data berhasil di hapus");
                    } else {
                        System.out.println("Data tidak jadi di hapus");
                    }

                    break;
                // benchmark sorting
                case 7:

                    System.out.println("Benchmark Sorting");

                    // for key in MahasiswaKey

                    String[] algorithms = {"Exchange Sort", "Selection Sort", "Quick Sort", "Insertion  Sort", "Insertion Sort", "Bubble Sort", "Shell Short"};
                    
                    Map<String, long[]> results = new HashMap<>();

                    long[] durations = new long[MahasiswaKey.values().length];

                    for (int i = 0; i < MahasiswaKey.values().length; i++) {
                        MahasiswaKey sortKey = MahasiswaKey.values()[i];

                        System.out.println("Benchmarking key: " + sortKey);

                        // for algorithm in algorithms

                        for (int j = 0; j < algorithms.length; j++) {
                            String algorithm = algorithms[j];

                            System.out.println("Benchmarking algorithm: " + algorithm);

                            // generate data

                            Mahasiswa[] dataStaging = new Mahasiswa[10];

                            for (int k = 0; k < dataStaging.length; k++) {
                                dataStaging[k] = new Mahasiswa(
                                    "nim" + k,
                                    "nama" + k,
                                    "alamat" + k,
                                    "jurusan" + k,
                                    "fakultas" + k
                                );
                            }

                            // benchmark

                            startTime = System.nanoTime();

                            switch (algorithm) {
                                case "Exchange Sort":
                                    exchangeSort(dataStaging, sortKey);
                                    break;
                                case "Selection Sort":
                                    selectionSort(dataStaging, sortKey);
                                    break;
                                case "Quick Sort":
                                    quickSort(dataStaging, sortKey, 0, dataStaging.length - 1);
                                    break;
                                case "Insertion Sort":
                                    insertionSort(dataStaging, sortKey);
                                    break;
                                case "Bubble Sort":
                                    bubbleSort(dataStaging, sortKey);
                                    break;
                                case "Shell Sort":
                                    shellSort(dataStaging, sortKey);
                                    break;
                            }

                             endTime = System.nanoTime();

                             duration = (endTime - startTime);

                            System.out.println("Waktu eksekusi: "+ duration + " nano detik");

                            durations[i] = duration;
                        }

                        results.put(sortKey.toString(), durations);
                    }

                    System.out.println("Hasil benchmarking: ");


                    // table header
                    // no | algorithm | key | key | key | key | key
                    // no | algorithm | duration | duration | duration | duration | duration

                    System.out.print("No\tAlgorithm\t");

                    for ( String resKey : results.keySet() ) {
                        System.out.print(resKey + "\t");
                    }

                    System.out.println();

                

                    for (int i = 0; i < algorithms.length; i++) {
                        String algorithm = algorithms[i];

                        System.out.print((i + 1) + "\t" + algorithm + "\t");


                        for ( String resKey : results.keySet() ) {

                            long[] resDurations = results.get(resKey);
                            
                            for (int j = 0; j < resDurations.length; j++) {
                                long resDuration = resDurations[j];

                                System.out.print(resDuration + "\t");
                            }
                        }

                        System.out.println();

                    }

                

                    
                    
                   
                

                default:

                    System.out.println("");

                    System.out.println("Terima kasih telah menggunakan program ini");
                    System.out.println("Adios amigos");

                    return;

            }
        }
    }

    // algorithm sorting
    // Exchange,Selection,Quick,Insertion,Bubble,Shell

    // Exchange
    public static void exchangeSort(Mahasiswa[] data, MahasiswaKey key) {

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {

                // check data j exists

                if (data[j] == null) {
                    continue;
                }

                if (
                    collator.compare(
                        data[j].getValueByKey(key),
                        data[i].getValueByKey(key)
                    ) < 0
                ) {
                    Mahasiswa temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }

       
    }

    // Selection

    public static void selectionSort(Mahasiswa[] data, MahasiswaKey key) {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {

                // check data j exists

                if (data[j] == null) {
                    continue;
                }

                if (
                    collator.compare(
                        data[j].getValueByKey(key),
                        data[min].getValueByKey(key)
                    ) < 0
                ) {
                    min = j;
                }
            }

            if (min != i) {
                Mahasiswa temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
    }

    // Quick

    public static int partition(Mahasiswa[] data, MahasiswaKey key, int left, int right) {
        int i = left, j = right;
        Mahasiswa pivot = data[(left + right) / 2];

        while (i <= j) {
            while (
                collator.compare(
                    data[i].getValueByKey(key),
                    pivot.getValueByKey(key)
                ) < 0
            ) {
                i++;
            }

            while (
                collator.compare(
                    data[j].getValueByKey(key),
                    pivot.getValueByKey(key)
                ) > 0
            ) {
                j--;
            }

            if (i <= j) {
                Mahasiswa temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
         
        }

        return i;
    }

    public static void quickSort(Mahasiswa[] data, MahasiswaKey key, int left, int right) {
        if (left < right) {
            int pivot = partition(data, key, left, right);
            quickSort(data, key, left, pivot - 1);
            quickSort(data, key, pivot + 1, right);
        }
    }

    // Insertion

    public static void insertionSort(Mahasiswa[] data, MahasiswaKey key) {
        for (int i = 1; i < data.length; i++) {
            Mahasiswa temp = data[i];
            int j = i - 1;

            while (
                j >= 0 &&
                collator.compare(
                    data[j].getValueByKey(key),
                    temp.getValueByKey(key)
                ) > 0
            ) {

                // check data j exists

                if (data[j] == null || data[j + 1] == null) {
                    continue;
                }

                data[j + 1] = data[j];
                j--;
            }

          

            data[j + 1] = temp;
        }
    }

    // Bubble

    public static void bubbleSort(Mahasiswa[] data, MahasiswaKey key) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {

                if (
                    collator.compare(
                        data[j].getValueByKey(key),
                        data[j + 1].getValueByKey(key)
                    ) > 0
                ) {



                    Mahasiswa temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
             
            }
        }
    }

    // Shell

    public static void shellSort(Mahasiswa[] data, MahasiswaKey key) {
        int n = data.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                Mahasiswa temp = data[i];
                int j = i;

                // check data j exists

                if (data[j] == null) {
                    continue;
                }

                while (
                    j >= gap &&
                    collator.compare(
                        data[j - gap].getValueByKey(key),
                        temp.getValueByKey(key)
                    ) > 0
                ) {
                    data[j] = data[j - gap];
                    j -= gap;
                }


                data[j] = temp;
            }

            gap /= 2;
        }
    }

    // search algorithm
    // binary,linear

    // binary

    public static int binarySearch(List<Mahasiswa> data, MahasiswaKey key, String value) {

        int left = 0;
        int right = data.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // not implemented yet


        }

        return -1;

    }

    // linear

    public static int linearSearch(List<Mahasiswa> data, MahasiswaKey key, String value) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getValueByKey(key).equals(value)) {
                return i;
            }
        }

        return -1;
    }

}

enum MahasiswaKey {
    NIM, NAMA, ALAMAT, JURUSAN, FAKULTAS
}

class Helper {
    public static int stringToInt(String str) {
        int acc = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            acc = acc * 10 + (c - '0');
        }

        return acc;
    }
}

class Mahasiswa {
    String nim;
    String nama;
    String alamat;
    String jurusan;
    String fakultas;

    public Mahasiswa(String nim, String nama, String alamat, String jurusan, String fakultas) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
    }

    public String getValueByKey(MahasiswaKey key) {
        switch (key) {
            case NIM:
                return nim;
            case NAMA:
                return nama;
            case ALAMAT:
                return alamat;
            case JURUSAN:
                return jurusan;
            case FAKULTAS:
                return fakultas;
            default:
                return null;
        }
    }

}
