package Sorting_algorithms;

/**
 * Merge sort Algorithm O(nlog n)
 */
public class FletteSortering {
    public static void main(String[] args) {
        int n;
        int [] A;
       /* Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();*/
        A = new int[10];
        /*for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }*/
        for (int i = 5; i >= 0; i--) {
            A[i] = i;
        }
        FletteSortering obj = new FletteSortering();
        obj.Flettesort(A,0,A.length-1);
        for (int i = 0; i < 10; i++) {
            System.out.print(A[i] + " ");
        }

    }
    public void Flettesort(int [] A, int i, int j){
        if(i>=j) return;
        else
        {
            int m = (i + j) / 2;
            Flettesort(A,m+1,j);
            Flettesort(A,i,m);
            Flet(A,i,m,j);
        }

    }

    private void Flet(int[] a, int i, int m, int j) {
        int n1 = m-i+1;
        int n2 = j-m;
        int [] L = new int[n1+1];
        int [] R = new int[n2+1];
        for (int k = 1; k < n1+1; k++) {
            L[k-1] = a[i+k-1];
        }
        for (int k = 1; k < n2+1; k++) {
            R[k-1] = a[m+k];
        }

        L[n1]= Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        for (int k = i; k < j+1 ; k++) {
            if(L[l]<=R[r]) {
                a[k] = L[l];
                l++;
            }else {
                a[k] = R[r];
                r++;
            }
        }
    }
}
