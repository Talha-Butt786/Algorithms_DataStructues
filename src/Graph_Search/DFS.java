package Graph_Search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class AdjacencyGraph{
    private final int V;
    private int time = 0;
    // Contains edges represented as adjacency lists
    private LinkedList<Integer>[] edges;
    private boolean [] visited;

    // Adds a directed edge between v1 and v2
    public void addEdge(int v1, int v2) {
        edges[v1].add(v2);
    }

    // Should return the length of the shortest path between
    // the start and the end node in the graph.
    public void dfs(int start) {
        // Implement this
        node node = new node();
        node.key = start;
        dfsvisit(node);
    }

    public void dfsvisit(node node){
        time++;
        node.discovery = time;
        visited[node.key] = true;
        System.out.println(node.key);
        for (int i = 0; i < edges[node.key].size(); i++) {
            if(!visited[edges[node.key].get(i)]){
                node node1 = new node();
                node1.key = edges[node.key].get(i);
                dfsvisit(node1);
                node1.parent = node.key;
            }
        }
        node.finish = time++;
        System.out.println(node.key);
    }


    // Creates a graph with V vertices and no edges.
    public AdjacencyGraph(int V) {
        this.V = V;
        edges = (LinkedList<Integer>[]) new LinkedList[V];

        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<Integer>();
        }
        visited = new boolean[edges.length];
    }
}
class node{
    protected int key;
    int parent;
    int discovery;
    int finish;
}
public class DFS {
    public static void main(String[] args) throws IOException {
        new DFS().run();
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(in.readLine());
        AdjacencyGraph graph = new AdjacencyGraph(V);

        int E = Integer.parseInt(in.readLine());

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        graph.dfs(0);
    }
}
