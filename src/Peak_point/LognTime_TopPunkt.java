package Peak_point;
import java.util.Scanner;

public class LognTime_TopPunkt {
    public static void main(String[] args) {
        int n;
        int [] A;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        LognTime_TopPunkt obj = new LognTime_TopPunkt();
        int index = obj.FindRecursive(A,0,n-1);
        System.out.println(index);

    }
// because we want to save the last i and start j indexes, that's why we give them as parameter.
    public int FindRecursive(int [] A, int i,int j) {
        if (i == j) return i;
        int m = (i+j)/2;
        if(A[m-1]<= A[m] && A[m]>= A[m+1]) return m;
        if(A[m-1]>A[m]) return FindRecursive(A,i,m-1);
        else if(A[m+1]> A[m]) return FindRecursive(A,m+1,j);
        return 0;
    }
}
