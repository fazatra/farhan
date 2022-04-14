import java.util.Scanner;

public class MainMovie {

    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
            Scanner sl = new Scanner(System.in);
            Movie data = new Movie();

                System.out.print("Masukkan jumlah movie: ");
                int jmlM = s.nextInt();
                Movie[] movie = new Movie[jmlM];
                data.movies = movie;
                
                System.out.println("\n----------------------------------------");
                System.out.println("Masukkan data Movie ");
                for(int i=0; i < jmlM; i++){
                    int id = i + 1;
                    System.out.println("===================");
                    System.out.println("Data Movie ke-"+id);
                    System.out.print("Judul\t: ");
                    String judul = sl.nextLine();
                    System.out.print("Tahun\t: ");
                    int tahun = s.nextInt();
                    System.out.print("Rating\t: ");
                    double rating = s.nextDouble();
                    
                    Movie p = new Movie(id, judul, tahun, rating);
                    data.tambah(p);
                }
                   
                System.out.println("\nDATA Awal");
                data.tampilAll();

                System.out.println("----------------------------------------");
                System.out.println("\nPENGURUTAN DATA BERDASARKAN rating");
                data.insertionSort();
                data.tampilAll();

                System.out.println("\nPENCARIAN DATA BERDASARKAN rating");
                System.out.println("Cari Rating: "); 
                int cari = sl.nextInt(); 
                
                int posisi = data.FindBinarySearch(cari, 0, jmlM - 1);
                data.Tampilposisi(cari, posisi);
                data.TampilData(cari, posisi);
            }
        }
    
