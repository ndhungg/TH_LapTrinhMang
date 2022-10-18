
package mang;
import java.util.Scanner;


public class Mang {

    public static void main(String[] args) {
        int m;
        int n;
        Scanner sc = new Scanner(System.in);
        
        // nhap so dong so cot       
        do {
            System.out.println("Nhập vào số dòng của ma trận:");
            m = sc.nextInt();
            System.out.println("Nhập vào số cột của ma trận:");
            n = sc.nextInt();
        } while (m < 1|| n < 1 );
        
        //nhap phan tu ma tran
        int a[][]= new int [m][n];
        System.out.println("Nhập các phần tử cho ma trận a đều lớn hơn 0 và nhỏ hơn 100:");
        int i;
        int j = 0;
         for ( i = 0; i < m; i++) {
                for ( j = 0; j < n; j++) { 
        do{
                      
                  System.out.print("a[" + i + "," + j + "] = ");
                    a[i][j] = sc.nextInt();
              
        
        }while(a[i][j] < 0 && a[i][j] > 100);         
          }
        }
        //xuat ma tran
         System.out.println("Ma trận a vừa nhập:");
         for ( i = 0; i < m; i++) {
            for ( j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
             }
         System.out.println("\n");
       }
         
          // tim max
         int max = a[0][0];
         for (i = 0; i < m; i++) {
            for ( j = 0; j < n; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }
                }
            }
          System.out.println("Phần tử lớn nhất trong ma trận = " + max + " tại vị trí "+ i +" " +" " + j );
          
         //xuat ma tran sap xep tang theo cot
            for(int k = 0; k<m ; k++)
            for( i = 0; i<n-1 ; i++)
                 for( j = n-1; j>i ; j--)
                    if(a[i][k]<a[i-1][k])
                    {
                        int temp = a[i][k];
                        a[i][k] = a[i-1][k];
                        a[k][j-1] = temp;
        }
          System.out.println("ma trận sau khi sắp xếp:\n");
             for ( i = 0; i < m; i++) {
            for ( j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
             }
         System.out.println("\n");
       }


    
    }
    //sap xep tang theo cot
     public static void SXtangcot(int a[][],int m, int n){
        for(int k = 0; k<m ; k++)
            for(int i = 0; i<n-1 ; i++)
                 for(int j = n-1; j>i ; j--)
                    if(a[i][k]<a[i-1][k])
                    {
                        int temp = a[i][k];
                        a[i][k] = a[i-1][k];
                        a[k][j-1] = temp;
        }
       }
    
    
}
