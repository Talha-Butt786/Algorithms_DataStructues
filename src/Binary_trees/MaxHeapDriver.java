package Binary_trees;
import java.io.*;
import java.util.*;

class MaxHeap {
	
	private int[] elements = new int[10001];
	private int size = 0;

	public void insert(int e) {
		size = size+1;
		elements[size] = e;
		bubbleUp(size);
	}
	public int getSize(){
		return size;
	}

	private void bubbleUp(int x) {
		if(x!=1) {
			if (elements[parent(x)] < elements[x]) {
				int temp = elements[x];
				elements[x] = elements[parent(x)];
				elements[parent(x)] = temp;
				bubbleUp(parent(x));
			}
		}
	}

	public int extractMax() {
		int max = elements[1];
		elements[1] = elements[size];
		elements[size]=0;
		size--;
		bubbleDown(1);
		return max;
	}

	private void bubbleDown(int x) {
		if(elements[leftchild(x)]!=0 || elements[rightchild(x)]!=0) {
			if (elements[leftchild(x)] > elements[x] || elements[rightchild(x)] > elements[x]) {
				if (elements[leftchild(x)] >= elements[rightchild(x)] && leftchild(x)!=size){
					int temp = elements[x];
					elements[x] = elements[leftchild(x)];
					elements[leftchild(x)] = temp;
					bubbleDown(leftchild(x));
				} else if(rightchild(x)!=size && elements[rightchild(x)] > elements[leftchild(x)]) {
					int temp = elements[x];
					elements[x] = elements[rightchild(x)];
					elements[rightchild(x)] = temp;
					bubbleDown(rightchild(x));
				}
			}
		}
	}
	private int parent(int x){
		return x/2;
	}
	private int leftchild(int x){
		return 2*x;
	}
	private int rightchild(int x){
		return 2*x+1;
	}
	public void print(PrintWriter out) {
		for (int i = 1; i <= size; i++) {
			out.print(elements[i] + " ");
		}
		out.println();
	}
}


public class MaxHeapDriver
{
	public static void main(String[] args) throws IOException {
		new MaxHeapDriver().run();
	}

	private void run() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

		MaxHeap maxHeap = new MaxHeap();

		int N = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String type = st.nextToken();

			if (type.charAt(0) == 'I') {
				maxHeap.insert(Integer.parseInt(st.nextToken()));
			} else if (type.charAt(0) == 'E') {
				int max=maxHeap.extractMax();
				out.println(max);
			} else {
				maxHeap.print(out);
			}
		}
		out.flush();
	}

	private void testheap(){
		MaxHeap heap = new MaxHeap();
		heap.insert(5);
		heap.insert(3);
		heap.insert(9);
		heap.insert(2);
		heap.insert(1);
	}
}