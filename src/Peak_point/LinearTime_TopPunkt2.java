package Peak_point;
import java.util.Scanner;

public class LinearTime_TopPunkt2 {
    public static void main(String[] args) {
        int n;
        int [] A;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        LinearTime_TopPunkt2 obj = new LinearTime_TopPunkt2();
        int index = obj.FindMax(A,n);
        System.out.println(index);

    }

    public int FindMax(int [] A, int n){
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(A[i]>A[max]) max = i;
        }
        return max;
    }
}
