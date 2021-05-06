package Binary_trees;
import java.io.*;
import java.util.*;

class Node_t {
	public int value;
	public Node_t left, right;
}

public class TreeHeight
{
	// Given the root node of a binary tree, this method should
	// recursively determine the height of the tree.
	public int height(Node_t root) {
		if(root==null) return 0;
		if(root.left==null&&root.right==null) return 0;
		return 1+Math.max(height(root.left),height(root.right));
	}

	// ##################################################
	// # You do not need to modify anything below here. #
	// ##################################################
	public static void main(String[] args) throws IOException {
		new TreeHeight().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		Node_t[] nodes = new Node_t[N];
		nodes[0] = new Node_t();
		nodes[0].value = Integer.parseInt(in.readLine());

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int parent = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			int value = Integer.parseInt(st.nextToken());

			Node_t newNode = new Node_t();
			nodes[i] = newNode;
			newNode.value = value;

			if (type.equals("L")) {
				nodes[parent].left = newNode;
			} else {
				nodes[parent].right = newNode;
			}
		}

		System.out.println(height(nodes[0]));
	}
}