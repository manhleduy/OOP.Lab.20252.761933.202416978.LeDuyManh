import java.lang.reflect.Type;
import java.util.Scanner;
import java.lang.Math;
public class DayofMonth {
    public static void main(){
        Scanner sc= new Scanner(System.in);
        String month= sc.nextLine();
        int year= sc.nextInt();
        if (month.equals("January")||month.equals("Jan")|| month.equals("1")|| month.equals("Jan.")){
            Print(31);
        } else if(month.equals("February")||month.equals("Feb")|| month.equals("2")|| month.equals("Feb.")){
            if(isLeapYear(year)){
                Print(29);
            }
            Print(28);
        } else if(month.equals("March")||month.equals("Mar")|| month.equals("3")|| month.equals("Mar.")){
            Print(31);
        } else if(month.equals("April")||month.equals("Apr")|| month.equals("4")|| month.equals("Apr.")){
            Print(30);
        } else if (month.equals("May")){
            Print(31);
        } else if(month.equals("June")|| month.equals("6")|| month.equals("Jun")){
            Print(30);
        } else if(month.equals("July")|| month.equals("Jul")|| month.equals("7")){
            Print(31);
        } else if(month.equals("August")|| month.equals("Aug.")||month.equals("Aug")|| month.equals("8")){
            Print(31);
        } else if(month.equals("September")|| month.equals("Sept.")|| month.equals("Sep")|| month.equals("9")){
            Print(30);
        } else if(month.equals("October")|| month.equals("Oct.")|| month.equals("Oct")|| month.equals("10")){
            Print(31);
        } else if(month.equals("November")|| month.equals("Nov.")|| month.equals("Nov")|| month.equals("11")){
            Print(30);
        } else if(month.equals("December")|| month.equals("Dec.")|| month.equals("Dec")|| month.equals("12")){
            Print(31);
        }

    }
    static boolean isLeapYear(int year){
        int temp= Math.abs(2024-year)%4;
        if(temp==0)return true;
        return false;
    }
    static void Print(int day){
        System.out.print(day);
    }
}
