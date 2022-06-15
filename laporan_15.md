# Nama        = Muhammad farhan Riza Putra
# Kelas/absen = TI - 1F / 21

## Pertemuan 15

# 1

```java
public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan vertex graf : ");
        int vertex = sc.nextInt();

        Graph graph = new Graph(vertex);

        System.out.print("Masukkan banyak edge : ");
        int edge = sc.nextInt();

        for (int i = 0; i < edge; i++) {
            System.out.print("Masukkan Source : ");
            int source = sc.nextInt();
            System.out.print("Masukkan Destination :");
            int des = sc.nextInt();

            graph.addEdge(source, des);

        }
        graph.printGraph();
```

# 2

```java
public boolean graphType(int source, int destination) {
        list[source].addFirst(destination);
        return true;
}
```

# 3

```java
public void removeEdge(int source, int destination) throws Exception {
        for (int i = 0; i < vertex; i++) {
            if (i == destination) {
                list[source].remove(source);

            }
        }
    }
```

# 4

```java
 public void printGraph() throws Exception {
        String namKota = "";
        for (int i = 0; i < vertex; i++) {
            if (list[i].size() > 0) {
                if (i == 0) {
                    namKota = "Gresik";
                } else if (i == 1) {
                    namKota = "Yogya";
                } else if (i == 2) {
                    namKota = "Bandung";
                } else if (i == 3) {
                    namKota = "Malang";
                } else if (i == 4) {
                    namKota = "Surabaya";
                } else {
                    namKota = "Sidoarjo";
                }
                System.out.print("Vertex " + namKota + " terhubung dengan: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println("");
            }
        }
    }
```

