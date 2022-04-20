# Nama        = Muhammad farhan Riza Putra
# Kelas/absen = TI - 1F / 21

## Pertemuan 9

## 7.4 Tugas 

# 1. 
Perhatikan dan gunakan kembali kode program pada Praktikum 1. Tambahkan method getMin pada class Stack yang digunakan untuk mencari dan menampilkan data pakaian dengan harga terendah dari semua data pakaian yang tersimpan di dalam stack!

```java
import java.util.Scanner;

public class PakaianTgs{
    String jenis, warna, merk, ukuran;
    double harga;

    PakaianTgs(String jenis, String warna, String merk, String ukuran, double harga){
        this.jenis = jenis;
        this.warna = warna;
        this.merk = merk;
        this.ukuran = ukuran;
        this.harga = harga;
    }
}
class Stack {
    int size;
    int top;
    PakaianTgs data[];

    public Stack(int size){
        this.size = size;
        data = new PakaianTgs[size];
        top = -1;
    }

    public boolean IsEmpty(){
        if (top == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean IsFull(){
        if (top == size-1){
            return true;
        }else{
            return false;
        }
    }

    public void push(PakaianTgs pkn){
        if ( !IsFull()){
            top++;
            data[top] = pkn;
        }else{
            System.out.println("Isi stack penuh!");
        }
    }

    public void pop(){
        if (!IsEmpty()){
            PakaianTgs x = data[top];
            top--;
            System.out.println("Data yang keluar: " + x.jenis + " "+ x.warna + " " +
            x.merk + " " + x.ukuran + " " + x.harga);
        }else{
            System.out.println("Stack masih kosong");
        }
    }

    public void peek(){
        System.out.println("Elemen teratas: "+ data[top].jenis + " " + data[top].warna + " " +
        data[top].merk + " " + data[top].ukuran + " " + data[top].harga);
    }

    public void print(){
        System.out.println("Isi stack: ");
        for(int i=top; i>=0; i--){
            System.out.println(data[i].jenis + " " + data[i].warna + " " + data[i].merk + " " +
            data[i].ukuran + " " + data[i].harga + " ");
        }
        System.out.println("");
    }

    public void clear(){
        if(!IsEmpty()){
            for (int i=top; i>=0; i++){
                top--;
            }
            System.out.println("Stack sudah dikosongkan");
        }else{
            System.out.println("Stack masih kosong");
        }
    }

    public void getMin() {
        if (!IsEmpty()) {
            int idxMin = 0;
            for (int i = 0; i <= top; i++) {
                if (data[i].harga < idxMin) {
                    idxMin = i;
                }
            }
            System.out.println("Harga pakaian termurah: " + data[idxMin].jenis + " " + data[idxMin].warna + " " +
            data[idxMin].merk + " " + data[idxMin].ukuran + " " + data[idxMin].harga);
        } else {
            System.out.println("Stack masih kosong");
        }
    }
}

class StackMainTgs{
    public static void main(String[] args) {
        Stack stk = new Stack(5);
        Scanner sc = new Scanner(System.in);

        char pilih;
        do{
            System.out.print("Jenis: ");
            String jenis = sc.nextLine();
            System.out.print("Warna: ");
            String warna = sc.nextLine();
            System.out.print("Merk: ");
            String merk = sc.nextLine();
            System.out.print("Ukuran: ");
            String ukuran = sc.nextLine();
            System.out.print("Harga: ");
            double harga = sc.nextDouble();

            PakaianTgs p = new PakaianTgs(jenis, warna, merk, ukuran, harga);
            System.out.print("Apakah Anda akan menambahkan data baru (y/n)? ");
            pilih = sc.next().charAt(0);
            sc.nextLine();
            stk.push(p);
        }while(pilih == 'y' || pilih == 'Y');
    
        stk.print();
        stk.pop();
        stk.peek();
        stk.print();
        stk.getMin();
    }
}
```

# 2. 
Setiap hari Minggu, Dewi pergi berbelanja ke salah satu supermarket yang berada di area rumahnya. Setiap kali selesai berbelanja, Dewi menyimpan struk belanjaannya di dalam laci. Setelah dua bulan, ternyata Dewi sudah mempunyai delapan struk belanja. Dewi berencana mengambil lima struk belanja untuk ditukarkan dengan voucher belanja. Buat sebuah program stack untuk menyimpan data struk belanja Dewi, kemudian lakukan juga proses pengambilan data struk belanja sesuai dengan jumlah struk yang akan ditukarkan dengan voucher. Informasi yang tersimpan pada struk belanja terdiri dari:  
 Nomor transaksi 
 Tanggal pembelian 
 Jumlah barang yang dibeli 
 Total harga bayar 
Tampilkan informasi struk belanja yang masih tersimpan di dalam stack!

```java
import java.util.Date;
import java.text.SimpleDateFormat;

public class DewiTgs {
    int top, size, jmlBrg, totalHrg;
    String noTrans, waktu;
    DewiTgs[] stack;

    public DewiTgs(String noTrans, int jmlBrg, int totalHrg, String waktu){
        this.noTrans = noTrans;
        this.jmlBrg = jmlBrg;
        this.totalHrg = totalHrg;
        this.waktu = waktu;
    }

    public DewiTgs(int size){
        this.size = size;
        this.top =-1;
        stack = new DewiTgs[this.size];
    }

    public boolean IsEmpty(){
        if(top <= -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean IsFull(){
        if(top >= size-1){
            return true;
        }else{
            return false;
        }
    }

    public void push(DewiTgs stk){
        if(!IsFull()){
            top++;
            stack[top] = stk;
        }else{
            System.out.println("Data sudah full!");
        }
    }

    public void pop(){
        if(!IsEmpty()){
            DewiTgs st = stack[top];
            top--;
            line(50);
            System.out.printf("Nomor Transaksi: %-10s\n", st.noTrans);
            System.out.printf("Tanggal: %-20s\n", st.waktu);
            line(50);
            System.out.printf("Jumlah Barang: %-6d\n", st.jmlBrg);
            System.out.printf("Total: Rp. %d\n", st.totalHrg);
            line(50);
        }
    }
    
    public void line (int pjg){
        for(int i=0; i<pjg; i++){
            System.out.print("=");
        }
        System.out.println();
    }
    
    public void print(){
        line(50);
        System.out.println("\t\t   ISI STACK                   ");
        line(50);
        for(int i=top; i>=0; i--){
            line(50);
            System.out.printf("Nomor Transaksi: %-10s\n", stack[i].noTrans);
            System.out.printf("Tanggal: %-20s\n", stack[i].waktu);
            line(50);
            System.out.printf("Jumlah Barang: %-6d\n", stack[i].jmlBrg);
            System.out.printf("Total: Rp. %d\n", stack[i].totalHrg);
            line(50);
        }
        System.out.println();
    }
}

class DewiTgsMain{
    public static void main(String[] args) {
        Date waktu = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE,dd MMMM YYYY");
        
        DewiTgs struk = new DewiTgs(8);
        DewiTgs[] DewiTgs = new DewiTgs[8];
        String date = sdf.format(waktu);
        
        DewiTgs[0] = new DewiTgs("AIRJOR-321", 11, 1000000, date);
        DewiTgs[1] = new DewiTgs("AIRJOR-123", 5, 1100000, date);
        DewiTgs[2] = new DewiTgs("AIRJOR-524", 10, 3400000, date);
        DewiTgs[3] = new DewiTgs("AIRJOR-941", 9, 1200000, date);
        DewiTgs[4] = new DewiTgs("AIRJOR-011", 3, 2000000, date);
        DewiTgs[5] = new DewiTgs("AIRJOR-934", 8, 900000, date);
        DewiTgs[6] = new DewiTgs("AIRJOR-210", 6, 3200000, date);
        DewiTgs[7] = new DewiTgs("AIRJOR-001", 7, 5000000, date);
        
        for (int i = 0; i < struk.size; i++) {
            struk.push(DewiTgs[i]);
        }
        struk.print();
        struk.line(50);
        System.out.println("\tData yang di-pop |struk 5 minggu|");
        struk.line(50);
        for (int i = 0; i < 5; i++) {
            struk.pop();
        }
        struk.print();
    }
}
```