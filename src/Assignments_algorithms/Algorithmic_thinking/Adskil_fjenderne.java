package Assignments_algorithms.Algorithmic_thinking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class UndirectedGraph {
    // The number of vertices
    private final int V;

    // Contains edges represented as adjacency lists
    private LinkedList<Integer>[] edges;
    private Node_medarbejder [] visited;
    private List<Integer> odd;
    private List<Integer> even;

    // Adds an undirected edge between v1 and v2
    public void addEdge(int v1, int v2) {
        edges[v1].add(v2);
        edges[v2].add(v1);
    }

    // Runs BFS on given node til completing whole connected graph
    // Checks if the graph is bipartite
    public boolean bfs(int start) {
        // Implement this
        Queue <Node_medarbejder> queue = new LinkedList<>();
        Node_medarbejder node = new Node_medarbejder();
        node.key = start;
            node.debth = 0;
            visited[node.key] = node;
            even.add(node.key);
            queue.add(node);
            while (!queue.isEmpty()) {
                node = queue.remove();
                for (int i = 0; i < edges[node.key].size(); i++) {
                    if (visited[edges[node.key].get(i)] == null) {
                        Node_medarbejder newnode = new Node_medarbejder();
                        newnode.key = edges[node.key].get(i);
                        newnode.debth = node.debth + 1;
                        newnode.parent = node.key;
                        visited[edges[node.key].get(i)] = newnode;
                        if (newnode.debth % 2 == 0)
                            even.add(newnode.key);
                        else
                            odd.add(newnode.key);
                        queue.add(newnode);
                    } else if (visited[edges[node.key].get(i)].debth == node.debth)
                        return false;
                }
        }
        return true;
    }

    public void gettwosets(int n,int m){
            boolean isbipartit = true;
            if(m!=0) {
                for (int i = 0; i < n; i++) {
                    if (visited[i] == null) {
                        if (!bfs(i)) {
                            isbipartit = false;
                            break;
                        }
                    }
                }
                if (isbipartit) {
                    Collections.sort(even);
                    Collections.sort(odd);
                    for (int i = 0; i < even.size(); i++) {
                        System.out.print(even.get(i) + " ");
                    }
                    System.out.print("\n");
                    for (int i = 0; i < odd.size(); i++) {
                        System.out.print(odd.get(i) + " ");
                    }
                } else
                    System.out.println("NO");
            }else {
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0)
                        even.add(i);
                    else
                        odd.add(i);
                }
                for (int i = 0; i < even.size(); i++) {
                    System.out.print(even.get(i) + " ");
                }
                System.out.print("\n");
                for (int i = 0; i < odd.size(); i++) {
                    System.out.print(odd.get(i) + " ");
                }
            }
    }

    // ##################################################
    // # You do not need to modify anything below here. #
    // ##################################################

    // Creates a graph with V vertices and no edges.
    public UndirectedGraph(int V) {
        this.V = V;
        edges = (LinkedList<Integer>[]) new LinkedList[V];
        visited = new Node_medarbejder[V];
        even = new ArrayList<>();
        odd = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<Integer>();
        }
    }
}
class Node_medarbejder {
    int key;
    int parent;
    int debth;
}
public class Adskil_fjenderne {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        UndirectedGraph graph = new UndirectedGraph(n);

        int m = Integer.parseInt(in.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        graph.gettwosets(n,m);
    }
}
