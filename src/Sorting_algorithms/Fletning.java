package Sorting_algorithms;
import java.util.Scanner;

public class Fletning {
    public static void main(String[] args) {
        int n,m;
        int [] A;
        int [] M;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        M = new int[m];
        for (int i = 0; i < m; i++) {
            M[i] = scanner.nextInt();
        }
        Fletning obj = new Fletning();
        int [] arr = obj.fletArrays(A,M);
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }

    public int [] fletArrays(int [] A, int [] B){
        int [] L = new int[A.length+1];
        int [] R = new int[B.length+1];
        for (int i = 0; i < A.length; i++) {
            L[i] = A[i];
        }
        for (int i = 0; i < B.length; i++) {
            R[i] = B[i];
        }
        L[A.length] = Integer.MAX_VALUE;
        R[B.length] = Integer.MAX_VALUE;

        int n = A.length +B.length;
        int [] C = new int[n];
        int l = 0;
        int r = 0;
        for (int i = 0; i < C.length ; i++) {
                if(L[l]<=R[r]) {
                    C[i] = L[l];
                    l++;
                }else {
                        C[i] = R[r];
                        r++;
                    }
        }
        return C;
    }
}
