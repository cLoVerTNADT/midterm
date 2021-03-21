import java.util.*;

public class AdjMatrix {
    private int v;
    private int arr[][];

    public AdjMatrix(int v) {
        this.v = v;
        arr = new int[v][v];
    }

    public void addEdge(int a, int b) {
        arr[a][b] = 1;
        arr[b][a] = 1;
    }

    public int V() {
        return v;
    }

    public void printGraph() {
        //printing graph
        System.out.print("    ");
        for (int i = 0; i < v; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("   ------------");

        for (int i = 0; i < v; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < v ; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }

        //printing information about connected vertices
        System.out.println("Connected vertices: ");
        for (int i = 0; i < v; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < v ; j++) {
                if(arr[i][j] == 1){
                    System.out.print(" -> " + j);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjMatrix graph = new AdjMatrix(4);
        graph.addEdge(0, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.printGraph();
    }
}