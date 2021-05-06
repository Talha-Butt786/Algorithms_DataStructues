package Dynamic_connectivity;
import java.io.*;
import java.util.*;

// implement the data structure using weighted-union and path compression 
class PathCompression {
	int[] p;
	int[] sz;
	
	// initialize p and z
	public void init(int n) {
		//same as weighted quick union
		p = new int[n];
		sz = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
			sz[i] = 1;
		}
	}
	
	// each nodes in the path from i to root, are now children of root.
	public int find(int i) {
		// continue recursively from i to to it's parent until the current node is not the root.
		// and give each node the root of graph as parent.
		if(i!=p[i])
			p[i] = find(p[i]);  // line will update each node's parent once the return statement is executed.
		return p[i]; // line will only execute once the root is found
	}
	
	// connect the two trees containing i and j 
	public void union(int i, int j) {
		// Same as weighted union fast implementation
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

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

public class Path_CompressionDriver {
	public static void main(String[] args) throws IOException {
		new Path_CompressionDriver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		PathCompression unionFind = new PathCompression();
		
		int N = Integer.parseInt(in.readLine());
		unionFind.init(N);

		int M = Integer.parseInt(in.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			if (st.nextToken().equals("F")) {
				System.out.println(unionFind.find(Integer.parseInt(st.nextToken())));
			}
			else {
				unionFind.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
		}
	}
}
