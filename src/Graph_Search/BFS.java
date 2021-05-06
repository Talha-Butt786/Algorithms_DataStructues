package Graph_Search;
import java.io.*;
import java.util.*;
   
class Graph {
	// The number of vertices
	private final int V;
   
	// Contains edges represented as adjacency lists
	private LinkedList<Integer>[] edges;
   
	// Adds a directed edge between v1 and v2
	public void addEdge(int v1, int v2) {
		edges[v1].add(v2);
	}

	// Should return the length of the shortest path between
	// the start and the end node in the graph.
	public int bfs(int start, int end) {
		// Implement this
		Queue <Node> queue = new LinkedList<>();
		boolean [] visited = new boolean[edges.length];
		visited[start] = true;
		Node node = new Node();
		node.key = start;
		node.debth = 0;
		queue.add(node);
		while (!queue.isEmpty()){
			node = queue.remove();
			if (node.key!=end) {
				for (int i = 0; i < edges[node.key].size(); i++) {
					if (!visited[edges[node.key].get(i)]) {
						visited[edges[node.key].get(i)] = true;
						Node newnode = new Node();
						newnode.key = edges[node.key].get(i);
						newnode.debth = node.debth+1;
						newnode.parent = node.key;
						queue.add(newnode);
					}
				}
			}else
				return node.debth;
		}
		return 0;
	}
   
	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################
	
	// Creates a graph with V vertices and no edges.
	public Graph(int V) {
		this.V = V;
		edges = (LinkedList<Integer>[]) new LinkedList[V];
		
		for (int i = 0; i < V; i++) {
			edges[i] = new LinkedList<Integer>();
		}
	}
}
class Node {
	int key;
	int parent;
	int debth;
}
   
public class BFS {
	public static void main(String[] args) throws IOException {
		new BFS().run();
	}
   
	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   
		int V = Integer.parseInt(in.readLine());
		Graph graph = new Graph(V);
   
		int E = Integer.parseInt(in.readLine());
   
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		System.out.println(graph.bfs(0,1));
	}
}
