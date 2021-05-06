package Assignments_algorithms.Graph_search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class DirectedGraph {
    // The number of vertices
    private final int V;

    // Contains edges represented as adjacency lists
    private LinkedList<Integer>[] edges;
    private LinkedList<Integer>[] recieve_nodes;


    // Adds a directed edge between v1 and v2
    public void addEdge(int v1, int v2) {
        edges[v1].add(v2);
    }

    // Runs the bfs on startnode til the last leaf in th graph
    // and adds the the nodes on each layer in to the list respresenting each layer.
    public int bfs(int start) {
        Queue<Node_borger> queue = new LinkedList<>();
        boolean [] visited = new boolean[edges.length];
        visited[start] = true;
        Node_borger node = new Node_borger();
        node.key = start;
        node.debth = 0;
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.remove();
            for (int i = 0; i < edges[node.key].size(); i++) {
                if (!visited[edges[node.key].get(i)]) {
                    visited[edges[node.key].get(i)] = true;
                    Node_borger newnode = new Node_borger();
                    newnode.key = edges[node.key].get(i);
                    newnode.debth = node.debth+1;
                    recieve_nodes[newnode.debth].add(newnode.key);
                    Collections.sort(recieve_nodes[newnode.debth]);
                    newnode.parent = node.key;
                    queue.add(newnode);
                }
            }
        }
        return 0;
    }
    public void getKædeBrev(){
        bfs(0);
        for (int i = 1; i < recieve_nodes.length; i++) {
            if(recieve_nodes[i].size()!=0) {
                System.out.println("Day " + i);
                for (int j = 0; j < recieve_nodes[i].size(); j++) {
                    System.out.println(recieve_nodes[i].get(j));
                }
            }
        }
    }

    // Creates a graph with V vertices and no edges.
    // Creates the list representing maximum layers in the graph.
    public DirectedGraph(int V) {
        this.V = V;
        edges = (LinkedList<Integer>[]) new LinkedList[V];
        recieve_nodes = (LinkedList<Integer>[]) new LinkedList[V];

        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<>();
            recieve_nodes[i] = new LinkedList<>();
        }
    }
}
class Node_borger {
    int key;
    int parent;
    int debth;
}

public class KædeBrev {
    public static void main(String[] args) throws IOException {
        new KædeBrev().run();
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        DirectedGraph graph = new DirectedGraph(n);
        int m = Integer.parseInt(in.readLine());


        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int [] line = new int[st.countTokens()];
            int j = 0;
            while (st.hasMoreTokens()) {
                line[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            for (int k = 1; k < line.length; k++) {
                graph.addEdge(line[0],line[k]);
            }
        }
        graph.getKædeBrev();
    }

}