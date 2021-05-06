package Construction_Graphs;
import java.io.*;
import java.util.*;
   
class Graph_adjacencylist {
    // The number of vertices
    private final int V;
   
    // Contains edges represented as adjacency lists
    private LinkedList<Integer>[] edges;
   
   
	// Should add an undirected edge between v1 and v2
	public void addEdge(int v1, int v2) {
        edges[v1].add(v2);
        edges[v2].add(v1);
	}

	// Should return whether v1 and v2 are neighbours
	public boolean isNeighbours(int v1, int v2) {
        for (int i = 0; i < V; i++) {
            if(edges[v1].contains(v2) || edges[v2].contains(v1)) return true;
        }
        return false;
	}

	// Should print the the neighbours separated
	// by whitespace (using System.out.print(...))
	public void printNeighbours(int v) {
        for (int i = 0; i < edges[v].size(); i++) {
            System.out.print(edges[v].get(i)+" ");
        }
	}
   
    // ##################################################
    // # You do not need to modify anything below here. #
    // ##################################################
   
    // Creates a graph with V vertices and no edges.
    public Graph_adjacencylist(int V) {
        this.V = V;
        edges = (LinkedList<Integer>[]) new LinkedList[V];
   
        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<Integer>();
        }
    }
}
   
public class Adjacencylist_Driver {
    public static void main(String[] args) throws IOException {
        new Adjacencylist_Driver().run();
    }
   
    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   
        int V = Integer.parseInt(in.readLine());
        Graph_adjacencylist graph = new Graph_adjacencylist(V);
   
        int E = Integer.parseInt(in.readLine());
   
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
   
        int Q1 = Integer.parseInt(in.readLine());
   
        for (int i = 0; i < Q1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            System.out.println(graph.isNeighbours(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) ? "YES" : "NO");
        }
   
        int Q2 = Integer.parseInt(in.readLine());
   
        for (int i = 0; i < Q2; i++) {
            graph.printNeighbours(Integer.parseInt(in.readLine()));
        }
    }
}
