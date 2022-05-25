# Nama        = Muhammad Farhan Riza Putra
# Kelas/absen = TI - 1F / 21

## Pertemuan 12

# **12.2 Kegiatan Praktikum 1**

# **12.2.3 Pertanyaan**
1.  - Single Linked List : Tidak bisa kembali ke node sebelumnya (tidak ada prev)
    - Double Linked List : Bisa kembali ke node sebelumnya (ada prev)

2. Digunakan untuk ke node selanjutnya (next) dan sebelumnya (prev)

3. Artinya Linked List kosong tidak ada data

4. Karena tidak ada data sebelumnya first

5. data sebelum head adalah Node baru yang akan menjadi head baru

6. Membuat Node Last yang baru dan Node last lama menjadi previous dari Node Last baru (current) dan next (null) berarti memang tidak ada data selanjutnya

# **12.3 Kegiatan Praktikum 2**

## **12.3.3 Pertanyaan**

1. Head baru adalah node setelah head lama, head baru head.prev nya null

2. Dilihat apakah head.next = null dengan while Node current = head hingga current.next.next = null berhenti dan head = null

3. karena menggunakan head dan akan menjadikan yang diremove head baru

4. menggabungkan bagian kosong di current yang dihapus

# **12.4 Kegiatan Praktikum 3**

## **12.4.3 Pertanyaan Percobaan**

1. return size untuk mengetahui beraba besar size pada class

2. Dengan memberi nilai 0 pada indeks ke-0 dengan addFirst()

3. Menambah Node baru pada class

4.  - **A** = Berarti Node-nya dimulai dari 0 sehingga ada nilainya
    - **B** = Berarti Node head tidak ada di satupun linked list jadi tidak ada sama sekali

# **12.5 Tugas Praktikum**

# 1

```java
public class Tugas1_DoubleLinkedList {

    Tugas1_Node front, rear;
    int size;

    public Tugas1_DoubleLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void Enqueue(int nomor, String nama) {
        Tugas1_Node newNode = new Tugas1_Node(null, nomor, nama, null);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void Dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list masih kosong, tidak dapat dihapus");
        } else if (size == 1) {
            removeLast();
        } else {
            System.out.println(front.nama + " telah selesai divaksin");
            front = front.next;
            front.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list masih kosong, tidak dapat dihapus");
        } else if (front.next == null) {
            front = null;
            size--;
            return;
        }
        Tugas1_Node current = front;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void print() {
        if (!isEmpty()) {
            Tugas1_Node tmp = front;
            System.out.println("+++++++++++++++++++++++");
            System.out.println("Daftar Pengantri Vaksin");
            System.out.println("+++++++++++++++++++++++");
            System.out.println("|Nomor\t|Nama\t|");
            while (tmp != null) {
                System.out.println("|" + tmp.nomor + "\t|" + tmp.nama + "\t|");
                tmp = tmp.next;
            }
            System.out.print("Sisa Antrian: " + size);
            System.out.println("");
        } else {
            System.out.println("Linked List Kosong");
        }
    }
}
```

```java
import java.util.Scanner;

public class Tugas1_DoubleLinkedListMain {

    public static void menu() {
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("1. Tambah Data Penerima Vaksin");
        System.out.println("2. Hapus Data Pengantri Vaksin");
        System.out.println("3. Daftar Penerima Vaksin");
        System.out.println("4. Keluar");
        System.out.println("++++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner sss = new Scanner(System.in);
        int menu = 0;

        Tugas1_DoubleLinkedList dll = new Tugas1_DoubleLinkedList();

        while (menu != 4) {
            menu();
            menu = sc.nextInt();
            System.out.println("=====================================");
            try {
                switch (menu) {
                    case 1:
                        System.out.println("-----------------------------");
                        System.out.println("Masukkan Data Penerima Vaksin");
                        System.out.println("-----------------------------");
                        System.out.print("Nomor Antrian: ");
                        int no = sc.nextInt();
                        System.out.print("Nama Penerima: ");
                        String nama = sss.nextLine();
                        dll.Enqueue(no, nama);
                        System.out.println("-------------------");
                        dll.print();
                        break;
                    case 2:
                        dll.Dequeue();
                        dll.print();
                        break;
                    case 3:
                        dll.print();
                        break;
                    case 4:
                        System.out.println("KELUAR");
                        break;
                }
                System.out.println();
            } catch (Exception e) {

            }
        }
    }
}
```

```java
public class Tugas1_Node {

    String nama;
    int nomor;
    Tugas1_Node prev, next;

    Tugas1_Node(Tugas1_Node prev, int nomor, String nama, Tugas1_Node next) {
        this.prev = prev;
        this.nama = nama;
        this.nomor = nomor;
        this.next = next;
    }
}
```

# 2
```java
public class movie {
    nodeF head;
    int size;
    
    public movie(){
        head = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addFirst(String id, String judul, double rating){
        if(isEmpty()){
            head = new nodeF(null, id, judul, rating, null);
        } else {
            nodeF newNode = new nodeF(null, id, judul, rating, null);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(String id, String judul, double rating){
        if(isEmpty()){
            addFirst(id, judul, rating);
        } else {
            nodeF current = head;
            while(current.next != null){
                current = current.next;
            }
            nodeF newNode = new nodeF(current, id, judul, rating, null);
            current.next = newNode;
            size++;
        }
    }
    
    public void add(String id, String judul, double rating, int index) throws Exception {
        if(isEmpty()){
            addFirst(id, judul, rating);
        } else if (index < 0 || index > size){
            throw new Exception("Nilai index film diluar batas");
        } else {
            nodeF current = head;
            int i = 0;
            while (i < index) { 
                current = current.next;
                i++;
            }
            if(current.prev == null){
                nodeF newNode = new nodeF(null, id, judul, rating, current);
                current.prev = newNode;
                head = newNode;
            } else {
                nodeF newNode = new nodeF(current.prev, id, judul, rating, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }
    
    public int size(){
        return size;
    }
    
    public void clear(){
        head = null;
        size = 0;
    }
    
    public void print(){
        if(!isEmpty()){
            nodeF tmp = head;
            while (tmp != null){
                System.out.println("ID: "+ tmp.id);
                System.out.println(" Judul Film: " + tmp.judul);
                System.out.println(" Rating Film: " + tmp.rating);
                System.out.println();
                tmp = tmp.next;
            }
            System.out.println("Sisa Film: " + size);
        } else {
            System.out.println("Linked list film kosong");
        }
    }
    
    public void removeFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked list film masih kosong, tidak dapat dihapus");
        }else if (size == 1){
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    
    public void removeLast() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked list film masih kosong, tidak dapat dihapus");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        } 
        nodeF current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }
    
    public void remove(int index) throws Exception{
        if(isEmpty() || index >= size){
            throw new Exception("Nilai indeks film diluar batas");
        } else if (index == 0){
            removeFirst();
        } else {
            nodeF current = head;
            int i =0;
            while(i < index){
                current = current.next;
                i++;
            }
            if(current.next == null){
                current.prev.next = null;
            } else if (current.prev == null){
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
        size--;
    }
    
    public void sorting(){
        nodeF current = null, index = null;
        double tmp;
        if(head == null){
            return;
        } else {
             for(current = head; current.next != null; current = current.next){
                 for(index = current.next; index != null; index = index.next) {
                     if(current.rating > index.rating) {  
                        tmp = current.rating;  
                        current.rating = index.rating;  
                        index.rating = tmp; 
                 }
             }
        }
    }
    }
    
    public void searching(String cari) {  
        int i = 0;  
        boolean flag = false;  
        nodeF current = head;  
  
        if(head == null) {  
            System.out.println("List film kosong");  
            return;  
        }  
        while(current != null) {  
            if(current.id.equalsIgnoreCase(cari)) {  
                flag = true;  
                break;  
            }  
            current = current.next;  
            i++;  
        }  
        if(flag){  
             System.out.println("ID: " + cari + " ditemukan di indeks ke-" + i);  
        }else{  
             System.out.println("Film tidak ada di list");
        }
    }  
}
```

```java
import java.util.Scanner;

public class movieMain {
    public static void menu(){
        System.out.println("====================");
        System.out.println("Data Film Layar Lebar");
        System.out.println("====================");
        System.out.println("1. Tambah Data Awal");
        System.out.println("2. Tambah Ddata Akhir");
        System.out.println("3. Tambah Data Indeks Tertentu");
        System.out.println("4. Hapus Data Pertama");
        System.out.println("5. Hapus Data Terakhir");
        System.out.println("6. Hapus Data Tertentu");
        System.out.println("7. Cetak");
        System.out.println("8. Cari ID Film");
        System.out.println("9. Urut Data Rating Film");
        System.out.println("10. Keluar");
        System.out.println("====================");
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        int pilihMenu, indeks;
        String cari;
        
        movie m = new movie();
        
        do{
            menu();
            pilihMenu = sc.nextInt();
            sc.nextLine();
            System.out.println("===================");
            try{
                switch(pilihMenu){
                    case 1: 
                        System.out.println("===============");
                        System.out.println("Masukkan ID Film: ");
                        String id = s.nextLine();
                        System.out.print("Masukkan Judul Film: ");
                        String judul = s.nextLine();
                        System.out.print("Masukkan Rating Film: ");
                        double rating = sc.nextDouble();
                        m.addFirst(id, judul, rating);
                        System.out.println("===========");
                        break;
                    case 2:
                        System.out.println("===============");
                        System.out.println("Masukkan ID Film: ");
                        id = s.nextLine();
                        System.out.print("Masukkan Judul Film: ");
                        judul = s.nextLine();
                        System.out.print("Masukkan Rating Film: ");
                        rating = sc.nextDouble();
                        m.addLast(id, judul, rating);
                        System.out.println("===========");
                        break;
                    case 3:
                        System.out.println("===============");
                        System.out.println("Masukkan indeks dimana Film dimasukkan: ");
                        indeks = sc.nextInt();
                        System.out.println("Masukkan ID Film: ");
                        id = s.nextLine();
                        System.out.print("Masukkan Judul Film: ");
                        judul = s.nextLine();
                        System.out.print("Masukkan Rating Film: ");
                        rating = sc.nextDouble();
                        m.add(id, judul, rating, indeks);
                        System.out.println("===========");
                        break;
                    case 4:
                        m.removeFirst();
                        System.out.println("Data Film Pertama telah dihapus");
                        break;
                    case 5:
                        m.removeLast();
                        System.out.println("Data Film Terakhir telah dihapus");
                        break;
                    case 6:
                        System.out.print("Masukkan indeks data Film yang ingin dihapus: ");
                        indeks = sc.nextInt();
                        m.remove(indeks);
                        break;
                    case 7:
                        m.print();
                        break;
                    case 8:
                        System.out.print("Masukkan ID Film yang ingin dicari: ");
                        cari = s.nextLine();
                        m.searching(cari);
                        break;
                    case 9: 
                        m.sorting();
                        m.print();
                        break;
                    case 10:
                        System.exit(0);
                        break;
                        
                }
            }catch(Exception E){
                
            }
        
    }while(pilihMenu <= 10 || pilihMenu >= 1);
    }
}
```

```java
public class nodeF {
    String judul, id;
    double rating;
    nodeF prev, next;
    
    nodeF(nodeF prev, String id, String judul, double rating, nodeF next){
        this.prev = prev;
        this.next = next;
        this.id = id;
        this.judul = judul;
        this.rating = rating;
    }
}
```