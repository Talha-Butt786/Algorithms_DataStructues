package Construction_Graphs;
import java.io.*;
import java.util.*;

class GraphMatrix {
	// The number of vertices
	private final int V;

	// Contains edges represented as adjacency matrix
	private boolean[][] edges;

	// Should add an undirected edge between v1 and v2
	public void addEdge(int v1, int v2) {
		edges[v1][v2] = true;
		edges[v2][v1] = true;
	}

	// Should return whether v1 and v2 are neighbours
	public boolean isNeighbours(int v1, int v2) {
		return edges[v1][v2];
	}

	// Should print the the neighbours separated
	// by whitespace (using System.out.print(...))
	public void printNeighbours(int v) {
		for (int i = 0; i < edges[v].length; i++) {
			if(edges[v][i]) System.out.print(i+" ");
		}
	}

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

	public GraphMatrix(int V) {
		this.V = V;
		edges = new boolean[V][V];
	}
}

public class AdjacencyMatrix_Driver {
	public static void main(String[] args) throws IOException {
		new AdjacencyMatrix_Driver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(in.readLine());
		GraphMatrix graph = new GraphMatrix(V);

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
