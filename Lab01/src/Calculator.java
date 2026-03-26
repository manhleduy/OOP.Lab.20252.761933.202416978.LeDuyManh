import java.util.Scanner;

public class Calculator {
    static void Print(double val){
        System.out.println(val);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        double num1, num2;
        num1= Double.parseDouble(sc.nextLine());
        num2= Double.parseDouble(sc.nextLine());
        Print(num1+num2);
        Print(num1-num2);
        Print(num1*num2);
        if(num2==0){
            System.out.print("num2 is 0");
        }
        Print(num1/num2);

    }

}
