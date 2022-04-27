# Nama        = Muhammad farhan Riza Putra
# Kelas/absen = TI - 1F / 21

## Pertemuan 10

## 8.4 Tugas

# 1

```java
public class Queue {

    int max;
    int size;
    int front;
    int rear;
    int[] Q;

    public Queue(int n) {
        max = n;
        Create();
    }

    public void Create() {
        Q = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen Terdepan :" + Q[front]);
        } else {
            System.out.println("Queue Masih Kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong!!");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(Q[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(Q[i] + " ");
            System.out.println("Jumlah elemen : " + size);
        }
    }

    public void peekAt(int posisi) {
        if (!IsEmpty()) {
            if (Q[posisi] == 0) {
                System.out.println("Data Pada Index ke" + posisi + " Masih Kosong");
            } else {
                System.out.println("Data yang ada di Index " + posisi + " adalah " + Q[posisi]);
            }
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekPosition(int data) {
        if (!IsEmpty()) {
            int abc = 0;
            for (int i = 0; i < Q.length; i++) {
                if (data == Q[i]) {
                    System.out.println("Data " + data + " Berada di Index ke-" + i);
                    abc++;
                }
            }
            if (abc == 0) {
                System.out.println("Data " + data + " Tidak Ditemukan");
            }
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void clear() {
        if (!IsEmpty()) {

            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil di kosongkan ");
        } else {
            System.out.println("Queue masih kosong");
        }

    }

    public void Enqueue(int data) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh ");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            Q[rear] = data;
            size++;
        }
    }

    public int Dequeue() {

        int data = 0;
        if (IsEmpty()) {
            System.out.println("Queue Masih kosong");
        } else {
            data = Q[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return data;
    }
}
```

```java
import java.util.Scanner;

public class QueueMain {

    public static void menu() {
        System.out.println("Masukkan Operasi yang diinginkan");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek ");
        System.out.println("5. Peek Position");
        System.out.println("6. Peek At");
        System.out.println("7. Clear");
        System.out.println("--------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Kapasitas Queue = ");
        int n = sc.nextInt();
        int pilih;
        Queue Q = new Queue(n);
        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan Data Baru = ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if (dataKeluar != 0) {
                        System.out.println("Data Yang Dikeluarkan = " + dataKeluar);
                        break;
                    }
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
//                    
                    break;
                case 5:
                    System.out.print("Masukkan Data yang Dicari = ");
                    int cari = sc.nextInt();
                    Q.peekPosition(cari);

                    break;
                case 6:
                    System.out.print("Masukkan Index yang ingin ditampilkan Datanya = ");
                    int posisi = sc.nextInt();
                    Q.peekAt(posisi);
                    break;
                case 7:
                    Q.clear();
                    break;
            }
        } while (pilih > 0 || pilih < 8);
    }
}
```

# 2

```java
public class Queue {
    Mahasiswa antrian[];
    int front;
    int rear;
    int size;
    int max;
    
    public Queue(int n){
        max = n;
        antrian = new Mahasiswa[max];
        size = 0;
        front = rear = -1;
    }
    
    public boolean isEmpty(){
        if(size == 0){
            return true;
        } else {
            return false;
        }
        
    }
    
    public boolean isFull(){
        if(size == max){
            return true;
        } else {
            return false;
        }
    }
    
    public void peek(){
        if(!isEmpty()){
            System.out.println("Elemen terdepan: " + antrian[front].nim + " " + antrian[front].nama + " " + antrian[front].absen + " " 
            + antrian[front].ipk);
        }else{
            System.out.println("Queue masih kosong");
        }
    }
    
    public void peekRear(){
        if(!isEmpty()){
            System.out.println("Elemen terdepan: " + antrian[rear].nim + " " + antrian[rear].nama + " " + antrian[rear].absen + " " 
            + antrian[rear].ipk);
        }else{
            System.out.println("Queue masih kosong");
        }
    }
    
    public void print(){
        if(isEmpty()){
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear){
                System.out.println(antrian[i].nim + " " + antrian[i].nama + " " + antrian[i].absen + " " 
            + antrian[i].ipk);
                i = (i + 1) % max;
            }
            System.out.println(antrian[i].nim + " " + antrian[i].nama + " " + antrian[i].absen + " " 
            + antrian[i].ipk);
            System.out.println("Jumlah elemen: " + size);
        }
    }
    
    public void peekPosition(String nimm){
        if(!isEmpty()){
            for(int i = 0; i < max; i++){
                if(antrian[i].nim.equals(nimm)){
                    System.out.println("Mahasiswa dengan NIM  " + nimm + " ditemukan di indeks ke-" + i);
                } 
            }
        } else {
            System.out.println("Queue masih kosong");
        }
    }
    
    public void printMahasiswa(int position){
        if(!isEmpty()){
            System.out.println("Mahasiswa pada indeks ke-" + position + " adalah " + antrian[position].nama);
        } else {
            System.out.println("Queue masih kosong");
        }
    }
    
    public void enqueue(Mahasiswa antri){
        if(isFull()){
            System.out.println("Queue sudah penuh");
        } else { 
            if(isEmpty()){
                front = rear = 0;
            } else {
                if (rear == max - 1){
                    rear = 0;
                } else {
                    rear++;
                }
            }
            antrian[rear] = antri;
            size++;
        }
    }
    
    public Mahasiswa dequeue(){
        Mahasiswa antri = new Mahasiswa();
        if(isEmpty()){
            System.out.println("Queue masih kosong");
        } else {
            antri = antrian[front];
            size--;
            if(isEmpty()){
                front = rear = -1;
            } else {
                if(front == max - 1){
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return antri;
    }
}
```

```java
import java.util.Scanner;

public class QueueMain {
    public static void menu(){
        System.out.println("Pilih menu: ");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Kurangi Data Mahasiswa");
        System.out.println("3. Cek data mahasiswa paling awal");
        System.out.println("4. Cek data mahasiswa terakhir");
        System.out.println("5. Cek semua antrian");
        System.out.println("6. Cari penempatan mahasiswa berdasar NIM");
        System.out.println("7. Cari mahasiswa dengan indeks");
        System.out.println("==============");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        
        System.out.print("Masukkan kapasitas Queue: ");
        int jumlah = sc.nextInt();
        
        Queue antri = new Queue(jumlah);
        
        int pilih;
        
        do{
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih){
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Absen: ");
                    int absen = s.nextInt();
                    System.out.print("IPK: ");
                    double ipk = s.nextDouble();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, absen, ipk);
                    antri.enqueue(mhs);
                    break;
                
                case 2:
                    Mahasiswa data = antri.dequeue();
                    if(!"".equals(data.nim) && !"".equals(data.nama) && data.absen != 0 && data.ipk !=
                            0) {
                        System.out.println("Antrian yang keluar: " + data.nim + " " + data.nama + " " + data.absen + " " 
                        + data.ipk);
                        break;
                    }
                
                case 3:
                    antri.peek();
                    break;
                
                case 4:
                    antri.peekRear();
                    break;
                    
                case 5:
                    antri.print();
                    break;
                    
                case 6:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimmhs = sc.nextLine();
                    antri.peekPosition(nimmhs);
                    break;
                    
                case 7:
                    System.out.print("Masukkan indeks yang dicari: ");
                    int indeks = s.nextInt();
                    antri.printMahasiswa(indeks);
                    break;
            }
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7);
    }
}
```

```java
public class Mahasiswa {
    String nim;
    String nama;
    int absen;
    double ipk;
    
    public Mahasiswa(String nim, String nama, int absen, double ipk){
        this.nim = nim;
        this.nama = nama;
        this.absen = absen;
        this.ipk = ipk;
    }
    
    public Mahasiswa(){
        
    }
}
```
