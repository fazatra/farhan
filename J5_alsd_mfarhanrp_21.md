# Nama        = Muhammad farhan Riza Putra
# Kelas/absen = TI - 1F / 21

## Jobsheet 5

### 4.2.1 Langkah-langkah Percobaan
```java
public int nilai;
public int faktorialBF(int n){
    int fakto = 1;
    for (int i = 1; i <= n; i++) {
        fakto = fakto * i;
    }
    return fakto;
}
public int faktorialDC(int n){
    if (n==1) {
        return 1;
    }
    else
    {
        int fakto = n * faktorialDC(n-1);
        return fakto;
    }
}
Scanner sc = new Scanner(System.in);
System.out.println("=======================================");
System.out.print("Masukkan nilai data ke-" + (i+1) + " : ");
fk[i].nilai = sc.nextInt();
System.out.println("=======================================");
System.out.println("Hasil Faktorial dengan Brute Force");
for (int i = 0; i < elemen; i++) {
    System.out.println("Faktorial dari nilai " + fk[i].nilai + "adalah : " + fk[i].faktorialBF(fk[i].nilai));
}
System.out.println("=======================================");
System.out.println("Hasil Faktorial dengan Divide and Conquer");
for (int i = 0; i < elemen; i++) {
    System.out.println("Faktorial dari nilai " + fk[i].nilai + "adalah : " + fk[i].faktorialDC(fk[i].nilai));
}
System.out.println("=======================================");
```

### 4.2.3 Pertanyaan
1. Jelaskan mengenai base line Algoritma Divide Conquer untuk melakukan pencarian nilai faktorial!

    if (n==1) return 1; jika nilai yang akan dimasukkan nantinya adalah 1 maka hasil yang akan 
ditampilkan oleh program main nantinya adalah 1 dan berfungsi sebagai batas dari divide 
conquer dimana perulangan kali akan berakhir saat n sudah sama dengan 1.

2. Pada implementasi Algoritma Divide and Conquer Faktorial apakah lengkap terdiri dari 3 tahapan
divide, conquer, combine? Jelaskan masing-masing bagiannya pada kode program!

    Divide : membagi masalah menjadi beberapa masalah yang memiliki kemiripan dengan 
masalah semua namun berukuran lebih kecil. 
Conquer : menyelesaikan masing-masing masalah secara rekursif 
Combine : menngabungkan solusi masing-masing masalah sehingga membentuk solusi 
masalah semula

3. Apakah memungkinkan perulangan pada method faktorialBF() dirubah selain menggunakan
for?Buktikan!

    Bisa, selama termasuk looping maka jenis looping apapun bisa digunakan pada method 
faktorialBF() dan saya sudah mencoba membuktikannya dengan looping jenis while dan 
program tetap berjalan dengan baik.

```java
public int faktorialBF(int n) {
    int fakto = 1;
    for (int i = 1; i <= n; i++) {
        while (i <= n) {
            fakto = fakto * i;
            i++;
        }
    }
}
```

4. Tambahkan pegecekan waktu eksekusi kedua jenis method tersebut!

```java
package minggu5;
import java.util.Scanner;
public class MainFaktorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================================");
        System.out.println("Masukkan jumlah elemen yang ingin dihitung : ");
        int elemen =sc.nextInt();
        
        Faktorial [] fk = new Faktorial [elemen];
        for (int i = 0; i < elemen; i++){
            fk[i] = new Faktorial();
            System.out.println("Masukkan nilai data ke-"+(i+1)+" : ");
            fk[i].nilai = sc.nextInt();
        }
        System.out.println("==================================");
        System.out.println("Hasil Faktorial dengan Brute Force");
        long start = System.currentTimeMillis();
        for (int i = 0; i < elemen; i++){
            System.out.println("Faktorial dari nilai"+fk[i].nilai+ " adalah : "+fk[i].faktorialBF(fk[i].nilai));
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("==================================");
        System.out.println("Hasil Faktorial dengan Brute Force");
        long start2 = System.currentTimeMillis();
        System.out.println(end-start);
        for (int i = 0; i < elemen; i++){
            System.out.println("Faktorial dari nilai"+fk[i].nilai+ " adalah : "+fk[i].faktorialDC(fk[i].nilai));
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
        System.out.println("===================================");
            }
        }

```

5. Buktikan dengan inputan elemen yang di atas 20 angka, apakah ada perbedaan waktu eksekusi?

```java
public class FaktorialMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        System.out.println("================================");
        System.out.print("Masukkan jumlah elemen yang diinginkan: ");
        int elemen = sc.nextInt();

        Faktorial[] fk = new Faktorial[elemen];
        for(int i = 0; i < elemen; i++){
            fk[i] = new Faktorial();
            System.out.print("Masukkan nilai data ke-" + (i+1) + " : ");
            fk[i].nilai = sc.nextInt();
        }
            System.out.println("================================");
            System.out.println("Hasil faktorial dengan brute force");
            long start = System.nanoTime();
            for(int i= 0; i < elemen; i++){
                System.out.println("Faktorial dari nilai " + fk[i].nilai + " adalah :" + fk[i].faktorialBF(fk[i].nilai));
            }
            long end = System.nanoTime();
            long eksekusi = (end-start);
            System.out.println(eksekusi + " nano detik");

            System.out.println("================================");
            System.out.println("Hasil faktorial dengan divide & conquer");
            start = System.nanoTime();
            for(int i= 0; i < elemen; i++){
                System.out.println("Faktorial dari nilai " + fk[i].nilai + " adalah :" + fk[i].faktorialDC(fk[i].nilai));
        }
            end = System.nanoTime();
            eksekusi = (end-start);
            System.out.println(eksekusi + " nano detik");
    }

}
```
 

### 4.3.1 Langkah-langkah Percobaan
```java
public int nilai,pangkat;
public int pangkatBF(int a, int n) {
    int hasil = 1;
    for (int i = 0; i < n; i++) {
        hasil = hasil * a;
    }
    return hasil;
}
public int pangkatDC(int a, int n) {
    if (n==0) {
        return 1;
    }
    else
    {
        if(n%2==1)//bilangan ganjil
            return (pangkatDC(a,n/2) *pangkatDC(a,n/2) *a);
        else//bilangan genap
            return (pangkatDC(a,n/2) *pangkatDC(a,n/2));
    }
}
Scanner sc = new Scanner(System.in);
System.out.println("==============================================");
System.out.print("Masukkan jumlah elemen yang ingin dihitung : ");
int elemen = sc.nextInt();
Pangkat [] png = new Pangkat[elemen];

for (int i = 0; i < elemen; i++) {
    png[i] = new Pangkat();
    System.out.print("Masukkan nilai yang akan dipangkatkan ke-" + (i+1) + " : ");
    png[i].nilai = sc.nextInt();
    System.out.print("Masukkan nilai pemangkat ke-" + (i+1) + " : ");
    png[i].pangkat = sc.nextInt();
}
System.out.println("==============================================");
System.out.println("Hasil Pangkat dengan Brute Force");
for (int i = 0; i < elemen; i++) {
    System.out.println("Nilai " + png[i].nilai + "pangkat " + png[i].pangkat + "adalah : " + png[i].pangkatBF(png[i].nilai,png[i].pangkat);
}
System.out.println("==============================================");
System.out.println("Hasil Pangkat dengan Divide and Conquer");
for (int i = 0; i < elemen; i++) {
    System.out.println("Nilai " + png[i].nilai + "pangkat " + png[i].pangkat + "adalah : " + png[i].pangkatDC(png[i].nilai,png[i].pangkat);
}
System.out.println("==============================================");
```

### 4.3.3 Pertanyaan
1. Jelaskan mengenai perbedaan 2 method yang dibuat yaitu PangkatBF() dan PangkatDC()!
- Pada method pangkatBF() operasi mencari hitung hasil pangkat dilakukan dengan cara 
bruteforce yang dilakukan dengan iterative/perulangan/looping dan algoritma brute forcenya 
adalah mendeklarasikan dahulu hasil = 1 lalu melakukan perulangan dengan batas n 
(pangkatnya) dan dalam perulangan tersebut dilakukan looping dari hasil tadi di kali dengan a 
(bilangan yang akan dipangkat) dan perulangan akan terus berlanjut hingga < n sehingga a akan 
menghasilkan nilai hasil dari pemangkatannya.
- Pada method pangkatDC() operasi mencari hitung hasil pangkat dilakukan dengan cara 
divide conquer yang dilakukan dengan rekursif dan algoritma divide conquer yang 
dilakukan terbagi dalam 3 tahap yaitu : divide => memecah masalah jadi upa masalah yang 
diimplementasikan dalam pemilihan kondisi berupa if-else pada method, lalu ada conquer 
=> penyelesaian dari setiap upa masalah yang tercantum pada else dan terakhir ada 
combine => menggabungkan kembali menjadi sebuah solusi yang diimplementasikan pada 
return an di else.

2. Pada method PangkatDC() terdapat potongan program sebagai berikut:

```java
if(n%2==1)//bilangan ganjil
return (pangkatDC(a,n/2)*pangkatDC(a,n/2)*a);
else//bilangan genap
return (pangkatDC(a,n/2)*pangkatDC(a,n/2));
```

Jelaskan arti potongan kode tersebut
- Jika n (pangkat bilangan) dimodulus 2 hasilnya adalah 1 maka returnnya (kembalian nilai) 
adalah hasil dari (pangkatDC(a,n/2)*pangkatDC(a, n/2)*a) karena bilangan pangkatnya adalah 
ganjil 
- Jika n (pangkat bilangan) dimodulus 2 hasilnya adalah tidak sama dengan 1 maka returnnya 
(kembalian nilai) adalah hasil dari (pangkatDC(a,n/2)*pangkatDC(a, n/2) karena bilangan 
pangkatnya adalah genap

3. Apakah tahap combine sudah termasuk dalam kode tersebut?Tunjukkan!

    Sudah, tahap combine dalam kode tersebut ditunjukan pada sintaks return atau pengembalian  nilai dimana hasil dari conquer atau penyelesaian upa masalah sebelumnya di return kan semua dan dalam tahap combine dilakukan pemanggilan hasil dari bilangan berpangkat tersebut.

4. Modifikasi kode program tersebut, anggap proses pengisian atribut dilakukan dengan
konstruktor.
```java
Scanner sc = new Scanner (System.in);

System.out.println("============================");
Pangkat[] png = new Pangkat[5];
png[0] = new Pangkat(10,2);
png[1] = new Pangkat(8,3);
png[2] = new Pangkat(4,2); //konstruktor
png[3] = new Pangkat(3,5);
png[4] = new Pangkat(8,3);

System.out.println("==============================================");
System.out.println("Hasil Pangkat dengan Brute Force");
for (int i = 0; i < elemen; i++) {
    System.out.println("Nilai " + png[i].nilai + "pangkat " + png[i].pangkat + "adalah : " + png[i].pangkatBF(png[i].nilai,png[i].pangkat);
}
System.out.println("==============================================");
System.out.println("Hasil Pangkat dengan Divide and Conquer");
for (int i = 0; i < elemen; i++) {
    System.out.println("Nilai " + png[i].nilai + "pangkat " + png[i].pangkat + "adalah : " + png[i].pangkatDC(png[i].nilai,png[i].pangkat);
}
System.out.println("==============================================");
```

5. Tambahkan menu agar salah satu method yang terpilih saja yang akan dijalankan!
```java
Scanner sc = new Scanner (System.in);
char keluar;
System.out.println("============================");
Pangkat[] png = new Pangkat[5];
png[0] = new Pangkat(2,2);
png[1] = new Pangkat(3,3);
png[2] = new Pangkat(4,4); //konstruktor
png[3] = new Pangkat(5,5);
png[4] = new Pangkat(6,6);
do {
    System.out.println("=========================================");
    System.out.println("Hitung Pangkat Brute Force dan Divide Conquer");
    System.out.println("=========================================");
    System.out.println("Menu Hitung : ");
    System.out.println("1. Hitung Brute Force");
    System.out.println("2. Hitung Divide Conquer");
    System.out.println("3. Keluar");
    int menu = sc.next();
    switch (menu) {
        case 1 :
        System.out.println("Hasil Pangkat dengan Brute Force");
        for (int i=0; i<png.length; i++) {
            System.out.println("Nilai " + png[i].nilai + "pangkat " + png[i].pangkat + "adalah : " + png[i].pangkatDC(png[i].nilai,png[i].pangkat);
        }
        break;
    }
}
```


### 4.4.1 Langkah-langkah Percobaan
```java
import java.util.Scanner;
class MainSum{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta. Misal 5.9 ");
        System.out.print("Masukkan jumlah bulan : ");
        int elm = sc.nextInt();
        
        Sum sm = new Sum(elm);
        System.out.println("=============================================");
        for(int i=0; i<sm.elemen; i++){
            System.out.print("Masukkan untung bulan ke - "+(i+1)+" = ");
            sm.keuntungan[i] = sc.nextDouble();
        }
        
        System.out.println("=============================================");
        System.out.println("Algoritma Brute Force");
        System.out.println("Total keuntungan perusahaan selama "+sm.elemen+" bulan adalah = "+sm.totalBF(sm.keuntungan));
        System.out.println("=============================================");
        System.out.println("Algoritma Divide Conquer");
        System.out.println("Total keuntungan perusahaan selama "+sm.elemen+" bulan adalah = "+sm.totalDC(sm.keuntungan, 0, sm.elemen-1)); 
    }
}
```

### 4.4.3 Pertanyaan
1. Berikan ilustrasi perbedaan perhitungan keuntungan dengan method TotalBF() ataupun TotalDC()

    pangkatBF memproses langsung inputan, sedangkan pangkatDC membagi atau  memecah sebuah inputan lalu menjulahkannya lagi di akhir proses

2. Perhatikan output dari kedua jenis algoritma tersebut bisa jadi memiliki hasil berbeda di belakang koma. Bagaimana membatasi output di belakang koma agar menjadi standar untuk kedua jenis algoritma tersebut.

    Membagi masalah menjadi beberapa masalah yang mempunyai kemiripan masalah 
namun masalah tersebut berukuran lebih kecil lalu menyelesaikan masing-masing masalah 
secara rekrusif dan menggabungkan sebuah solusi masalah sehingga membentuk sebuah 
solusi masalah semula


3. Mengapa terdapat formulasi return value berikut?Jelaskan!

    Untuk mereturnkan semua hasil dari penjumlahan keuntungan dari lsum (penjumlahan left/kiri) lalu dengan rsum (penjumlahan right/kanan) dan dengan arr[mid] (penjumlahan mid/tengah), sehingga dari penjumlahan ketiganya bisa diketemukan berapa banyak keuntungan yang didapat dari perusahaan tersebut dalam rentang waktu n bulan.

4. Kenapa dibutuhkan variable mid pada method TotalDC()?

    Karena perhitungan keuntungan pada method totalDC() tersebut membagi bagiannya menjadi left(l) dan right(r) dan dibutuhkan variable mid untuk menghitungan semua bagian tengahnya. Misalkan array = 1,2,3,4,5 maka l adalah indeks 0/awal dan r adalah indeks 4/terakhir dan l masih belum == dengan r maka dibagi menjadi 2 bagian dan mid = indeks 2 karena (l+r)/2. Lalu pada bagian left berarti dimulai dari indeks l(l=0) dan diakhiri indeks mid-1, sedangkan pada bagian right dimulai dari indeks mid dan diakhiri r (r=4). Dan terus menerus dibagi 2 hingga indeks l==r dan mereturnkan nilai tersebut.

5. Program perhitungan keuntungan suatu perusahaan ini hanya untuk satu perusahaan saja. Bagaimana cara menghitung sekaligus keuntungan beberapa bulan untuk beberapa perusahaan.(Setiap perusahaan bisa saja memiliki jumlah bulan berbeda-beda)? Buktikan dengan program!
```java
public class SumMain {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("Program menghitung keuntungan total (Satuan juta, misal 5.9)");
        System.out.print("Masukkan banyak perusahaan: ");
        int per = sc.nextInt();
        Sum[] sm = new Sum[per];

        for(int i=0; i<sm.length; i++ ){
            System.out.print("Masukkan jumlah bulan untuk perusahan ke-" + (i+1) + ": " );
            int elm = sc.nextInt();
            sm[i] = new Sum(elm);
            for(int j=0; j<sm[i].elemen; j++){
                System.out.print("Masukkan untung bulan ke-" +(j+1) + " = ");
                sm[i].keuntungan[j]= sc.nextDouble(); 
            }
            System.out.println("===================================");
            System.out.println("Algoritma Brute Force");
            System.out.println("Total keuntungan perusahaan selama " + sm[i].elemen + " bulan adalah = " + sm[i].totalBF(sm[i].keuntungan));
            System.out.println("===================================");
            System.out.println("Algoritma Divide & Conquer");
            System.out.println("Total keuntungan perusahaan selama " + sm[i].elemen + " bulan adalah = " + sm[i].totalDC(sm[i].keuntungan, 0, sm[i].elemen-1));
        }
    }
}
```

### 4.5 Latihan Praktikum
```java
public class Latihan {
    public int vote, jumlahVote, jumlahKandidat = 4;
    public String kandidat;
    public int nilai, acc, control = 0;
    public int[] array = new int[10000];

    public int hitungHasil(int js, int k1, int k2, int k3, int k4){
        if(nilai == 5){
            nilai = 1;
        }
        if (nilai == 1 && k1 > 0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1 - 1, k2, k3, k4);
        }else if (nilai == 2 && k2 > 0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1, k2 - 1, k3, k4);
        }else if (nilai == 3 && k3 > 0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1, k2, k3 - 1, k4);
        }else if (nilai == 4 && k4 > 0){
            array[control] = nilai;
            control++;
            nilai++;
            return hitungHasil(js, k1, k2, k3, k4 - 1);
        }else if (k1 == 0 && k2 == 0 && k3 == 0 && k4 == 0){
            if (array[acc] == array[acc+1] && acc+1 < js){
                return array[acc];

            }else if (acc + 2 < js){
                acc += 2;
                return hitungHasil(js, k1, k2, k3, k4);
            }else{
                return 0;
            }
        }else{
            nilai++;
            return hitungHasil(js, k1, k2, k3, k4);
        }
    }
}
```

```java
import java.util.Scanner;

public class LatihanMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================================================");
        System.out.println("\t\t PEMILIHAN KETUA BEM KOTA MALANG");
        System.out.println("=======================================================");
        Latihan pol = new Latihan();
        Latihan[] bem = new Latihan[pol.jumlahKandidat];
        
        for(int i = 0; i < pol.jumlahKandidat; i++) {
            bem[i] = new Latihan();
            System.out.println("Nama Kandidat BEM ke- " + (i+1) + ": ");
            bem[i].kandidat = sc.nextLine();
        }
        for (int i = 0; i < pol.jumlahKandidat; i++) {
            System.out.println("Jumlah Pemilih Suara Kandidat BEM ke = " + (i+1) + ": ");
            bem[i].vote = sc.nextInt();
            pol.jumlahVote += bem[i].vote;
        }
        System.out.println("=======================================================");
        int hasil_bem = pol.hitungHasil(pol.jumlahVote, bem[0].vote, bem[1].vote, bem[2].vote, bem[3].vote);
        if(hasil_bem == 0) {
            System.out.println("Kandidat memiliki mayoritas hampir sama");
        }else{
            System.out.println("Ketua BEM Kota Malang Adalah " + bem[hasil_bem-1].kandidat);
        }
    }
}
```