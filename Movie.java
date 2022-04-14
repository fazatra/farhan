public class Movie {
        int id;
        String judul;
        int tahun;
        double rating;
        Movie movies[];
        int idmvs;
    
        Movie(int i, String j, int t, double r){
            id = i;
            judul = j;
            tahun = t;
            rating = r;
        }
    Movie(){

    }
        void tampil(){
            
            System.out.println("ID\t: "+id+"\nJudul\t: " +judul+"\n Tahun\t: "+tahun+"\n Rating\t: "+rating);
            System.out.println("=======================");
        }    
        void tambah(Movie t){
            if(idmvs < movies.length){
                    movies[idmvs] = t;
                    idmvs++;
            }else{
                    System.out.println("Data sudah penuh!!");
            }
            }
            
            void tampilAll(){
                for (Movie movie : movies) {
                    movie.tampil();
                    System.out.println("Daftar Movies :");
                }
            }
             
            void insertionSort(){
                for(int i=1; i < movies.length; i++){
                    Movie temp = movies[i];
                    int j = i;
                   
                    while(j > 0 && movies[j-1].rating > temp.rating){
                        movies[j] = movies[j-1];
                        j--;
                    }
                    movies[j] = temp;
                }
                
                
                }
         
        
            
             public void Tampilposisi(double x, double pos){
                if(pos != -1){
                    System.out.println("Data rating: " + x + " ditemukan pada indeks ke-" + pos);
                }else {
                    System.out.println("Data rating " + x + " tidak ditemukan");
                }
            }
        
            public void TampilData(double x, int pos){
                if(pos!= -1){
                    System.out.println("ID\t : " + movies[pos].id);
                    System.out.println("Judul\t : " + movies[pos].judul);
                    System.out.println("Tahun\t : " + movies[pos].tahun);
                    System.out.println("Ratng\t : " + x);
                }else{
                    System.out.println("Data tahun " + x + " tidak ditemukan");
                }
            }
            
             public int FindBinarySearch(double cari, int left, int right){
                int mid;
                if(right >= left){
                    mid = (left + right)/ 2;
                    if(cari == movies[mid].rating){
                        return(mid);
                    }else if(movies[mid].rating > cari){
                        return FindBinarySearch(cari, left, mid - 1);
                    } else{
                        return FindBinarySearch(cari, mid + 1, right);
                    }
                }
                return -1;
            }
        }
    
