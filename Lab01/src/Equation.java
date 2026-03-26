import java.awt.print.Printable;
import java.util.Scanner;
import java.lang.Math;
public class Equation {
    public static void main(String[] args){
        LinearSystem();
    }
    static void SecondDegreeEquation(){
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
    static void LinearSystem(){
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
    static void LinearEquation(){

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