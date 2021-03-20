import java.util.*;

public class AdjList {
    int v;
    LinkedList<Integer>[] adj;

    public AdjList(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return  adj[v];
    }

    public int V() { return v; }

    public void getEdges() {
        for (int v = 0; v < V(); v++) {
            for (int w : adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
    }

    public void getBag() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " --> ");
            for (int w : adj(i)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjList graph = new AdjList(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(0, 5);
        graph.addEdge(5, 3);
        graph.addEdge(3, 4);
        graph.addEdge(6, 4);
        System.out.println("Edges:");
        graph.getEdges();
        System.out.println();
        graph.getBag();
    }
}
