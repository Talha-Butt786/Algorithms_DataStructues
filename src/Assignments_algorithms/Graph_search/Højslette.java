package Assignments_algorithms.Graph_search;
import java.util.Scanner;

public class Højslette {

    public static void højslette(int [] a, int n){
        int length = 0, locallength = 0;
        int startindex = -1, local_startindex = -1;
        for (int i = 1; i < n; i++) {
            if(a[i-1]<a[i]){
                local_startindex = i;
            }
            else if(a[i-1]>a[i] && local_startindex>-1) {
                locallength = i-local_startindex;
                if(locallength>length) {
                    length = locallength;
                    startindex = local_startindex;
                    local_startindex = -1;
                }else{
                    local_startindex = -1;
                }
            }
        }
        System.out.println(startindex+"\n"+length);
    }

    public static void main(String[] args) {
        int [] a;
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        højslette(a,n);
    }
}
