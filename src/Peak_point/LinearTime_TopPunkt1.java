package Peak_point;
import java.util.Scanner;

public class LinearTime_TopPunkt1 {
    public static void main(String[] args) {
        int n;
        int [] A;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        LinearTime_TopPunkt1 obj = new LinearTime_TopPunkt1();
        int index = obj.FindMax(A,n);
        System.out.println(index);

    }

    public int FindMax(int [] A, int n) {
        if (A[0]>= A[1]) return 0;
        for (int i = 1; i < n - 1; i++) {
            if (A[i - 1] <= A[i] && A[i] >= A[i + 1]) return i;
        }
        if (A[n - 1] >= A[n - 2]) return n - 1;
        return 0;
    }
}
