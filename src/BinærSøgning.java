import java.util.Scanner;

public class BinærSøgning {
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
        BinærSøgning obj = new BinærSøgning();
        for (int i = 0; i < m; i++) {
            int index = obj.BinærSøg(A,0,n-1,M[i]);
            System.out.println(index);
        }

    }

    public int BinærSøg(int [] A, int i, int j, int x){
        if(i>j) return -1;
        int m = (i+j)/2;
        if(A[m]==x) return m;
        if(A[m]>x) return BinærSøg(A,i,m-1,x);
        if(A[m]< x) return BinærSøg(A,m+1,j,x);
        return -1;
    }
}
