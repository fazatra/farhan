# M Farhan R P / 21 / 1F

# Jobsheet 2
Objek

# 2.2 Deklarasi Class, Atribut dan Method
```java
package Barang;

public class Barang {
    String namaBarang, jenisBarang;
    int stok, hargaSatuan;

    Barang(){
    }
    Barang(String nm, String jn, int st, int hs){
        namaBarang = nm;
        jenisBarang = jn;
        stok = st;
        hargaSatuan= hs;
    }

    void tampilBarang(){
        System.out.println("Nama = "+namaBarang);
        System.out.println("Jenis = "+jenisBarang);
        System.out.println("Stok = "+stok);
        System.out.println("Harga Satuan = "+hargaSatuan);
    }

    void tambahStok(int n){
        stok=stok+n;
    }

    void kurangStok(int n){
        stok=stok-n;
    }

    int hitungHargaTotal(int jumlah){
        return jumlah*hargaSatuan;
    }
}
```

# 2.2.3 Pertanyaan
1. Sebutkan 2 karakteristik class/objek! 

Object : Memiliki sesuatu (Atribut), Bisa melakukan suatu tingkat (Method)

Class : Memiliki Atribut dan Method (Rancangan)

2. Kata kunci apakah yang digunakan untuk mendeklarasikan class?

class //deklarasi nama class

3. Perhatikan class Barang yang ada di Praktikum di atas, ada berapa atribut yang dimiliki oleh class 
tersebut? Sebutkan! Dan pada baris berapa saja deklarasi atribut dilakukan?

4 atribut, (namaBarang, jenisBarang, stok, hargaSatuan), baris 13 dan 14 dideklarasikan

4. Ada berapa method yang dimiliki oleh class tersebut? Sebutkan! Dan pada baris berapa saja 
deklarasi method dilakukan?

4 method, (tampilBarang, tambahStok, kurangiStok, hitungHargaTotal), baris 16,23,27 dan 31

5. Perhatikan method kurangiStok() yang ada di class Barang, modifikasi isi method tersebut 
sehingga proses pengurangan hanya dilakukan jika stok masih ada (masih lebih besar dari 0) 

<img src = "Screenshot(842).png">

6. Menurut Anda, mengapa method tambahStok() dibuat dengan memiliki 1 parameter berupa 
bilangan int?

untuk menghitung tambahan stok

7. Menurut Anda, mengapa method hitungHargaTotal() memiliki tipe data int?

untuk me-return jumlah * hargaSatuan (hargaTotal) dan digunakan untuk int

8. Menurut Anda, mengapa method tambahStok() memiliki tipe data void?

karena tidak menggunakan return nilai / value

# 2.3 Instansiasi Objek dan Mengakses Atribut & Method

```java
package Barang;

public class BarangMain {
    public static void main(String[] args) {
        Barang b1 = new Barang();
        b1.namaBarang = "Corsair 2 GB";
        b1.jenisBarang = "DDR";
        b1.hargaSatuan = 250000;
        b1.stok = 10;
        b1.tambahStok(1);
        b1.kurangStok(3);
        b1.tampilBarang();
        int hargaTotal = b1.hitungHargaTotal(4);
        System.out.println("Harga 4 buah = "+hargaTotal);
        Barang b2 = new Barang("Logitech", "Wireless Mouse", 25,150000);
        b2.tampilBarang();
    }
}
```

<img src = "Screenshot(841).png">

# 2.3.3 Pertanyaan

1. Pada class BarangMain, pada baris berapakah proses instansiasi dilakukan? Dan apa nama objek 
yang dihasilkan?

Baris ke-14, "Barang b1"

2. Bagaimana cara mengakses atribut dan method dari suatu objek?

Atribut

namaObjek.namaAtribut = nilai;  (b1.stok = 10;)

Method
namaObjek.namaMethod(); (b1.tampilBarang();

# 2.4 Membuat Konstruktor

<img src="Screenshot (843).png">

# 2.5 Latihan Praktikum

# nomor 1

```java
package barang2;

public class Barang {
    String nama;
    int hargaSatuan, jumlah;
    
    Barang(){

    }

    int hitungHargaTotal(int hs, int jml){
        hargaSatuan = hs;
        jumlah = jml;
        return hs*jml;
    }
    
    int hitungDiskon(){
        int ht = hitungHargaTotal(hargaSatuan, jumlah);
        double d = 0;
        int dis;
        if( ht > 100000){
            d = ht * 0.1;
            dis = (int) d;
            return dis;
        }else if(ht <= 100000 && ht >= 50000){
            d = ht * 0.05;
            dis = (int) d;
            return dis;
        } else return 0;
        
    }

    int hitungHargaBayar(){
        int hb = hitungHargaTotal(hargaSatuan, jumlah) - hitungDiskon();
        return hb; 
    }

}
```

```java
package barang2;

import java.util.Scanner;
public class BarangMain {
    public static void main(String[] args) {
        Barang l1 = new Barang();
        try (Scanner zh = new Scanner(System.in)) {
            System.out.print("Masukkan nama barang : ");
            l1.nama = zh.nextLine();
            System.out.print("Masukkan harga satuan barang : ");
            l1.hargaSatuan = zh.nextInt();
            System.out.print("Masukkan jumlah barang : ");
            l1.jumlah = zh.nextInt();
        }
        System.out.println("====================================");
        int totalHarga = l1.hitungHargaTotal(l1.hargaSatuan, l1.jumlah);
        System.out.println("Total  : " + totalHarga);
        double diskon = l1.hitungDiskon();
        System.out.println("Diskon : " + diskon);
        double bayar = l1.hitungHargaBayar();
        System.out.println("Total Bayar : " + bayar);

    }
}
```
<img src="Screenshot (844).png">

# nomor 2

```java
package pacman2;

public class pacman {
    int x,y,width,height;

    void moveLeft(){
        if(x<0 && x>width){
            System.out.print("Error");
        }else {
            System.out.println("Bergerak ke kiri");
            x=x-1;
        }
    }
    void moveRight(){
        if(x<0 && x>width){
            System.out.print("Error");
        }else {
            System.out.println("Bergerak ke kanan");
            x=x+1;
        }
    }
    void moveUp(){
        if(y<0 && y>height){
            System.out.print("Error");
        }else {
            System.out.println("Bergerak ke ke atas");
            y=y+1;
        }
    }
    void moveDown(){
        if(y<0 && y>height){
            System.out.print("Error");
        }else {
            System.out.println("Bergerak ke ke bawah");
            y=y-1;
        }
    }
    void printPosition(){
        System.out.println("X = "+x);
        System.out.println("Y = "+y);
    }
}   
```

```java
package pacman2;

public class pacmanMain {
    public static void main(String[] args) {
        pacman p1= new pacman();
        p1.x=5;
        p1.y=3;
        p1.height=10;
        p1.width=10;
        System.out.println("Titik koordinat sebelum bergerak");
        System.out.println("Height = "+p1.height);
        System.out.println("Width = "+p1.width);
        p1.printPosition();
        p1.moveLeft();
        p1.printPosition();
        p1.moveRight();
        p1.printPosition();
        p1.moveUp();
        p1.printPosition();
        p1.moveDown();
        p1.printPosition();
    }
}
```

<img src="Screenshot (844).png">
