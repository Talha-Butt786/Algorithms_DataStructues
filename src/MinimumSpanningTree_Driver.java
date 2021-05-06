import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MST{
    private LinkedList<edge>[] edges;
    private ArrayList<edge> edgelist;
    private ArrayList<edge> mst;

    public void addedge(int v1, int v2, int w){
        edgelist.add(new edge(v1,v2,w));
    }

    public void sort_edges(){
        Collections.sort(edgelist);
    }

    public void kruskal(int V){
        sort_edges();
        hurig_vægtforening forening = new hurig_vægtforening();
        forening.init(V);
        int weight = 0;
        for (edge e:edgelist) {
            if(!forening.isConnected(e.key1,e.key2)) {
                forening.insert(e.key1, e.key2);
                weight = weight +e.weight;
                //mst.add(e); add's edges of MST
            }
        }
        System.out.println(weight);
    }

    public MST(int V, int E){
        edges = (LinkedList<edge>[]) new LinkedList[V];
        edgelist = new ArrayList<>();
        mst = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            edges[i] = new LinkedList<edge>();
        }
    }
}

class hurig_vægtforening{
    int[] p;
    int[] sz;

    // initialize p and z
    public void init(int n) {
        // implement this
        p = new int[n];
        sz = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            sz[i] = 1;
        }
    }

    // return the root of the tree containing i
    public int find(int i) {
        // return parent node
        if(i==p[i]) return i;
        return find(p[i]); // recursively travel each parent node until parent is the root
    }

    public boolean isConnected(int v1,int v2){
        return find(v1)==find(v2);
    }

    // connect the two trees containing i and j , with reference two the smallest in size merges with bigger in size
    public void insert(int i, int j) {
        // implement this
        int root_i = find(i);
        int root_j = find(j);
        if(root_i!=root_j){
            if(sz[root_i]<sz[root_j]){
                p[root_i] = root_j;
                sz[root_j] = sz[root_i]+sz[root_j];
            }else {
                p[root_j] = root_i;
                sz[root_i] = sz[root_i]+sz[root_j];
            }
        }
    }
}
class edge implements Comparable<edge>{
    int key1;
    int key2;
    int weight;
    public edge(int key1,int key2,int weight){
        this.key1=key1;
        this.key2=key2;
        this.weight=weight;
    }

    public String toString(){
        return "edge--> "+"("+key1+","+key2+")" + "weight: "+weight;
    }

    @Override
    public int compareTo(edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
public class MinimumSpanningTree_Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(in.readLine());
        int E = Integer.parseInt(in.readLine());
        MST mst1 = new MST(V,E);
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int [] line = new int[st.countTokens()];
            int j = 0;
            while (st.hasMoreTokens()) {
                line[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            if(line!=null) mst1.addedge(line[0],line[1],line[2]);
        }
        mst1.kruskal(V);
    }
}
