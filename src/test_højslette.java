import java.util.Scanner;

public class test_højslette {
    public static void test(int []a,int n){
        int startindex = -1,localstart = -1;
        int length = 0,local_length = 0;
        if(n<3){
            startindex = -1;
            length = 0;
        }
        else if(n==3 && a[1]>a[0] && a[1]>a[2]){
            startindex = 1;
            length = 1;
        }else {
            for (int i = 1; i < n - 1; i++) {
                if (a[i] == a[i + 1]) {
                    if (a[i - 1] < a[i]) {
                        localstart = i;
                        local_length = 2;
                    } else if (localstart!=-1){
                        local_length = local_length + 1;
                    }
                }
                else if (a[i] > a[i + 1] && local_length > length) {
                    length = local_length;
                    startindex = localstart;
                    local_length = 0;
                    localstart = -1;
                } else {
                    local_length = 0;
                    localstart = -1;
                }
            }
        }
        System.out.println(startindex);
        System.out.println(length);
    }
    private static int[] findPlateau(int[] array){
        int[] result = new int[2];

        int currentStartVal = 0;
        int currentStart = -1;
        int currentLength = 0;

        int maxStart = -1;
        int maxLength = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i]==currentStartVal){
                //Increase length
                currentLength++;
                currentStartVal = array[i];
            }
            else if(array[i]>currentStartVal){
                //Start new length
                currentStart = i;
                currentLength = 1;
                currentStartVal = array[i];
            }
            else if(array[i]<currentStartVal){
                //End of length
                if (currentLength > maxLength){
                    maxStart = currentStart;
                    maxLength = currentLength;
                }
                else if(currentLength == maxLength){
                    if(maxStart>currentStart){
                        maxStart = currentStart;
                    }
                }
                currentStart = -1;
                currentStartVal = array[i];
                currentLength = -1;
            }



        }

        if (currentLength > maxLength) {
            result[1] = currentLength;
            result[0] = currentStart;
            maxStart = currentStart;
            maxLength = currentLength;
        }


        if(maxStart == -1 || maxLength <= 1){
            result[0] = -1;
            result[1] = 0;
        }else{
            result[0] = maxStart;
            result[1] = maxLength;
        }

        return result;
    }

    public static void main(String[] args) {
        int [] a,b;
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        test(a,n);
        /*b = findPlateau(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }*/

    }
}
