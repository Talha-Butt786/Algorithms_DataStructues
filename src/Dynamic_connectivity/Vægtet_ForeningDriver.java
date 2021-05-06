package Dynamic_connectivity;
import java.io.*;
import java.util.*;

// implement the data structure using weighted-union 
class VægtetForening {
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
	
	// connect the two trees containing i and j , with reference two the smallest in size merges with bigger in size
	public void union(int i, int j) {
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

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

public class Vægtet_ForeningDriver {
	public static void main(String[] args) throws IOException {
		new Vægtet_ForeningDriver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		VægtetForening unionFind = new VægtetForening();
		
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
