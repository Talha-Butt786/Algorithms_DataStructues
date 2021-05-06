package Assignments_algorithms.weighted_Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dijkstra_Algo{
    LinkedList<weight_node>[] edges;
    private weight_node[] nodes;
    private int[] debth_node;
    MinHeap_data heap;
    public void addedge(int v1, int v2, int w){
        edges[v1].add(new weight_node(v2,w));
    }
    public void removeedge(int v1,int v2){
        weight_node [] v_1 = new weight_node[edges[v1].size()];
        weight_node [] v_2 = new weight_node[edges[v2].size()];
        edges[v1].toArray(v_1);
        edges[v2].toArray(v_2);
        int v1_remove = BinærSøg(v_1,0,edges[v1].size()-1,v2);
        int v2_remove = BinærSøg(v_2,0,edges[v2].size()-1,v1);
        if(v1_remove != -1 ) edges[v1].remove(v1_remove);
        if(v2_remove!=-1) edges[v2].remove(v2_remove);
    }
    public int BinærSøg(weight_node [] A, int i, int j, int x){
        if(i>j) return -1;
        int m = (i+j)/2;
        if(A[m].node_id==x) return m;
        if(A[m].node_id>x) return BinærSøg(A,i,m-1,x);
        if(A[m].node_id< x) return BinærSøg(A,m+1,j,x);
        return -1;
    }

    public void Dijkstra_Alg(){
        for (int i = 0; i < nodes.length; i++) {
            weight_node node = nodes[i];
            node.debth = Integer.MAX_VALUE;
            node.parent = Integer.MAX_VALUE;
            heap.insert(node);
        }
        weight_node node = nodes[0];
        heap.decrease_key(node,0,debth_node);
        while(heap.size!=0){
            weight_node u = heap.extractMin();
            for (int i = 0; i < edges[u.node_id].size(); i++) {
                weight_node c_u = nodes[u.node_id];
                weight_node c_v = nodes[edges[u.node_id].get(i).node_id];
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
    public void relax(weight_node u,weight_node v,int i){
        if(v.debth>u.debth+getweight(u.node_id,i)){
            v.debth = u.debth+getweight(u.node_id,i);
            heap.decrease_key(v,v.debth,debth_node);
        }
    }
    public int getweight(int u, int v){
        return edges[u].get(v).weight;
    }

    public int computeDistances(int x1, int y1, int x2, int y2){
        int result = (int)Math.sqrt((Math.pow(x1-x2,2))+(Math.pow(y1-y2,2)));
        return result;
    }

    public Dijkstra_Algo(int V){
        heap = new MinHeap_data(V);
        nodes = new weight_node[V];
        debth_node = new int[V];
        edges = (LinkedList<weight_node>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<weight_node>();
        }
        for (int i = 0; i < V; i++) {
            weight_node node = new weight_node(i,0);
            nodes[i] = node;
        }
    }
}
class MinHeap_data{
    private weight_node[] elements;
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
    public void insert(weight_node e) {
        size = size+1;
        elements[size] = e;
        bubbleUp(size);
    }
    public void bubbleUp(int x) {
        if(x!=1) {
            if (elements[parent(x)].debth > elements[x].debth) {
                weight_node temp = elements[x];
                elements[x] = elements[parent(x)];
                elements[parent(x)] = temp;
                map.put(elements[x].node_id,x);
                map.put(elements[parent(x)].node_id,parent(x));
                bubbleUp(parent(x));
            }
        }
    }
    public void decrease_key(weight_node x,int k,int [] debthnode){
        int i = map.get(x.node_id);
        if(elements[i]==null) debthnode[x.node_id] = k;
        else {
            elements[i].debth = k;
            bubbleUp(i);
        }
    }
    public weight_node extractMin() {
        weight_node max = elements[1];
        elements[1] = elements[size];
        map.put(elements[1].node_id,1);
        elements[size]=null;
        size--;
        bubbleDown(1);
        return max;
    }
    public void bubbleDown(int x) {
        if (leftchild(x) < size) {
            if (elements[leftchild(x)] != null) {
                if (elements[leftchild(x)].debth < elements[x].debth || elements[rightchild(x)].debth < elements[x].debth) {
                    int child;
                    if (elements[rightchild(x)] == null) child = leftchild(x);
                    else {
                        if (elements[leftchild(x)].debth < elements[rightchild(x)].debth) child = leftchild(x);
                        else child = rightchild(x);
                    }
                    weight_node temp = elements[x];
                    elements[x] = elements[child];
                    elements[child] = temp;
                    map.put(elements[x].node_id, x);
                    map.put(elements[child].node_id, child);
                    bubbleDown(child);
                }
            }
        }
    }
    public MinHeap_data(int V){
        elements = new weight_node[V+1];
        map = new HashMap<>();
        for (int i = 0; i < V; i++) {
            map.put(i,i+1);
        }
    }
}
class weight_node implements Comparable<weight_node>{
    int node_id;
    int weight;
    int parent;
    int debth;
    public weight_node(int node_id,int weight){
        this.node_id = node_id;
        this.weight = weight;
    }

    @Override
    public int compareTo(weight_node o) {
        return Integer.compare(this.node_id,o.node_id);
    }
}
class Coordinates{
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Locations{
    int i;
    int j;

    public Locations(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class Pakkelevering_DroverDriver {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        ArrayList<Locations> locations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int [] line = new int[st.countTokens()];
            int j = 0;
            while (st.hasMoreTokens()) {
                line[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            if(line!=null) {
                coordinates.add(new Coordinates(line[0],line[1]));
            };
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int [] line = new int[st.countTokens()];
            int j = 0;
            while (st.hasMoreTokens()) {
                line[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            if(line!=null) {
                locations.add(new Locations(line[0],line[1]));
            };
        }

        Dijkstra_Algo dijkstra = new Dijkstra_Algo(n);
        for (int i = 0; i < coordinates.size(); i++) {
            // handle coordinates, connect ecah with each other
            Coordinates coordinates1 = new Coordinates(coordinates.get(i).x,coordinates.get(i).y);
            for (int j = 0; j < coordinates.size(); j++) {
                if(i!=j){
                    int weight = dijkstra.computeDistances(coordinates1.x,coordinates1.y,coordinates.get(j).x,coordinates.get(j).y);
                    dijkstra.addedge(i,j,weight);
                }
            }
        }
        for (int i = 0; i < locations.size(); i++) {
            dijkstra.removeedge(locations.get(i).i,locations.get(i).j);
        }
        dijkstra.Dijkstra_Alg();
        dijkstra.print_debths();
    }
}
