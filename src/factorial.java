public class factorial {

    public int getFactorial(int n){
        if(n==0)
            return 1;
        return n*getFactorial(n-1);
    }
    public static void main(String[] args) {
       factorial fac = new factorial();
        System.out.println(fac.getFactorial(5));
    }
    
}


