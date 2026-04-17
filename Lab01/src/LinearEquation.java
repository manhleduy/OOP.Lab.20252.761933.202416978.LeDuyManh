import java.util.Scanner;

public class LinearEquation {
    public static void main(String[] args){
        double a= Input();
        double b= Input();
        if(a==0){
            System.out.print("infinite solution");
            return;
        }
        System.out.print(-b/a);
    }
    static double Input(){
        Scanner sc= new Scanner(System.in);
        return sc.nextDouble();
    }
}
