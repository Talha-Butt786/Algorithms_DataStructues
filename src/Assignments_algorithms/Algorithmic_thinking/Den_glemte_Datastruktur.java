package Assignments_algorithms.Algorithmic_thinking;
import java.util.Scanner;
import java.util.Stack;

public class Den_glemte_Datastruktur {
    public static void find_datastruktur(int size,String[]a) throws Exception {
        int elementcount = 0, popcount = 0, qeuecount = 0;
        Stack_Array stack_array = new Stack_Array(size);
        Queue_Array queue = new Queue_Array(size);
        for (int i = 0; i < size; i++) {
            boolean localstack,localqueue;
            if(a[i].split(" ")[0].equals("I")) {
                int element = Integer.parseInt(a[i].split(" ")[1]);
                stack_array.push(element);
                queue.enqueue(element);
            }
            if(a[i].split(" ")[0].equals("E")) {
                int element = Integer.parseInt(a[i].split(" ")[1]);
                int pop_element_stack = stack_array.pop();
                int dequeue_element = queue.dequeue();
                elementcount++;
                if(element == pop_element_stack) popcount++;
                if(element == dequeue_element) qeuecount++;
            }
        }
        if (popcount == elementcount) {
            System.out.println("YES");
        }else
            System.out.println("NO");
        if(qeuecount==elementcount) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        int n;
        String []a;
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLine();
        }
        find_datastruktur(n, a);
    }
}
