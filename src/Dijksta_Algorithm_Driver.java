import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Dijkstra{
    private LinkedList<weighted_node>[] edges;
    private weighted_node[] nodes;
    private int[] debth_node;
    MinHeap heap;
    public void addedge(int v1, int v2, int w){
        edges[v1].add(new weighted_node(v2,w));
        edges[v2].add(new weighted_node(v1,w));
    }

    public void Dijkstra_Alg(){
        for (int i = 0; i < nodes.length; i++) {
            weighted_node node = nodes[i];
            node.debth = Integer.MAX_VALUE;
            node.parent = Integer.MAX_VALUE;
            heap.insert(node);
        }
        weighted_node node = nodes[0];
        heap.decrease_key(node,0);
        while(heap.size!=0){
            weighted_node u = heap.extractMin();
            for (int i = 0; i < edges[u.node_id].size(); i++) {
                weighted_node c_u = nodes[u.node_id];
                weighted_node c_v = nodes[edges[u.node_id].get(i).node_id];
                relax(c_u,c_v,i);
            }
            debth_node[u.node_id] = u.debth;
        }
    }
    public void print_debths(){
        for (int node:debth_node) {
            System.out.println(node);
        }
    }
    public void relax(weighted_node u,weighted_node v,int i){
        if(v.debth>u.debth+getweight(u.node_id,i)){
            v.debth = u.debth+getweight(u.node_id,i);
            heap.decrease_key(v,v.debth);
        }
    }
    public int getweight(int u, int v){
        return edges[u].get(v).weight;
    }

    public Dijkstra(int V,int E){
        heap = new MinHeap(V);
        nodes = new weighted_node[V];
        debth_node = new int[V];
        edges = (LinkedList<weighted_node>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<weighted_node>();
        }
        for (int i = 0; i < V; i++) {
            weighted_node node = new weighted_node(i,0);
            nodes[i] = node;
        }
    }
}
class MinHeap{
    private weighted_node[] elements;
    private HashMap<Integer,Integer> map;
    int size = 0;
    private int parent(int x){
        return x/2;
    }
    private int leftchild(int x){
        return 2*x;
    }
    private int rightchild(int x){
        return 2*x+1;
    }
    public void insert(weighted_node e) {
        size = size+1;
        elements[size] = e;
        bubbleUp(size);
    }
    public void bubbleUp(int x) {
        if(x!=1) {
            if (elements[parent(x)].debth > elements[x].debth) {
                weighted_node temp = elements[x];
                elements[x] = elements[parent(x)];
                elements[parent(x)] = temp;
                map.put(elements[x].node_id,x);
                map.put(elements[parent(x)].node_id,parent(x));
                bubbleUp(parent(x));
            }
        }
    }
    public void decrease_key(weighted_node x,int k){
        int i = map.get(x.node_id);
        elements[i].debth = k;
        bubbleUp(i);

    }
    public weighted_node extractMin() {
        weighted_node max = elements[1];
        elements[1] = elements[size];
        map.put(elements[1].node_id,1);
        elements[size]=null;
        size--;
        bubbleDown(1);
        return max;
    }
    public void bubbleDown(int x) {
        if(size>1) {
            if (leftchild(x) < size) {
                if (elements[leftchild(x)] != null) {
                    if (elements[leftchild(x)].debth < elements[x].debth || elements[rightchild(x)].debth < elements[x].debth) {
                        int child;
                        if (elements[rightchild(x)] == null) child = leftchild(x);
                        else {
                            if (elements[leftchild(x)].debth < elements[rightchild(x)].debth) child = leftchild(x);
                            else child = rightchild(x);
                        }
                        weighted_node temp = elements[x];
                        elements[x] = elements[child];
                        elements[child] = temp;
                        map.put(elements[x].node_id, x);
                        map.put(elements[child].node_id, child);
                        bubbleDown(child);
                    }
                }
            }
        }
    }
    public MinHeap(int V){
        elements = new weighted_node[V+1];
        map = new HashMap<>();
        for (int i = 0; i < V; i++) {
            map.put(i,i+1);
        }
    }
}
class weighted_node{
    int node_id;
    int weight;
    int parent;
    int debth;
    public weighted_node(int node_id,int weight){
        this.node_id = node_id;
        this.weight = weight;
    }
}
public class Dijksta_Algorithm_Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(in.readLine());
        int E = Integer.parseInt(in.readLine());
        Dijkstra dijkstra = new Dijkstra(V,E);
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int [] line = new int[st.countTokens()];
            int j = 0;
            while (st.hasMoreTokens()) {
                line[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            if(line!=null) dijkstra.addedge(line[0],line[1],line[2]);
        }
        dijkstra.Dijkstra_Alg();
        dijkstra.print_debths();
    }
}
