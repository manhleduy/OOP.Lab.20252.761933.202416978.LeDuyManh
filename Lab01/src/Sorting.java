import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    int[] array= {1789, 2035, 1899, 1456, 2013};
    void main(String[] args){
        Arrays.sort(array);
        int sum=0;
        for(int i=0;i<5;i++){
            System.out.print(array[i]+" ");
            sum =sum+ array[i];
        }
        System.out.println();
        System.out.println("sum:"+ sum);
        System.out.println("avg:"+ sum/4);

    }

}
