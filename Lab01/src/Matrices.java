public class Matrices {
    public static void main(String[] args){
        int [][] matrix1={{1,2},{3,4}};
        int [][] matrix2={{5,6},{7,8}};
        int [][] sumMatrix= new int[2][2];
        for(int i=0;i<=1;i++){
            for(int j=0;j<=1;j++){
                sumMatrix[i][j]= matrix1[i][j]+matrix2[i][j];
                System.out.print(sumMatrix[i][j]+ " ");

            }
            System.out.println();
        }

    }
}
//add two matrices of the same size