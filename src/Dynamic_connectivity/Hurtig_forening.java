package Dynamic_connectivity;
import java.io.*;
import java.util.*;


// implement the fast-union data structure
class Quick_Union {
	int[] p;
	
	// initialize p to represent n trees of 1 element
	public void init(int n) {
		// implement this
		p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

	}
	
	// return the root of the tree containing i
	public int find(int i) {
		// hvis man er forælderen af sig selv, så vi er roden.
		if(i==p[i]) return i;
		return find(p[i]);
	}
	
	// connect the two trees containing i and j
	public void union(int i, int j) {
		// implement this
		int root_i = find(i);
		int root_j = find(j);
		if(root_i!=root_j)
			p[root_i] = root_j;
	}
}

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

public class Hurtig_forening {
	public static void main(String[] args) throws IOException {
		new Hurtig_forening().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Quick_Union unionFind = new Quick_Union();

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
