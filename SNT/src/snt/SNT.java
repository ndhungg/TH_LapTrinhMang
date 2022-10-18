
package snt;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class SNT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        Boolean a = false;
        while(a == false){
            try{
                System.out.print("Nhập n = ");
                 n = sc.nextInt();
                 a=true;
            }
            catch(Exception ex){
                 sc.nextInt();
            }
        }
        if(n<0)
                n = n*-1;
        System.out.printf("Tất cả các số nguyên tố nhỏ hơn %d là: \n", n);
        if (n >= 2) {
            System.out.print(2);
        }
        for (int i = 3; i < n; i+=2) {
            if (isPrimeNumber(i)) {
                System.out.print(" " + i);
            }
        }
         System.out.print("\n");
    }
    public static boolean isPrimeNumber(int n) {

        if (n < 2) {
            return false;
        }

        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
