import java.util.Scanner;

public class SecondDegreeEquation {
    public static void main(String[] args){
        double a= Input(), b=Input(), c=Input();
        double disciminant= b*b-4*a*c;
        if(a==0){
            if(b==0){
                System.out.print("There are no solution");
                return;
            }
            System.out.print(-c/b);
            return;
        }
        if(disciminant<0){
            System.out.print("there are no solution");
            return;
        }
        if(disciminant==0){
            System.out.print("there are only one solution: "+-b/(2*a));
            return;
        }
        System.out.println("x2= "+ (-b-Math.sqrt(disciminant))/2*a);

        System.out.println("x1= "+ (-b+Math.sqrt(disciminant))/2*a);
    }
    static double Input(){
        Scanner sc= new Scanner(System.in);
        return sc.nextDouble();
    }
}
