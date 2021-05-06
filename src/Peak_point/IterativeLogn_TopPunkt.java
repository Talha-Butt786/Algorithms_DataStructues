package Peak_point;
import java.util.Scanner;

public class IterativeLogn_TopPunkt {
    public static void main(String[] args) {
        int n;
        int [] A;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        IterativeLogn_TopPunkt obj = new IterativeLogn_TopPunkt();
        int index = obj.FindIterative(A,0,n-1);
        System.out.println(index);

    }
    // because we want to save the last i and start j indexes, that's why we give them as parameter.
    public int FindIterative (int [] A, int i,int j) {
        int m;
        while (i!=j){
            m = (i+j)/2;
            if(A[m-1]<= A[m] && A[m]>= A[m+1]) return m;
            if(A[m-1]>A[m]) j = m-1;
            else if(A[m+1]>A[m]) i = m+1;
        }
        return i;
    }
}
