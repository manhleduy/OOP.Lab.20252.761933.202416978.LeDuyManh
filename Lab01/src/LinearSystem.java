import java.util.Scanner;

public class LinearSystem {
    public static void main(String[] args){
        double a11=Input(), a12=Input()
                , a21=Input(), a22=Input()
                , b1=Input(), b2= Input();
        double D= a11*a22-a21*a12;
        double D1= b1*a22-b2*a12;
        double D2= a11*b2-a21*b1;
        if(D==0){
            if(D1==0 && D2==0){
                System.out.print("there are infinite solution");
            }else{
                System.out.print("there are no solution");
            }
            return;
        }
        System.out.print("x1= "+D/D1);
        System.out.print("x2= "+D/D2);
    }
    static double Input(){
        Scanner sc= new Scanner(System.in);
        return sc.nextDouble();
    }
}
