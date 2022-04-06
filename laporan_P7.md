# Nama        = Muhammad farhan Riza Putra
# Kelas/absen = TI - 1F / 21

## Pertemuan 7

## 6.5. Latihan Praktikum

1. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
- Sebelum dilakukan searching dengan binary search data harus dilakukan pengurutan dengan
menggunakan algoritma sorting (pilih salah satu algoritma sorting dari pertemuan
sebelumnya)

```java
public class mahasiswa {
    String nama;
    int nim;
    int umur;
    double ipk;

    mahasiswa(String n, int ni, int u, double i){
        nama = n;
        nim = ni;
        umur = u;
        ipk = i;
    }

    void tampil1(){
        System.out.println("Nama = "+ nama);
        System.out.println("Nim  = "+ nim);
        System.out.println("Umur = "+ umur);
        System.out.println("Ipk  = "+ ipk);
    }
}
```

```java
public class t2_PencarianMhs {
    t2_Mahasiswa listMhs[];
    int idx;

    void tambah(t2_Mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data Sudah Penus !!");
        }
    }

    void tampil() {
        for (t2_Mahasiswa m : listMhs) {
            m.tampil();
            System.out.println("--------------------");
        }
    }

    public int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int i = 0; i < listMhs.length; i++) {
            if (listMhs[i].nim == cari) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

    public int FindSeqSearch(t2_Mahasiswa listMHs[],String cari){
        int posisi=-1;
        for (int j = 0; j < listMHs.length; j++) {
            if (cari.equalsIgnoreCase(listMHs[j].nama)) {
                posisi=j;
                TampilPosisi(cari,posisi);
                TampilData(cari,posisi);
            }
        }
        return posisi;
    }

    public void TampilPosisi(String x, int pos) {
        if (pos != -1) {
            System.out.println("Data : " + x + " Ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data : " + x + " Tidak Ditemukan");
        }
    }

    public void TampilData(String x, int pos) {
        if (pos != -1) {
            System.out.println("Nim  : " + x);
            System.out.println("Nama : " + listMhs[pos].nama);
            System.out.println("Umur : " + listMhs[pos].umur);
            System.out.println("IPK  : " + listMhs[pos].ipk);
        } else {
            System.out.println("Data " + x + " Tidak Ditemukan");
        }

    }

    public int FindBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].nim) {
                return (mid);
            } else if (listMhs[mid].nim > cari) {
                return FindBinarySearch(cari, mid + 1, right);
            } else {
                return FindBinarySearch(cari, mid - 1, left);
            }
        }
        return -1;
    }
}
```

```java
import java.util.Scanner;

public class mahasiswaMain {
    public static void main(String[] args){
        try (Scanner s = new Scanner(System.in)) {
            try (Scanner s1 = new Scanner(System.in)) {
                pencarianMhs data = new pencarianMhs();
                System.out.print("Masukkan jumlah mahasiswa  : ");
                int jumMhs = s.nextInt();
                mahasiswa[] x = new mahasiswa[jumMhs];
                data.listMhs = x;

                System.out.println("-------------------------------------------------------");
                System.out.println("Masukkan data Mahasiswa  : ");
                for (int i = 0; i < jumMhs; i++) {
                    System.out.println("---------------------------");
                    System.out.print("Nama : ");
                    String nama = s1.nextLine();
                    System.out.print("NIM  : ");
                    int nim = s.nextInt();
                    System.out.print("Umur : ");
                    int umur = s.nextInt();
                    System.out.print("IPK  : ");
                    double ipk = s.nextDouble();

                    mahasiswa m = new mahasiswa(nama, nim, umur, ipk);
                    data.tambah(m);
                }

                System.out.println("---------------------------------------------------------");
                System.out.println("Data Keseluruhan Mahasiswa");
                data.tampil();
                System.out.println("Data Mahasiswa setelah sorting asc berdasarkan nim");
                data.selectionSort();
                data.tampil();
                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian Data");
                System.out.println("Masukkan NIM Mahasiswa yang di cari : ");
                System.out.print("NIM   : ");
                int cari = s.nextInt();
                System.out.println("Menggunakan Sequential Search");
                int posisi = data.FindSeqSearch(cari);

                data.TampilPosisi(cari, posisi);

                data.TampilData(cari, posisi);

                System.out.println("=======================================================");
                System.out.println("Menggunakan Binary Search");
                posisi = data.FindBinarySearch(cari, 0, jumMhs - 1);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
            }
        }
    }
}
```

2. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
- Pencarian dilakukan berdasarkan Nama Mahasiswa (gunakan Algoritma Sequential Search)
- Jika terdapat nama yang sama? Bagaimana keluaran dari kode program ketika pencarian
dilakukan pada nama yang sama!

```java
public class t2_Mahasiswa {
    int nim;
    String nama;
    int umur;
    double ipk;

    t2_Mahasiswa(int ni, String n, int u, double i) {
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }

    void tampil() {
        System.out.println("NIM   = " + nim);
        System.out.println("Nama  = " + nama);
        System.out.println("Umur  = " + umur);
        System.out.println("IPK   = " + ipk);
    }
}
```

```java
public class t2_PencarianMhs {
    t2_Mahasiswa listMhs[];
    int idx;

    void tambah(t2_Mahasiswa m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data Sudah Penus !!");
        }
    }

    void tampil() {
        for (t2_Mahasiswa m : listMhs) {
            m.tampil();
            System.out.println("--------------------");
        }
    }

    public int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int i = 0; i < listMhs.length; i++) {
            if (listMhs[i].nim == cari) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

    public int FindSeqSearch(t2_Mahasiswa listMHs[],String cari){
        int posisi=-1;
        for (int j = 0; j < listMHs.length; j++) {
            if (cari.equalsIgnoreCase(listMHs[j].nama)) {
                posisi=j;
                TampilPosisi(cari,posisi);
                TampilData(cari,posisi);
            }
        }
        return posisi;
    }

    public void TampilPosisi(String x, int pos) {
        if (pos != -1) {
            System.out.println("Data : " + x + " Ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data : " + x + " Tidak Ditemukan");
        }
    }

    public void TampilData(String x, int pos) {
        if (pos != -1) {
            System.out.println("Nim  : " + x);
            System.out.println("Nama : " + listMhs[pos].nama);
            System.out.println("Umur : " + listMhs[pos].umur);
            System.out.println("IPK  : " + listMhs[pos].ipk);
        } else {
            System.out.println("Data " + x + " Tidak Ditemukan");
        }

    }

    public int FindBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].nim) {
                return (mid);
            } else if (listMhs[mid].nim > cari) {
                return FindBinarySearch(cari, mid + 1, right);
            } else {
                return FindBinarySearch(cari, mid - 1, left);
            }
        }
        return -1;
    }
}
```

```java
import java.util.Scanner;

public class t2_MahasiswaMain {
    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {
            try (Scanner s1 = new Scanner(System.in)) {
                t2_PencarianMhs data = new t2_PencarianMhs();
                System.out.print("Masukkan jumlah mahasiswa  : ");
                int jumMhs = s.nextInt();
                t2_Mahasiswa[] x = new t2_Mahasiswa[jumMhs];
                data.listMhs = x;

                System.out.println("-------------------------------------------------------");
                System.out.println("Masukkan data Mahasiswa : ");
                for (int i = 0; i < jumMhs; i++) {
                    System.out.println("---------------------------");
                    System.out.print("NIM  : ");
                    int nim = s.nextInt();
                    System.out.print("Nama : ");
                    String nama = s1.nextLine();
                    System.out.print("Umur : ");
                    int umur = s.nextInt();
                    System.out.print("IPK  : ");
                    double ipk = s.nextDouble();

                    t2_Mahasiswa m = new t2_Mahasiswa(nim, nama, umur, ipk);
                    data.tambah(m);
                }

                System.out.println("---------------------------------------------------------");
                System.out.println("Data Keseluruhan Mahasiswa");
                data.tampil();
                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian Data");
                System.out.println("Masukkan Nama Mahasiswa yang di cari : ");
                System.out.print("Nama   : ");
                String cari = s1.nextLine();
                System.out.println("\nMenggunakan Sequential Search");
                data.FindSeqSearch(data.listMhs, cari);
            }
        }
    }
}
```

3. Terdapat sebuah data array 1 dimensi sebagai berikut

0  1  2 3 4  5  6  7  8 9
12 17 2 1 70 50 90 17 2 90

Buatlah program untuk mengurutkan array tersebut (boleh memilih metode pengurutan)
selanjutnya lakukan pencarian dan mencetak isi array yang nilainya terbesar, dan mencetak ada
berapa buah nilai terbesar tersebut serta berada dilokasi mana saja nilai terbesar tersebut!
(menggunakan binary search)

```java
public class array1Dimensi {

    public int[] data;
    public int max = 0;
    public int posisi;
    public int jumlah = 0;

    array1Dimensi(int nilai[]) {
        data = nilai;
    }

    void tampil() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            System.out.println();
        }
    }

    void bubblesort() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int n = 1; n < data.length - i; n++) {
                if (data[n] > data[n - 1]) {
                    int tmp = data[n];
                    data[n] = data[n - 1];
                    data[n - 1] = tmp;
                }
            }
        }
    }

    public int Searching(int cari, int kiri, int kanan) {
        int mid;
        if (kanan >= kiri) {
            mid = (kiri + kanan) / 2;
            if (cari == data[mid]) {
                return (mid);
            } else if (data[mid] > cari) {
                return Searching(cari, mid + 1, kanan);
            } else {
                return Searching(cari, kiri, mid - 1);
            }
        }
        return -1;
    }

    public int nilaiTerbesar() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        System.out.println("Nilai terbesar adalah : " + max);
        return max;
    }

    public void tampilPosisi(int pos) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == max) {
                jumlah++;
            }
        }
        System.out.print("berjumlah " + jumlah);
        System.out.println();
        posisi = max;
        for (int i = 0; i < data.length; i++) {
            if (posisi == data[i]) {
                pos = i;
                System.out.println("Data berada pada indeks ke-" + pos);
            }
        }
    }
}
```

```java
public class array1DimensiMain {

    public static void main(String[] args) {
        int bil[] = {12, 17, 2, 1, 70, 50, 90, 17, 2, 90};
        
        array1Dimensi arr = new array1Dimensi(bil);
        
        int jum = 10;
        int max = 0;
        System.out.println("===============================");
        System.out.println("Sebelum di sorting");
        arr.tampil();
        arr.bubblesort();
        System.out.println("===============================");
        System.out.println("Setelah di sorting");
        arr.tampil();
        arr.nilaiTerbesar();
        arr.Searching(max, 0, jum - 1);
        arr.tampilPosisi(max);
    }
}
```