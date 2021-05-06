package Dynamic_connectivity;
import java.io.*;
import java.util.*;

// implement the fast-find data structure
class UnionFind {
	int[] id;
	
	// initialize id to represent n sets of 1 element
	public void init(int n) {
		// sætter alle elementer til at være deres egen repræsentanter
		id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	// return the representative of the set containing i
	public int find(int i) {
		// returnere mængdes repræsentant som indeholder i.
		return id[i];
	}
	
	// unite the two sets containing i and j
	//such that the whole set of i is merged into j and all of j's representative are i's representatives.
	public void union(int i, int j) {
		// implement this
		int i_rep = find(i);
		int j_rep = find(j);
		if(i_rep!=j_rep){
			for (int k = 0; k < id.length; k++) {
				if(id[k] == i_rep)
					id[k] = j_rep;
			}
		}
	}
}

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################

public class Hurtig_Find {
	public static void main(String[] args) throws IOException {
		new Hurtig_Find().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		UnionFind unionFind = new UnionFind();
		
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
