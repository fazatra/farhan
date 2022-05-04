# Nama        = Muhammad farhan Riza Putra
# Kelas/absen = TI - 1F / 21

## Pertemuan 10

## 3.Tugas

# 1

```java
public class Node {
    int data;
    Node next;
    
    public Node(int nilai,Node berikutnya){
    
    this.data  = nilai ;
    this.next = berikutnya ;
    }
}
```

```java
public class SingleLinkedList {

    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            System.out.print("Isi Linked List :\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void addFirst(int input) {
        Node ndInput = new Node(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(int input) {
        Node ndInput = new Node(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(int key, int input) {
        Node ndInput = new Node(input, null);
        Node temp = head;
        do {
            if (temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertBefore(int key, int input) {
        Node ndInput = new Node(input, null);
        Node temp = head;
        while (temp != null) {
            if ((temp.data == key) && (temp == head)) {
                this.addFirst(input);
                System.out.println("Berhasil Menambahkan Data");        
                break;
            } else if (temp.next.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                System.out.println("Berhasil Menambahkan Data.");
                break;
            }
            temp = temp.next;
        }
    }

    public void insertAt(int index, int input) {
        if (index < 0) {
            System.out.println("Indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }

    public int getData(int index) {
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int indexOf(int key) {
        Node tmp = head;
        int index = 0;
        while (tmp != null && tmp.data != key) {
            tmp = tmp.next;
            index++;
        }
        if (tmp == null) {
            return -1;
        } else {
            return index;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked List masih Kosong, tidak dapat dihapus!");
        } else {
            Node temp = head;
            while (temp != null) {
                if ((temp.data == key) && (temp == head)) {
                    this.removeFirst();
                    break;
                } else if (temp.next.data == key) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
}
```

```java
public class SLLMain {

    public static void main(String[] args) {
        SingleLinkedList singLL = new SingleLinkedList();

        singLL.print();;
        singLL.addFirst(890);
        singLL.print();
        singLL.addLast(760);
        singLL.print();
        singLL.addFirst(700);
        singLL.print();
        singLL.insertAfter(700, 999);
        singLL.print();
        singLL.insertAt(3, 833);
        singLL.print();
        singLL.insertBefore(760, 50);
        singLL.print();

        System.out.println("Data pada indeks ke-1 = " + singLL.getData(1));
        System.out.println("Data 3 berada pada index ke- " + singLL.indexOf(760));

        singLL.remove(999);
        singLL.print();
        singLL.removeAt(0);
        singLL.print();
        singLL.removeFirst();
        singLL.print();
        singLL.removeLast();
        singLL.print();
    }
}
```
# 2

```java
public class Node {

    char data;
    Node next;

    public Node(char nilai, Node berikutnya) {
        this.data = nilai;
        this.next = berikutnya;
    }
}
```

```java
public class SingleLinkedList {

    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            System.out.print("Isi Linked List :\t");
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void addFirst(char input) {
        Node ndInput = new Node(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(char input) {
        Node ndInput = new Node(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(char key, char input) {
        Node ndInput = new Node(input, null);
        Node temp = head;
        do {
            if (temp.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, char input) {
        if (index < 0) {
            System.out.println("Indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }

    public void insertBefore(char key, char input) {
        Node ndInput = new Node(input, null);
        Node temp = head;
        while (temp != null) {
            if ((temp.data == key) && (temp == head)) {
                this.addFirst(input);
                break;
            } else if (temp.next.data == key) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                break;
            }
            temp = temp.next;
        }
    }
}
```

```java
public class SLLMain {

    public static void main(String[] args) {
        SingleLinkedList SLL = new SingleLinkedList();

        SLL.addFirst('a');
        SLL.print();
        SLL.addLast('e');
        SLL.print();
        SLL.insertAfter('a', 'c');
        SLL.print();
        SLL.insertBefore('e', 'd');
        SLL.print();
        SLL.insertAt(1, 'b');
        SLL.print();
    }
}
```

# 3

```java
public class Node {

    String data;
    Node next;

    public Node(String data, _Node berikutnya) {
        this.data = data;
        this.next = berikutnya;
    }
}
```

```java
public class SingleLinkedList {

    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            System.out.println("");
            while (tmp != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
            System.out.println();
        } else {
            System.out.println("Stack Masih Kosong");
        }
    }

    public void peek() {
        if (!isEmpty()) {
            Node tmp = head;

            System.out.println("Isi Stack Teratas = " + tmp.data);

        } else {
            System.out.println("Stack Masih Kosong");
        }
    }

    public void pushFirst(String input) {
        Node ndInput = new Node(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }
}
```

```java
public class MainNode {

    public static void main(String[] args) {
        SingleLinkedList singLL = new SingleLinkedList();
        singLL.pushFirst("Bahasa");
        singLL.print();
        singLL.pushFirst("Android");
        singLL.print();
        singLL.pushFirst("Komputer");
        singLL.print();
        singLL.pushFirst("Basis Data");
        singLL.print();
        singLL.pushFirst("Matematika");
        singLL.print();
        singLL.pushFirst("Algoritma");
        singLL.print();
        singLL.pushFirst("Statistika");
        singLL.print();
        singLL.pushFirst("Multimedia");

        System.out.println("Isi stack : ");
        singLL.print();
        singLL.peek();
    }
}
```

# 4

```java
public class MahasiswaSLL {
    Mahasiswa head;
    Mahasiswa tail;
    
        
    public boolean isEmpty(){
        return head == null;
    }

    public void print(){
        if(!isEmpty()){
            Mahasiswa temp = head;
            int i = 0;
            System.out.print("Isi Mahasiswa:\t");
            while (temp != null){
                System.out.println("Data Mahasiswa ke-" + i + "= " + temp.nim + " " + temp.nama + " " + temp.absen
                + " " + temp.ipk);
                temp = temp.next;
                i++;
            }
            System.out.println("");
        } else {
            System.out.println("Queue kosong");
        }
    }

    public void peek(){
        if(!isEmpty()){
            Mahasiswa temp = head;
            System.out.println("Data mahasiswa terdepan= " + temp.nim + " " + temp.nama + " " + temp.absen
                + " " + temp.ipk);
        } else {
            System.out.println("Queue kosong");
        }
    }
    
    public void peekRear(){
        if(!isEmpty()){
            Mahasiswa temp = head;
            while(temp != null){
                if(temp == tail){
                    System.out.println("Antrian paling belakang = " + temp.nim + " " + temp.nama + " " + temp.absen
                + " " + temp.ipk);
                }else {
                    System.out.println("Queue kosong");
                }
                temp = temp.next;
            }
        }
    }
    
    public void peekIndex(int index){
        Mahasiswa temp = head;
        for (int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
        System.out.println("Data mahasiswa pada indeks ke-" + index + "= " + temp.nim + " " + temp.nama + " " + temp.absen
                + " " + temp.ipk);
    }
    
    public int peekData(int key){
        Mahasiswa temp = head;
        int index = 0;
        while (temp != null && temp.absen != key){
            temp = temp.next;
            index++;
        }
        if(temp == null){
            System.out.println("Queue kosong");
            return -1;
        } else {
            System.out.println("Data mahasiswa " + key + "berada pada index ke-" + index);
            System.out.println("Data mahasiswa " + temp.nim + " " + temp.nama + " " + temp.absen
                + " " + temp.ipk);
            return index;
        }
    }

    
    public void enqueue(String nim, String nama, int absen, double ipk){
        Mahasiswa temp = new Mahasiswa(nim, nama, absen, ipk, null);
        if(isEmpty()){ 
            head = temp; 
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }
    
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue, tidak dapat dihapus");
        } else if (head == tail){
            head = tail = null;
        } else {
            head = head.next;
        }
    }
    
    public void clear(int data){
        if(!isEmpty()){
            head = tail = null;
            data = 0;
            System.out.println("Data mahasiswa dikosongkan");
        } else {
            System.out.println("Queue Kosong");
        }
    }
    
    
}
```

```java
public class Mahasiswa {
    String nim;
    String nama;
    int absen;
    double ipk;
    Mahasiswa next;
    
    public Mahasiswa(String nim, String nama, int absen, double ipk, Mahasiswa lanjut){
        this.nim = nim;
        this.nama = nama;
        this.absen = absen;
        this.ipk = ipk;
        this.next = lanjut;
    }    
}
```

```java
import java.util.Scanner;

public class MahasiswaMain {
    public static void menu(){
        System.out.println("Pilih menu: ");
        System.out.println("1. Data Mahasiswa baru");
        System.out.println("2. Data Mahasiswa keluar");
        System.out.println("3. Cek data mahasiswa terdepan");
        System.out.println("4. Cek data mahasiswa paling belakang");
        System.out.println("5. Cek semua antrian");
        System.out.println("6. Cari penempatan mahasiswa berdasar absen");
        System.out.println("7. Cari mahasiswa dengan indeks");
        System.out.println("8. Clear data");
        System.out.println("==============");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        
        System.out.print("Masukkan kapasitas Queue: ");
        int jumlah = sc.nextInt();
        
        MahasiswaSLL antri = new MahasiswaSLL();
        
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
                    antri.enqueue(nim, nama, absen, ipk);
                    break;
                
                case 2:
                    antri.dequeue();
                    break;
                
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
                    System.out.print("Masukkan absen mahasiswa: ");
                    int absene = s.nextInt();
                    antri.peekData(absene);
                    break;
                    
                case 7:
                    System.out.print("Masukkan indeks yang dicari: ");
                    int indeks = s.nextInt();
                    antri.peekIndex(indeks);
                    break;
                 
                case 8: 
                    antri.clear(jumlah);
                    break;
            }
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7 || pilih == 8);
    }
}
```